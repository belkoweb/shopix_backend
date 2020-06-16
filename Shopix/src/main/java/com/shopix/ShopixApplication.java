package com.shopix;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shopix.beans.Categorie;
import com.shopix.beans.Domaine;
import com.shopix.beans.Fournisseur;
import com.shopix.beans.Produit;
import com.shopix.dao.CategorieDao;
import com.shopix.dao.DomaineDao;
import com.shopix.dao.FournisseurDao;
import com.shopix.dao.ProduitDao;

@SpringBootApplication
public class ShopixApplication implements CommandLineRunner {
	@Autowired
    private DomaineDao domaineDao;
	@Autowired
	private CategorieDao categorieDao;
	@Autowired
	private FournisseurDao fournisseurDao;
	@Autowired
	private ProduitDao produitDao;
	public static void main(String[] args) {
		SpringApplication.run(ShopixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Informatique", "Electromenager", "Mode", "Style").forEach(nameDomaine -> {
			Domaine domaine = new Domaine();
			domaine.setNom(nameDomaine);
			domaineDao.save(domaine);
			
		});
			Stream.of("PC", "Ihone", "Imprimante", "Robe").forEach(nameCategorie -> {
				Categorie categorie = new Categorie();
				categorie.setNom(nameCategorie);
				categorieDao.save(categorie);
				
			});
		Fournisseur fournisseur1 = new Fournisseur("f1","f1@gmail.com", "0645362788");
		Fournisseur fournisseur2 = new Fournisseur("f2","f2@gmail.com", "0645454578");
		Fournisseur fournisseur3 = new Fournisseur("f3","f3@gmail.com", "0677474743");
	   fournisseurDao.save(fournisseur1);
	   fournisseurDao.save(fournisseur2);
	   fournisseurDao.save(fournisseur3);
	   Produit p1 = new Produit("x-1","Accer 512 ","Accer","a gamer pc","assets/images/img-1.png",  2000);
	   Produit p2 = new Produit("x-2","HP Omen", "HP","a gamer pc","assets/images/img-2.png", 3000);
	   Produit p3 = new Produit("x-3","Macbook Pro", "Apple","a desktop pc", "assets/images/laptop.png",3000);
	   Produit p4 = new Produit("x-4","Rog Strix G", "Asus","a desktop pc","assets/images/img-3.png", 4000);
	   Produit p5 = new Produit("x-5","Iphone 11 Pro Max", "Apple","a desktop pc", "assets/images/img-4.png",5000);
	   p3.setFournisseur(fournisseur2);
	   p2.setFournisseur(fournisseur3);
	   p1.setFournisseur(fournisseur1);
	   p4.setFournisseur(fournisseur1);
	   p5.setFournisseur(fournisseur2);
	   produitDao.save(p1);
	   produitDao.save(p2);
	   produitDao.save(p3);
	   produitDao.save(p4);
	   produitDao.save(p5);
	   
	   
	   
	   
	}

}
