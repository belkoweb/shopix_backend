package com.shopix.beans;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
 @Id @GeneratedValue(strategy = GenerationType.AUTO )
 private Long id;
 private String nom;
 private String prenom;
 private String login;
 private String email;
 private String password;
 private String cpassword;
 private String tel;
 private boolean active;
 @OneToMany(mappedBy = "user")
 private Collection<Commande> commandes;
 @OneToMany(mappedBy = "user")
 private Collection<UserRole>  userRoles;
 @OneToMany(mappedBy = "user")
 private Collection<Adresse> adresses;
 @OneToOne
 private Panier panier;
}
