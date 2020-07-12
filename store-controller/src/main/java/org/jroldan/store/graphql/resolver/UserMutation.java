package org.jroldan.store.graphql.resolver;

import org.jroldan.store.entity.User;
import org.jroldan.store.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;


@Component
public class UserMutation implements GraphQLMutationResolver{
	
	@Autowired
	UserService userService;
	
	public User saveUser(User user) {
		return userService.saveOrUpdate(user);
	}
	
	public Boolean deleteUser(Long id) {
		try {
			userService.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
}
