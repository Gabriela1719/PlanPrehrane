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
    @Column(name = "nutritivna_vrijednost")
    private float nutritivna_vrijednost;

    public Namirnice(String naziv, float nutritivna_vrijednost){
        this.naziv = naziv;
        this.nutritivna_vrijednost = nutritivna_vrijednost;
    }
    public Namirnice(){}

    @ManyToOne
    private PlanIshrane planIshrane;

    public Long getId() {
        return Id;
    }

    public String getNaziv() {
        return naziv;
    }

    public float getNutritivna_vrijednost() {
        return nutritivna_vrijednost;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setNutritivna_vrijednost(float nutritivna_vrijednost) {
        this.nutritivna_vrijednost = nutritivna_vrijednost;
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
