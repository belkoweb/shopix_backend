package com.shopix.service;

import java.util.Collection;

import com.shopix.beans.Commande;
import com.shopix.beans.User;

public interface CommandeService {
public Commande findByref(String ref);
public Collection<Commande>  findAllByUser(User user);
public int save(Commande commande);
public Collection<Commande> findAll();
}
