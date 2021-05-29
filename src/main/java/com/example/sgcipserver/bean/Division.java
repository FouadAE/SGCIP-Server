package com.example.sgcipserver.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Division {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String nomDivision;
	private String nomFrDivision;
	private int codeDivision;
	@ManyToOne
	private ServiceDiv divisionParent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getNomDivision() {
		return nomDivision;
	}

	public void setNomDivision(String nomDivision) {
		this.nomDivision = nomDivision;
	}

	public String getNomFrDivision() {
		return nomFrDivision;
	}

	public void setNomFrDivision(String nomFrDivision) {
		this.nomFrDivision = nomFrDivision;
	}

	public int getCodeDivision() {
		return codeDivision;
	}

	public void setCodeDivision(int codeDivision) {
		this.codeDivision = codeDivision;
	}

	public ServiceDiv getDivisionParent() {
		return divisionParent;
	}

	public void setDivisionParent(ServiceDiv divisionParent) {
		this.divisionParent = divisionParent;
	}

}
