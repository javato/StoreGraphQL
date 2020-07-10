package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.entity.Order;
import org.jroldan.store.service.api.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	private static final long serialVersionUID = 1L;

	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Order entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order saveOrUpdate(Order entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(Order entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
