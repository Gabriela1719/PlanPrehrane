package com.example.planprehrane.Models;

import javax.persistence.*;

@Entity
@Table(name = "Namirnice")
public class Namirnice {
    @Id
    @GeneratedValue
    private Long Id;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "energija")
    private float energija;
    @Column(name = "proteini")
    private float proteini;
    @Column(name = "masti")
    private float masti;
    @Column(name = "ugljikohidrati")
    private float ugljikohidrati;


    public Namirnice(String naziv){
        this.naziv = naziv;
    }
    public Namirnice(){}

    public float getEnergija() {
        return energija;
    }

    public float getProteini() {
        return proteini;
    }

    public float getMasti() {
        return masti;
    }

    public float getUgljikohidrati() {
        return ugljikohidrati;
    }
    public Long getId() {
        return Id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setEnergija(float energija) {
        this.energija = energija;
    }

    public void setProteini(float proteini) {
        this.proteini = proteini;
    }

    public void setMasti(float masti) {
        this.masti = masti;
    }
    public void setUgljikohidrati(float ugljikohidrati) {
        this.ugljikohidrati = ugljikohidrati;
    }
    public void setId(Long id) {
        Id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Namirnice))
            return false;

        Namirnice other = (Namirnice) o;

        if (this.Id == null) return false;
        return this.Id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        if (this.Id != null) {
            return this.Id.hashCode();
        } else {
            return super.hashCode();
        }
    }
}
