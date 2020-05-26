package com.shopix.service;

import com.shopix.beans.Produit;

public interface ProduitService {
public Produit findByRef(String ref);
public Produit findByLibelle(String libelle);
}
