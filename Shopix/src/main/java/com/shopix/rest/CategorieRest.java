package com.shopix.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopix.beans.Categorie;
import com.shopix.beans.Domaine;
import com.shopix.service.CategorieService;

@RestController
@RequestMapping("/shopix-api/categories")
public class CategorieRest {
	@Autowired
	private CategorieService categorieService;
     @GetMapping("/nom/{nom}")
	public Categorie findByNom(@PathVariable("nom")String categorie) {
		return categorieService.findByNom(categorie);
	}
     @GetMapping("/domaine")
	public Collection<Categorie> findAllByDomaine(@RequestBody Domaine domaine) {
		return categorieService.findAllByDomaine(domaine);
	}
	

}
