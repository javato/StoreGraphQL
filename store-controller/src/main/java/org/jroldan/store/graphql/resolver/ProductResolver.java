package org.jroldan.store.graphql.resolver;

import org.jroldan.store.entity.Product;
import org.jroldan.store.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class ProductResolver implements GraphQLQueryResolver{
	
	@Autowired
	ProductService productService;
	
	public Product getProduct(Long idProduct) {
		return productService.findById(idProduct);
	}
}
