package com.example.sgcipserver.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Plainte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String createdAt;
    private Date date;
    private Long numeroDOrdre;
    private String objet;
    private Date publie;
    private Long IdDevision;
    private Date dateEnvoi;
    private Long idInstruction;
    private Long numeroEnvoi;
    private String observation;
    private String source;
    private String type;
    private String visa;
    private Long idPlainteDepart;
    private String expediteur;
    //idDtype de type Dtype
    //idDossier
    // idStatus
    //idClasse


    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Date getPublie() {
        return publie;
    }

    public void setPublie(Date publie) {
        this.publie = publie;
    }

    public Long getIdDevision() {
        return IdDevision;
    }

    public void setIdDevision(Long idDevision) {
        IdDevision = idDevision;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Long getIdInstruction() {
        return idInstruction;
    }

    public void setIdInstruction(Long idInstruction) {
        this.idInstruction = idInstruction;
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

    public Long getIdPlainteDepart() {
        return idPlainteDepart;
    }

    public void setIdPlainteDepart(Long idPlainteDepart) {
        this.idPlainteDepart = idPlainteDepart;
    }
}
