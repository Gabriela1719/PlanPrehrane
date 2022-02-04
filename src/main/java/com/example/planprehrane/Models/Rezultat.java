package com.example.planprehrane.Models;

import javax.persistence.*;

@Entity
@Table(name = "Rezultat")
public class Rezultat {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "rezultat")
    private float vrijednost;

    public Rezultat(float vrijednost){
        this.vrijednost = vrijednost;
    }

    public Rezultat(){}

    public Long getId() {
        return Id;
    }

    public float vrijednost() {
        return vrijednost;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public void setPlan_ishrane(float vrijednost) {
        this.vrijednost = vrijednost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Rezultat))
            return false;

        Rezultat other = (Rezultat) o;

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
