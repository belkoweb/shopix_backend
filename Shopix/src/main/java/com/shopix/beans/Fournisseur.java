package com.shopix.beans;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fournisseur {
	 @Id @GeneratedValue(strategy = GenerationType.AUTO )
		private Long id;
	    private String nom;
	    private String email;
	    private String tel;
	    private String description;
	    @OneToMany(mappedBy = "fournisseur")
	    private Collection<Produit> produits;
		public Fournisseur(String nom, String email, String tel) {
			super();
			this.nom = nom;
			this.email = email;
			this.tel = tel;
		}
	    
}
