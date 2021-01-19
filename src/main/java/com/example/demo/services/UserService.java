package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;

public interface UserService {

	void deleteAll();

	void delete(Users entity);

	void deleteById(String id);

	long count();

	List<Users> findAllById(List<String> ids);

	List<Users> findAll();

	Optional<Users> findById(String id);

	Users save(Users entity);

	

}
