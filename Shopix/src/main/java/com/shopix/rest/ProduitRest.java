package com.shopix.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopix.beans.Produit;
import com.shopix.service.ProduitService;

@RestController
@RequestMapping("/shopix-api/produits")
public class ProduitRest {
 @Autowired
 private ProduitService produitService;

 @GetMapping("/ref/{ref}")
public Produit findByRef(@PathVariable("ref")String ref) {
	return produitService.findByRef(ref);
}

 @GetMapping("/libelle/{libelle}")
public Produit findByLibelle(@PathVariable("libelle")String libelle) {
	return produitService.findByLibelle(libelle);
}
 
}
