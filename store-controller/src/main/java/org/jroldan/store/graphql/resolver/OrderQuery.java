package org.jroldan.store.graphql.resolver;

import java.util.List;

import org.jroldan.store.entity.Order;
import org.jroldan.store.entity.User;
import org.jroldan.store.service.api.OrderService;
import org.jroldan.store.service.api.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class OrderQuery implements GraphQLQueryResolver{
	@Autowired
	OrderService orderService;
	@Autowired
	ProductLineService productLineService;
	
	public Order getOrder(Long idOrder) {
		return orderService.findById(idOrder);
	}
	
	public List<Order> getAllOrders() {
		List<Order> result = orderService.findAll();
		return result;
	}
	
	public List<Order> getOrdersByUser(User user){
		return orderService.findByUser(user);
	}
}
