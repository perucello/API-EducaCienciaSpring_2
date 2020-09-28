package com.educaciencia.demo.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educaciencia.demo.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId //porque é chave estrangeira
	private OrderItemPK id = new  OrderItemPK(); //se nao instanciar vai estourar npe
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order); //instanciando id do order
		id.setProduct(product); //instanciando id do Produto
		this.quantity = quantity;
		this.price = price;
	}
		
	//informando pedido e metodo informa pedido
	@JsonIgnore
		public Order getOrder() {
		return id.getOrder();
	}
	
	//informando pedido e metodo informa pedido
	public void SetOrder (Order order) {
		id.setOrder(order);
	}
	
	
	//informando produto e metodo informa produto	
	//@JsonIgnore
	public Product getProduct() {
		return id.getProduct();
	}
	
	//informando produtoo e metodo informa produto	
	public void SetProduct(Product product) {
		id.setProduct(product);
	}
	
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	//criando metodo para devolver SUbtotal da compra
	public Double getSubTotal() {
		return price * quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
