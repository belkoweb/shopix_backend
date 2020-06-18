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
			Stream.of("Informatique", "Ihone", "Imprimante", "Robe").forEach(nameCategorie -> {
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
	   // informatique
	   Produit p1 = new Produit("x-1","Logitech Mouse M90","Logitech ","GREY - USB - N/A - EWR2","assets/images/1.png",75);
	   Produit p2 = new Produit("x-2","HP Omen", "HP","PC Gamer","assets/images/img-2.png", 20000);
	   Produit p3 = new Produit("x-3","Macbook Pro", "Apple","Laptop", "assets/images/laptop.png",20000);
	   Produit p4 = new Produit("x-4","Rog Strix G", "Asus","PC Gamer","assets/images/img-3.png", 18000);
	   Produit p5 = new Produit("x-5","Iphone 11 Pro Max", "Apple","Telephone Portable", "assets/images/img-4.png",12000);
	   //Vêtements & Chaussures
	   Produit p6 = new Produit("x-6","Fashion", "Fashion"," Chaussures de Ville pour Hommes", "assets/images/2.jpg",200);
	   Produit p7 = new Produit("x-7","TUNIQUE À MANCHES COURTES", "Defacto","Couleur: Kaki", "assets/images/6.jpg",79);
	   Produit p8 = new Produit("x-8","Daniel Wellington", "Daniel Wellington","Montre Pour Homme Classic Black Cornwall Silver 40Mm DW00100149 - TU", "assets/images/3.jpg",1849);
	   Produit p9 = new Produit("x-9","Nike", "Nike","Survêtement pour Enfant - NIKE SPORTSWEAR", "assets/images/4.jpg",559);
	   Produit p10 = new Produit("x-10","Defacto ROBE", "Defacto","BLEU MARINE", "assets/images/5.jpg",66);

	   produitDao.save(p1);
	   produitDao.save(p2);
	   produitDao.save(p3);
	   produitDao.save(p4);
	   produitDao.save(p5);
	   
	   
	   
	   
	   
	}

}
