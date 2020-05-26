package com.shopix.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopix.beans.Domaine;
import com.shopix.service.DomaineService;

@RestController
@RequestMapping("/shopix-api/domaines")
public class DomaineRest {
	@Autowired
	private DomaineService domaineService;
    @GetMapping("/nom/{nom}")
	public Domaine findByNom(@PathVariable("nom")String nom) {
		return domaineService.findByNom(nom);
	}

}
