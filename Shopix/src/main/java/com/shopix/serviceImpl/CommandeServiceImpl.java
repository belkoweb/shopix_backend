package com.shopix.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopix.beans.Commande;
import com.shopix.beans.CommandeItem;
import com.shopix.beans.Produit;
import com.shopix.beans.User;
import com.shopix.dao.CommandeDao;
import com.shopix.dao.CommandeItemDao;
import com.shopix.dao.ProduitDao;
import com.shopix.dao.UserDao;
import com.shopix.service.CommandeService;
import com.shopix.service.ProduitService;
import com.shopix.service.UserService;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDao commandeDao;
	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommandeItemDao commandeItemDao;
	@Autowired
	private ProduitDao produitDao;

	@Override
	public Commande findByref(String ref) {
		return commandeDao.findByref(ref);
	}

	@Override
	public Collection<Commande> findAllByUser(User user) {
		return commandeDao.findAllByUser(user);
	}

	@Override
	public ResponseEntity<?> save(String email, String password, Commande commande) {
		User user = userService.findByEmailAndPassword(email, password);
		Commande res = findByref(commande.getRef());
		if (user != null) {
			if (commande != null && res == null) {

				commande.setUser(user);
				commandeDao.save(commande);
				if (commande.getCommandeItems() != null) {

					calculerTotal(commande, commande.getCommandeItems());
					for (CommandeItem commandeItem : commande.getCommandeItems()) {
						commandeItem.setCommande(commande);
						Produit produit = produitDao.findByRef(commandeItem.getProduit().getRef());
						if (produit == null) {

							produitDao.save(commandeItem.getProduit());
							produit = commandeItem.getProduit();

						}
						commandeItem.setProduit(produit);
						commandeItemDao.save(commandeItem);
					}
				} else {
					return new ResponseEntity<>(HttpStatus.CONFLICT);
				}
				commandeDao.save(commande);
			} else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			return null;
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	private void calculerTotal(Commande commande, Collection<CommandeItem> commandeItems) {
		double total = 0;
		for (CommandeItem commandeItem : commandeItems) {
			total += commandeItem.getProduit().getPrix() * commandeItem.getQte();
		}
		commande.setTotal(total);
	}

	@Override
	public Collection<Commande> findAll() {
		return commandeDao.findAll();
	}

}
