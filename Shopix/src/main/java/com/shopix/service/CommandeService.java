package com.shopix.service;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.shopix.beans.Commande;
import com.shopix.beans.User;

public interface CommandeService {
public Commande findByref(String ref);
public Commande update(Long id, Commande commande);
public void delete(Long id);
public Collection<Commande>  findAllByUser(User user);
public Collection<Commande> findAll();
public int save(String email, String password, Commande commande);
}
