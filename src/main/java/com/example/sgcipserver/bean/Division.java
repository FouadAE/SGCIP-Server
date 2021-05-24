package com.example.sgcipserver.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDivision;
    private String ref;
    private String nomDivision;
    private String nomFrDivision;
    private int codeDivision;
    private String idDivisionParent;

    public Long getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Long idDivision) {
        this.idDivision = idDivision;
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

    public String getIdDivisionParent() {
        return idDivisionParent;
    }

    public void setIdDivisionParent(String idDivisionParent) {
        this.idDivisionParent = idDivisionParent;
    }
}
