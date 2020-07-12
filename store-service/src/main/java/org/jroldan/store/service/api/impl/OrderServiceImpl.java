package org.jroldan.store.service.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.jroldan.store.dao.repositories.OrderRepository;
import org.jroldan.store.entity.Order;
import org.jroldan.store.entity.ProductLine;
import org.jroldan.store.entity.ProductLineId;
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

	@Override
	public Order validateAndCreateOrder(Order order) {
		// TODO ROLDAN: Validate there is enough stock for each Product
		
		// Extract and backup gotten productLines info
		List<ProductLine> plBackup = order.getProductLines();
		
		// We need first of all our new order ID, so we create a new order with no Product Lines
		order.setProductLines(null);
		Order createdOrder = orderRepository.save(order);
		
		// Once we know the generated id for the new Order, we set again Product Lines to persist them
		createdOrder.setProductLines(plBackup);
		
		for (int i = 0; i < createdOrder.getProductLines().size(); i++) {
			createdOrder.getProductLines().get(i).setId(
					new ProductLineId(createdOrder.getIdOrder(), order.getProductLines().get(i).getProduct().getIdProduct()));
		}
		
		// TODO ROLDAN: Update new stock
		
		return orderRepository.save(createdOrder);
	}
	

}
