package org.jroldan.store.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_LINE")
public class ProductLine {
	
	@EmbeddedId
	private ProductLineId id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id_product", insertable = false, updatable = false)
	private Product product;
	
	@Column
	private Long quantity;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
