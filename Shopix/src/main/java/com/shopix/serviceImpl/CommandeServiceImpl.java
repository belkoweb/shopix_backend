package com.shopix.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopix.beans.Commande;
import com.shopix.beans.CommandeItem;
import com.shopix.beans.User;
import com.shopix.dao.CommandeDao;
import com.shopix.service.CommandeItemService;
import com.shopix.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDao commandeDao;
	@Autowired
	private CommandeItemService commandeItemService;

	@Override
	public Commande findByref(String ref) {
		return commandeDao.findByref(ref);
	}

	@Override
	public Collection<Commande> findAllByUser(User user) {
		return commandeDao.findAllByUser(user);
	}

	@Override
	public int save(Commande commande) {
		Commande loadedCOmmande = findByref(commande.getRef());
		if (loadedCOmmande != null) {
			return -1;
		} else {
			calculerTotal(commande, commande.getCommandeItems());
			commandeItemService.save(commande, commande.getCommandeItems());
			commandeDao.save(commande);
		}
		return 1;
	}

	private void calculerTotal(Commande commande, Collection<CommandeItem> commandeItems) {
		double total = 0;
		for (CommandeItem commandeItem : commandeItems) {
			total += commandeItem.getPrixPiece() * commandeItem.getNbrPiece();
		}
		commande.setTotal(total);
	}

	@Override
	public Collection<Commande> findAll() {
		return commandeDao.findAll();
	}

}
