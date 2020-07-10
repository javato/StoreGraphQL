package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.dao.repositories.ProductLineRepository;
import org.jroldan.store.entity.ProductLine;
import org.jroldan.store.entity.ProductLineId;
import org.jroldan.store.service.api.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLineServiceImpl implements ProductLineService{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ProductLineRepository prodLineRepository;

	@Override
	public ProductLine findById(ProductLineId id) {
		return prodLineRepository.findById(id).get();
	}

	@Override
	public List<ProductLine> findAll() {
		return (List<ProductLine>)prodLineRepository.findAll(); 
	}

	@Override
	public boolean exists(ProductLine entity) {
		return prodLineRepository.existsById(entity.getId());
	}

	@Override
	public boolean existsById(ProductLineId id) {
		return prodLineRepository.existsById(id);
	}

	@Override
	public ProductLine saveOrUpdate(ProductLine entity) {
		return prodLineRepository.save(entity);
	}

	@Override
	public void delete(ProductLine entity) {
		prodLineRepository.delete(entity);
	}

	@Override
	public void deleteById(ProductLineId id) {
		prodLineRepository.deleteById(id);
	}

}
