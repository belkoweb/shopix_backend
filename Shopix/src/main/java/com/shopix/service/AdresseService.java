package com.shopix.service;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.shopix.beans.Adresse;

public interface AdresseService {
public Collection<Adresse> findAllByVille(String ville);
public Collection<Adresse> findAllByPays(String pays);
public ResponseEntity<?> save(String email,String password,Adresse adresse);
}
