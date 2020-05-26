package com.shopix.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shopix.beans.Produit;
@RepositoryRestResource
public interface ProduitDao  extends JpaRepository<Produit, Long>{

	public Produit findByRef(String ref);

	public Produit findByLibelle(String libelle);

}
