package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.dao.repositories.OrderRepository;
import org.jroldan.store.entity.Order;
import org.jroldan.store.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public List<Order> findAll() {
		return (List<Order>)orderRepository.findAll();
	}

	@Override
	public boolean exists(Order entity) {
		return orderRepository.existsById(entity.getIdOrder());
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public Order saveOrUpdate(Order entity) {
		return orderRepository.save(entity);
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

}
