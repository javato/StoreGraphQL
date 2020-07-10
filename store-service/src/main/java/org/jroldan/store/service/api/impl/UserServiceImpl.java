package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.entity.User;
import org.jroldan.store.service.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private static final long serialVersionUID = 1L;

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
