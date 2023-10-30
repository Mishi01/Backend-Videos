package com.backend.app.store.models;

public class Store {
	private Mouse mouse;
	private Integer cantidad;
	
	public Store() {
		
	}
	
	public Store(Mouse mouse, Integer cantidad) {
		this.mouse = mouse;
		this.cantidad = cantidad;
	}
	public Mouse getMouse() {
		return mouse;
	}
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

//	public Double getTotal() {
//		return product.getPrice()*cantidad.doubleValue();
//	}
	
}
