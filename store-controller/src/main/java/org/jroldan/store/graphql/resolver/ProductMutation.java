package org.jroldan.store.graphql.resolver;

import org.jroldan.store.entity.Product;
import org.jroldan.store.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class ProductMutation implements GraphQLMutationResolver{
	
	@Autowired
	ProductService productService;
	
	public Product saveProduct(Product product) {
		return productService.saveOrUpdate(product);
	}
	
	public Product updateStock(Long idProduct, Long stock) {
		Product productFound = productService.findById(idProduct);
		productFound.setStock(stock);
		return productService.saveOrUpdate(productFound);
	}
	
	public Boolean deleteProduct(Long idProduct) {
		try {
			productService.deleteById(idProduct);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
