package org.jroldan.store.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@Column(name = "id_order")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder;
	
	@OneToMany(mappedBy="id.idOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductLine> productLines = new ArrayList<ProductLine>();
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	public Long getIdOrder() {
		return idOrder;
	}	

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProductLine> getProductLines() {
		return productLines;
	}

	public void setProductLines(List<ProductLine> productLines) {
		this.productLines = productLines;
	}
}
