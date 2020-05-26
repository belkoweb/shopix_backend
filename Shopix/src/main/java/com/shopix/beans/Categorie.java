package com.shopix.beans;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Belkoweb
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Categorie {
	 @Id @GeneratedValue(strategy = GenerationType.AUTO )
		private Long id;
	    private String nom;
	    private boolean active;
	    @OneToMany(mappedBy = "categorie")
        private Collection<Produit> produits;
	    @ManyToOne
	    private Domaine domaine;
		public Categorie(String nom, boolean active) {
			super();
			this.nom = nom;
			this.active = active;
		}
	    
}
