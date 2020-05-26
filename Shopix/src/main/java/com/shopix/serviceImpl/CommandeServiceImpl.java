package com.shopix.serviceImpl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.shopix.beans.Commande;
import com.shopix.beans.User;
import com.shopix.service.CommandeService;
@Service
public class CommandeServiceImpl implements CommandeService {

	@Override
	public Commande findByRef(String ref) {
		return null;
	}

	@Override
	public Collection<Commande> findAllByUser(User user) {
		return null;
	}

}
