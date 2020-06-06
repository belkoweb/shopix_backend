package com.shopix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopix.beans.Produit;
import com.shopix.dao.ProduitDao;
import com.shopix.service.ProduitService;

@Service
public class ProduitServiceIml implements ProduitService{
	@Autowired
	ProduitDao produitDao;

	@Override
	public Produit findByRef(String ref) {
		return produitDao.findByRef(ref);
	}

	@Override
	public Produit findByLibelle(String libelle) {
		return produitDao.findByLibelle(libelle);
	}

	@Override
	public Produit update(Long id, Produit produit) {
		produit.setId(id);
		return produitDao.save(produit);
	}

}
