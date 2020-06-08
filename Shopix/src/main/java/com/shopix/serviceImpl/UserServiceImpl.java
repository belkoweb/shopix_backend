package com.shopix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopix.beans.User;
import com.shopix.dao.UserDao;
import com.shopix.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User findByNom(String nom) {
		return userDao.findByNom(nom);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}

	@Override
	public ResponseEntity<?> save(User user) {

		User userLoaded = findByEmail(user.getEmail());
		if (userLoaded != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(userDao.save(user), HttpStatus.CREATED);
	}

}
