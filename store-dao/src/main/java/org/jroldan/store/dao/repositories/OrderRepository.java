package org.jroldan.store.dao.repositories;

import java.util.List;

import org.jroldan.store.dao.api.Dao;
import org.jroldan.store.entity.Order;
import org.jroldan.store.entity.User;

public interface OrderRepository extends Dao<Order, Long>{
	List<Order> findByUser(User User);
}
