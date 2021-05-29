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

	public Dossier findByRef(String ref) {
		return dossierDao.findByRef(ref);
	}

	public List<Dossier> findAll() {
		return dossierDao.findAll();
	}

	@Transactional
	public int deleteByRef(String ref) {
		return dossierDao.deleteByRef(ref);
	}

	public int save(Dossier dossier) {

		if (findByRef(dossier.getRef()) != null) {
			return -1;
		} else {
			dossierDao.save(dossier);
			return 1;
		}
	}

}
