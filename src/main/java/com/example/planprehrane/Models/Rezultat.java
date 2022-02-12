package com.example.planprehrane.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Rezultat")
public class Rezultat {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "rezultat")
    private float vrijednost;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Rezultat(float vrijednost){
        this.vrijednost = vrijednost;
    }

    public Rezultat(){}

    public Long getId() {
        return Id;
    }

    public float getVrijednost() {
        return vrijednost;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setVrijednost(float vrijednost) {
        this.vrijednost = vrijednost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
