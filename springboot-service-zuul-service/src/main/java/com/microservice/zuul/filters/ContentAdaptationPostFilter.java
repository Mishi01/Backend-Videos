package com.microservice.zuul.filters;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

@Component
public class ContentAdaptationPostFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ContentAdaptationPostFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("Entrando a filtro post de adaptación de contenido");

        String userLocation = (String) request.getAttribute("userLocation");
        log.info(userLocation);

        if (userLocation != null) {
 
            InputStream responseDataStream = ctx.getResponseDataStream();
            try {
                String responseBody = readResponseBody(responseDataStream);

                responseBody = "Contenido adaptado para la ubicación: " + userLocation;

                ctx.setResponseBody(responseBody);
            } catch (IOException e) {
                log.error("Error al leer el cuerpo de la respuesta: " + e.getMessage());
            }
        }
        else {
            log.info("Estas accediendo desde una ip bucle local, BIENVENIDA A MEXICO");
        }
        

        return null;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2; 
    }

    private String readResponseBody(InputStream responseDataStream) throws IOException {
        try (Reader reader = new InputStreamReader(responseDataStream);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                responseBody.append(line);
            }
            return responseBody.toString();
        }
    }
}
