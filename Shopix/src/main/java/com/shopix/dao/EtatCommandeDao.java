package com.shopix.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shopix.beans.EtatCommande;
@RepositoryRestResource
public interface EtatCommandeDao  extends JpaRepository<EtatCommande, Long>{

}
