package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.entity.ProductLine;
import org.jroldan.store.entity.ProductLineId;
import org.jroldan.store.service.api.ProductLineService;
import org.springframework.stereotype.Service;

@Service
public class ProductLineServiceImpl implements ProductLineService{

	private static final long serialVersionUID = 1L;

	@Override
	public ProductLine findById(ProductLineId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductLine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(ProductLine entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(ProductLineId id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductLine saveOrUpdate(ProductLine entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(ProductLine entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductLine entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(ProductLineId id) {
		// TODO Auto-generated method stub
		
	}

}
