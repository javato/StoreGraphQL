package org.jroldan.store.service.api.impl;

import java.util.List;

import org.jroldan.store.dao.repositories.UserRepository;
import org.jroldan.store.entity.User;
import org.jroldan.store.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}

	@Override
	public boolean exists(User entity) {
		return userRepository.existsById(entity.getIdUser());
	}

	@Override
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public User saveOrUpdate(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
