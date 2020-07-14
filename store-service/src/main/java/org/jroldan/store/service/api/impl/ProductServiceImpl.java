package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.dao.repositories.ProductRepository;
import org.jroldan.store.entity.Product;
import org.jroldan.store.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>)productRepository.findAll();
	}

	@Override
	public boolean exists(Product entity) {
		return productRepository.existsById(entity.getIdProduct());
	}

	@Override
	public boolean existsById(Long id) {
		return productRepository.existsById(id);
	}

	@Override
	public Product saveOrUpdate(Product entity) {
		return productRepository.save(entity);
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findProductsByIdOrder(Long idOrder) {
		return productRepository.findProductsByIdOrder(idOrder);
	}

}
