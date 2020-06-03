package com.shopix.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopix.beans.Commande;
import com.shopix.beans.User;
import com.shopix.service.CommandeService;

@RestController
@RequestMapping("/shopix-api/commandes")
public class CommandeRest {
@Autowired
private CommandeService commandeService;
@GetMapping("/")
public Collection<Commande> findAll() {
	return commandeService.findAll();
}
@GetMapping("/reference/{ref}")
public Commande findByref(@PathVariable String ref) {
	return commandeService.findByref(ref);
}
@GetMapping("/user")
public Collection<Commande> findAllByUser(@RequestBody User user) {
	return commandeService.findAllByUser(user);
}
@PostMapping("/")
public int save(@RequestBody Commande commande) {
	return commandeService.save(commande);
}
}
