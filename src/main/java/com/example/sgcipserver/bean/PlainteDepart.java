package com.example.sgcipserver.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlainteDepart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String distinatiare;
    private String signPar;

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

    public String getDistinatiare() {
        return distinatiare;
    }

    public void setDistinatiare(String distinatiare) {
        this.distinatiare = distinatiare;
    }

    public String getSignPar() {
        return signPar;
    }

    public void setSignPar(String signPar) {
        this.signPar = signPar;
    }
}
