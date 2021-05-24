package com.example.sgcipserver.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceDiv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String nomDService;
    private String nomFrService;
    private String codeService;

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

    public String getNomDService() {
        return nomDService;
    }

    public void setNomDService(String nomDService) {
        this.nomDService = nomDService;
    }

    public String getNomFrService() {
        return nomFrService;
    }

    public void setNomFrService(String nomFrService) {
        this.nomFrService = nomFrService;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }
}
