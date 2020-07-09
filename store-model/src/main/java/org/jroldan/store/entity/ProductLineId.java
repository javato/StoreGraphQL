package org.jroldan.store.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductLineId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "id_order")
	private Long idOrder;
	
	@Column(name = "id_product")
	private Long idProduct;
	
	

	public ProductLineId() {
		
	}

	public ProductLineId(Long idOrder, Long idProduct) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        ProductLineId that = (ProductLineId) o;
        return Objects.equals(idOrder, that.idOrder) &&
               Objects.equals(idProduct, that.idProduct);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idProduct);
    }

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	
}
