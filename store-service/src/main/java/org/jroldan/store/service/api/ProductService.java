package org.jroldan.store.service.api;

import java.util.List;

import org.jroldan.store.entity.Product;
import org.jroldan.store.service.commons.CrudServiceCustom;

public interface ProductService extends CrudServiceCustom<Product, Long>{
	List<Product> findProductsByIdOrder(Long idOrder);
}
