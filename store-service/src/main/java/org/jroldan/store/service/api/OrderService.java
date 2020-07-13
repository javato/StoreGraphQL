package org.jroldan.store.service.api;

import java.util.List;

import org.jroldan.store.entity.Order;
import org.jroldan.store.entity.User;
import org.jroldan.store.service.commons.CrudServiceCustom;
import org.jroldan.store.service.commons.NotEnoughStockServiceException;

public interface OrderService extends CrudServiceCustom<Order, Long>{
	public Order validateAndCreateOrder(Order order) throws NotEnoughStockServiceException;
	List<Order> findByUser(User User);
}
