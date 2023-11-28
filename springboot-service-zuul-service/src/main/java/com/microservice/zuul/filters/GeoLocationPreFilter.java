package com.microservice.zuul.filters;

import java.io.File;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class GeoLocationPreFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(GeoLocationPreFilter.class);
    private DatabaseReader dbReader;

    public GeoLocationPreFilter() {
        try {
            File database = new File("C://Users//netra//Downloads//GeoLite2-City_20231031/GeoLite2-City.mmdb");
            dbReader = new DatabaseReader.Builder(database).build();
        } catch (Exception e) {
            log.error("Error al cargar la base de datos de geolocalización: " + e.getMessage());
        }
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("Entrando a filtro pre de adaptación de contenido");

        String clientIP = request.getRemoteAddr();

        if (!"0:0:0:0:0:0:0:1".equals(clientIP)) {
            try {
                InetAddress ipAddress = InetAddress.getByName(clientIP);
                CityResponse response = dbReader.city(ipAddress);

                String userLocation = response.getCity().getName();

                request.setAttribute("userLocation", userLocation);
                log.info(userLocation);

            } catch (Exception e) {
                log.error("Error al obtener la ubicación geográfica: " + e.getMessage());
            }
        }

        return null;
    }

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}}