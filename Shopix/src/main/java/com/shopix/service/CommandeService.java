package com.shopix.service;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.shopix.beans.Commande;
import com.shopix.beans.User;

public interface CommandeService {
public Commande findByref(String ref);
public Collection<Commande>  findAllByUser(User user);
public Collection<Commande> findAll();
public ResponseEntity<?> save(String email, String password, Commande commande);
}
