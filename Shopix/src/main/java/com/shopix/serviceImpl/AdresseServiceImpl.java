package com.shopix.serviceImpl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.shopix.beans.Adresse;
import com.shopix.service.AdresseService;
@Service
public class AdresseServiceImpl implements AdresseService{

	@Override
	public Collection<Adresse> findAllByVille(String ville) {
		return null;
	}

	@Override
	public Collection<Adresse> findAllByPays(String pays) {
		return null;
	}

}
