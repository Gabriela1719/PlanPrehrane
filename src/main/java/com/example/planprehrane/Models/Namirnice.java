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
    @Column(name = "bjelancevice")
    private float bjelancevine;
    @Column(name = "masti")
    private float masti;


    public Namirnice(String naziv){
        this.naziv = naziv;
    }
    public Namirnice(){}

    @ManyToOne
    private PlanIshrane planIshrane;

    public float getEnergija() {
        return energija;
    }

    public float getBjelancevine() {
        return bjelancevine;
    }

    public float getMasti() {
        return masti;
    }

    public PlanIshrane getPlanIshrane() {
        return planIshrane;
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

    public void setBjelancevine(float bjelancevine) {
        this.bjelancevine = bjelancevine;
    }

    public void setMasti(float masti) {
        this.masti = masti;
    }
    public void setId(Long id) {
        Id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public void setPlanIshrane(PlanIshrane planIshrane) {
        this.planIshrane = planIshrane;
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
