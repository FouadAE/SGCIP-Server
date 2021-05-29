package com.example.sgcipserver.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Plainte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String createdAt;
	private String datePlainte;
	private Long numeroDOrdre;
	private String objet;
	private String publie;
	private String dateEnvoi;
	private Long numeroEnvoi;
	private String observation;
	private String source;
	private String type;
	private String visa;
	private String expediteur;
	@ManyToOne
	private Division division;
	@ManyToOne
	private Instruction instruction;
	@ManyToOne
	private PlainteDepart plainteDepart;
	@ManyToOne
	private Theme theme;
	@ManyToOne
	private Dossier dossier;
	@ManyToOne
	private Status status;
	@ManyToOne
	private RClasss pClasse;

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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getDatePlainte() {
		return datePlainte;
	}

	public void setDatePlainte(String datePlainte) {
		this.datePlainte = datePlainte;
	}

	public Long getNumeroDOrdre() {
		return numeroDOrdre;
	}

	public void setNumeroDOrdre(Long numeroDOrdre) {
		this.numeroDOrdre = numeroDOrdre;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getPublie() {
		return publie;
	}

	public void setPublie(String publie) {
		this.publie = publie;
	}

	public String getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(String dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Long getNumeroEnvoi() {
		return numeroEnvoi;
	}

	public void setNumeroEnvoi(Long numeroEnvoi) {
		this.numeroEnvoi = numeroEnvoi;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	public PlainteDepart getPlainteDepart() {
		return plainteDepart;
	}

	public void setPlainteDepart(PlainteDepart plainteDepart) {
		this.plainteDepart = plainteDepart;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public RClasss getpClasse() {
		return pClasse;
	}

	public void setpClasse(RClasss pClasse) {
		this.pClasse = pClasse;
	}

}
