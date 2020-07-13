package org.jroldan.store.service.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.jroldan.store.dao.repositories.OrderRepository;
import org.jroldan.store.dao.repositories.ProductRepository;
import org.jroldan.store.entity.Order;
import org.jroldan.store.entity.Product;
import org.jroldan.store.entity.ProductLine;
import org.jroldan.store.entity.ProductLineId;
import org.jroldan.store.entity.User;
import org.jroldan.store.service.api.OrderService;
import org.jroldan.store.service.commons.CustomServiceException;
import org.jroldan.store.service.commons.NotEnoughStockServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;

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
	public Order validateAndCreateOrder(Order order) throws NotEnoughStockServiceException {
		HashMap<Long, Product> mapProductStock = new HashMap<Long, Product>();
		
		// Validate gotten Products info
		productsValidator(order, mapProductStock);
		
		List<ProductLine> backupPL = order.getProductLines();
		order.setProductLines(null);
		orderRepository.save(order);
		
		// Set idOrder to each ProductLine
		order.setProductLines(backupPL);
		for (int i = 0; i < order.getProductLines().size(); i++) {
			order.getProductLines().get(i).setId(
					new ProductLineId(order.getIdOrder(), order.getProductLines().get(i).getProduct().getIdProduct()));
			
		}
		orderRepository.save(order);
		
		// Calculate new stock and save it
		calculateAndSaveStock(mapProductStock, order);
		
		return orderRepository.findById(order.getIdOrder()).get();
	}

	/**
	 * @param mapProductStock
	 * @param persistedOrder
	 */
	private void calculateAndSaveStock(HashMap<Long, Product> mapProductStock, Order persistedOrder) {
		for (int i = 0; i < persistedOrder.getProductLines().size(); i++) {
			// Updating stock on productsMap
			Product productMap = mapProductStock.get(persistedOrder.getProductLines().get(i).getProduct().getIdProduct());
			productMap.setStock(productMap.getStock() - persistedOrder.getProductLines().get(i).getQuantity());
		}
		// Save updated stock
		productRepository.saveAll(mapProductStock.values());
	}

	/**
	 * @param order
	 * @param mapProductStock
	 * @throws Exception
	 */
	private void productsValidator(Order order, HashMap<Long, Product> mapProductStock) throws RuntimeException {
		Product product;
		for (int i = 0; i < order.getProductLines().size(); i++) {
			try {
				product = productRepository.findById(
					order.getProductLines().get(i).getProduct().getIdProduct()).get();
			}
			catch(NoSuchElementException ex) {
				throw new CustomServiceException("Product with id {" + 
						order.getProductLines().get(i).getProduct().getIdProduct() +
						"} does not exist");
			}
			
			if(order.getProductLines().get(i).getQuantity() > product.getStock()) {
				// there is no enough stock for the provided quantity
				throw new NotEnoughStockServiceException("Not enough stock for the product with id {" +
						product.getIdProduct() + "} (stock=" + product.getStock() + ")");
			}
			mapProductStock.put(product.getIdProduct(), product);
		}
	}

	@Override
	public List<Order> findByUser(User User) {
		return orderRepository.findByUser(User);
	}

	

}
