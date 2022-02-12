package com.example.planprehrane.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "PlanIshrane")
public class PlanIshrane {
    @Id
    @GeneratedValue
    private Long Id;
    @Column(name = "plan_ishrane")
    private String plan_ishrane;

    public PlanIshrane(String plan_ishrane){
        this.plan_ishrane = plan_ishrane;
    }
    public PlanIshrane(){}

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Long getId() {
        return Id;
    }

    public String getPlan_ishrane() {
        return plan_ishrane;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setPlan_ishrane(String plan_ishrane) {
        this.plan_ishrane = plan_ishrane;
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
        if (o == null || !(o instanceof PlanIshrane))
            return false;

        PlanIshrane other = (PlanIshrane) o;

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
