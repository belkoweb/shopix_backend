package com.shopix.service;

import com.shopix.beans.User;

public interface UserService {
public User findByNom(String nom);
public User findByEmail(String email);
public User findByEmailAndPassword(String email,String password);
public int save(User user);
}
