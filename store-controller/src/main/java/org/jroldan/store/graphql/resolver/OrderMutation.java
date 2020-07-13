package org.jroldan.store.graphql.resolver;


import org.jroldan.store.entity.Order;
import org.jroldan.store.exception.CustomControllerException;
import org.jroldan.store.exception.NotEnoughStockException;
import org.jroldan.store.service.api.OrderService;
import org.jroldan.store.service.api.ProductLineService;
import org.jroldan.store.service.commons.CustomServiceException;
import org.jroldan.store.service.commons.NotEnoughStockServiceException;
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
		try {
			return orderService.validateAndCreateOrder(order);
		} catch (NotEnoughStockServiceException e) {
			throw new NotEnoughStockException(e.getMessage());
		} catch (CustomServiceException e) {
			throw new CustomControllerException(e.getMessage());
		}
	}
	
}
