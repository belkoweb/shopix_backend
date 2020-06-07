package com.shopix.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
	public int save(String email, String password, Commande commande) {
		User user = userService.findByEmailAndPassword(email, password);
		userDao.save(user);
		commande.setUser(user);
		commandeDao.save(commande);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(commande.getCommandeItems());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		calculerTotal(commande, commande.getCommandeItems());

		for (CommandeItem commandeItem : commande.getCommandeItems()) {
			commandeItem.setCommande(commande);
		Produit produit = produitDao.findByRef(commandeItem.getProduit().getRef());
		System.out.println(produit);
		if(produit == null) {
		
	    produitDao.save(commandeItem.getProduit());
		
		}
	    commandeItem.setProduit(produit);
		commandeItemDao.save(commandeItem);
		}
		commandeDao.save(commande);
		return 1;
		
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
