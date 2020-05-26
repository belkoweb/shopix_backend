package com.shopix.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shopix.beans.User;
@RepositoryRestResource
public interface UserDao  extends JpaRepository<User, Long>{
	public User findByNom(String nom);
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email,String password);
}
