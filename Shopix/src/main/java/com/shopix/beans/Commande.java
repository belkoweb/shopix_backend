package com.shopix.beans;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commande {
	 @Id @GeneratedValue(strategy = GenerationType.AUTO )
		private Long id;
	    private String ref;
	    private double total;
	    private Date date;
	    @ManyToOne
	    private User user;
	    @OneToMany(mappedBy = "commande")
	    private Collection<CommandeItem> commmandeItems;
	    @ManyToOne
	    private EtatCommande etatCommande;
	    @OneToOne
	    private Facture facture;
	    @OneToMany(mappedBy = "commande")
	    private Collection<Livraison> livraisons;
}
