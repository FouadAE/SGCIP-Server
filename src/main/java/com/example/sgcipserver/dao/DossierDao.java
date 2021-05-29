package com.example.sgcipserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sgcipserver.bean.Dossier;

@Repository
public interface DossierDao extends JpaRepository<Dossier, Long> {

	Dossier findByRef(String ref);

	int deleteByRef(String ref);
}
