package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository ur;
	
	@Override
	public Users save(Users entity) {
		return ur.save(entity);
	}

	@Override
	public Optional<Users> findById(String id) {
		return ur.findById(id);
	}

	@Override
	public List<Users> findAll() {
		return (List<Users>)ur.findAll();
	}

	@Override
	public List<Users> findAllById(List<String> ids) {
		return (List<Users>)ur.findAllById(ids);
	}

	@Override
	public long count() {
		return ur.count();
	}

	@Override
	public void deleteById(String id) {
		ur.deleteById(id);
	}

	@Override
	public void delete(Users entity) {
		ur.delete(entity);
	}

	@Override
	public void deleteAll() {
		ur.deleteAll();
	}

	
}
