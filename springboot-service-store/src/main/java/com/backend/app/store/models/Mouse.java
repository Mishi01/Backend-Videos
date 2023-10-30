package com.backend.app.store.models;

import java.util.Date;


public class Mouse {

	private Long id;
	
	private String name;
	
	private String marca;

	private Date createAt;
	
	private Integer port;
	
	public Mouse(Long id, String name, String marca) {
		this.id = id;
		this.name= name;
		this.marca = marca;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
}
