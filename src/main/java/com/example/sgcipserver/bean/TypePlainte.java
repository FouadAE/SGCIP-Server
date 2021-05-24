package com.example.sgcipserver.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypePlainte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String typeFr;
    private String typeAr;

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

    public String getTypeFr() {
        return typeFr;
    }

    public void setTypeFr(String typeFr) {
        this.typeFr = typeFr;
    }

    public String getTypeAr() {
        return typeAr;
    }

    public void setTypeAr(String typeAr) {
        this.typeAr = typeAr;
    }
}
