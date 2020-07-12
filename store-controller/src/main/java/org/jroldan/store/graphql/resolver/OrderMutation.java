package org.jroldan.store.graphql.resolver;


import org.jroldan.store.entity.Order;
import org.jroldan.store.service.api.OrderService;
import org.jroldan.store.service.api.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class OrderMutation implements GraphQLMutationResolver{
	
	@Autowired
	OrderService orderService;
	@Autowired
	ProductLineService productLineService;
	
	public Order newOrder(Order order) {		
		return orderService.validateAndCreateOrder(order);
	}
	
}
