package org.jroldan.store.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_LINE")
public class ProductLine {
	
	@EmbeddedId
	private ProductLineId id;
	
	@ManyToOne
	@MapsId("idProduct")
	private Product product;
	
	@ManyToOne
	@MapsId("idOrder")
	private Order order;
	
	@Column
	private Long quantity;
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public ProductLineId getId() {
		return id;
	}

	public void setId(ProductLineId id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
