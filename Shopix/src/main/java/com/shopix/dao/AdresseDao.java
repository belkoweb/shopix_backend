package com.shopix.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shopix.beans.Adresse;
@RepositoryRestResource
public interface AdresseDao  extends JpaRepository<Adresse, Long>{

}
