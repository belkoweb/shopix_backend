package com.shopix.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommandeItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int nbrPiece;
	private double prixPiece;
	private double total;
	@ManyToOne
	private Commande commande;
}
