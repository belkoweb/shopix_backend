package com.shopix.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopix.beans.Adresse;
import com.shopix.beans.User;
import com.shopix.dao.AdresseDao;
import com.shopix.service.AdresseService;
import com.shopix.service.UserService;

@Service
public class AdresseServiceImpl implements AdresseService {
	@Autowired
	private AdresseDao adresseDao;
	@Autowired
	private UserService userService;

	@Override
	public Collection<Adresse> findAllByVille(String ville) {
		return null;
	}

	@Override
	public Collection<Adresse> findAllByPays(String pays) {
		return null;
	}

	@Override
	public  ResponseEntity<?> save(String email, String password, Adresse adresse) {
		User user = userService.findByEmailAndPassword(email, password);
		Adresse res = adresseDao.findByadresse1(adresse.getAdresse1());
		if (user != null) {
			if(res == null) {
				adresse.setUser(user);
				adresseDao.save(adresse);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
           return new ResponseEntity<>(HttpStatus.CONFLICT);  
		}

}
