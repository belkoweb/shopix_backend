package com.shopix.service;

import java.util.Collection;

import com.shopix.beans.Adresse;

public interface AdresseService {
public Collection<Adresse> findAllByVille(String ville);
public Collection<Adresse> findAllByPays(String pays);
}
