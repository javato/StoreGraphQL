package org.jroldan.store.graphql.resolver;

import java.util.List;

import org.jroldan.store.entity.User;
import org.jroldan.store.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class UserQuery implements GraphQLQueryResolver{
	@Autowired
	UserService userService;
	
	public User getUser(Long idUser) {
		return userService.findById(idUser);
	}
	
	public List<User> getAllUsers() {
		return userService.findAll();
	}
}
