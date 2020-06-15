package com.shopix.service;

import java.util.Collection;
import java.util.List;

import com.shopix.beans.Commande;
import com.shopix.beans.User;

public interface CommandeService {
public Commande findByref(String ref);
public Collection<Commande>  findAllByUser(User user);
public Collection<Commande> findAll();
public int save(String email, String password, Commande commande);
public Long nbrCommandes();

public Long countByEtatCommande(String etatCommande);
}
