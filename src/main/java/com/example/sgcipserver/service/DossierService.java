package com.example.sgcipserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sgcipserver.bean.Dossier;
import com.example.sgcipserver.dao.DossierDao;

@Service
public class DossierService {

	@Autowired
	DossierDao dossierDao;


	public List<Dossier> findAll() {
		return dossierDao.findAll();
	}

	public Dossier findByNom(String nom) {
		return dossierDao.findByNom(nom);
	}
	@Transactional
	public int deleteByNom(String nom) {
		return dossierDao.deleteByNom(nom);
	}


	public int save(Dossier dossier) {

		if (findByNom(dossier.getNom()) != null) {
			return -1;
		} else {
			dossierDao.save(dossier);
			return 1;
		}
	}

}
