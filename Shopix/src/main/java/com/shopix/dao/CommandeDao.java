package com.shopix.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shopix.beans.Commande;
@RepositoryRestResource
public interface CommandeDao  extends JpaRepository<Commande, Long>{

}
