package com.educaciencia.demo.entities.enums;

public enum OrderStatus {
	WAITTING_PAYMENT(1),
	PAID(2),
	SHIPPER(3),
	DELIVERY(4),
	CANCELED(5);
	
	private int code;
	
	//para receber os codigos criados
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//para ser acessivel
	public int getCode() {
		return code;
	}
	
	//metodo para covnerter numero para tipo numerado
	public static OrderStatus valueOf(int code) {
		//percorrer todos os valores criados
		for (OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código Invalido - OrderStatus - code");
	}
}
