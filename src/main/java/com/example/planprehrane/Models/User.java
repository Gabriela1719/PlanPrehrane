package com.example.planprehrane.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",
    uniqueConstraints = {
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email")
    })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<PlanIshrane> planIshrane;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Rezultat> rezultati;

  public User() {
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public List<PlanIshrane> getPlanIshrane() {
    return planIshrane;
  }

  public List<Rezultat> getRezultati() {
    return rezultati;
  }

  public void setPlanIshrane(List<PlanIshrane> planIshrane) {
    this.planIshrane = planIshrane;
  }

  public void setRezultati(List<Rezultat> rezultati) {
    this.rezultati = rezultati;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof User))
      return false;

    User other = (User) o;

    if (this.id == null) return false;
    return this.id.equals(other.getId());
  }

  @Override
  public int hashCode() {
    if (this.id != null) {
      return this.id.hashCode();
    } else {
      return super.hashCode();
    }
  }
}
