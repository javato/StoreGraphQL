package org.jroldan.store.dao.repositories;

import java.util.List;

import org.jroldan.store.dao.api.Dao;
import org.jroldan.store.entity.Product;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends Dao<Product, Long>{
	@Query("SELECT p FROM Order o, ProductLine pl, Product p "
			+ "where pl.id.idOrder=o.idOrder and p.idProduct = pl.id.idProduct and o.idOrder = ?1")
	List<Product> findProductsByIdOrder(Long idOrder);
}
