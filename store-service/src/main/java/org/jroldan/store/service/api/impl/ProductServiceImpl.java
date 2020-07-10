package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.entity.Product;
import org.jroldan.store.service.api.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	private static final long serialVersionUID = 1L;

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Product entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product saveOrUpdate(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
