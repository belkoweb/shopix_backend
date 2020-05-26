package com.shopix.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shopix.beans.Categorie;
import com.shopix.beans.Domaine;
@RepositoryRestResource
public interface CategorieDao  extends JpaRepository<Categorie, Long>{
	public Categorie findByNom(String categorie);
	public Collection<Categorie> findAllByDomaine(Domaine domaine);

} 
