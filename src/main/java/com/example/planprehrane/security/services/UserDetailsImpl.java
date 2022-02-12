package com.example.planprehrane.security.services;

import com.example.planprehrane.Models.PlanIshrane;
import com.example.planprehrane.Models.Rezultat;
import com.example.planprehrane.Models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String email;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;
  private List<PlanIshrane> planIshrane;
  private List<Rezultat> rezultati;

  public UserDetailsImpl(Long id, String username, String email, String password, List<PlanIshrane> planIshrane,List<Rezultat>rezultati, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
    this.planIshrane = planIshrane;
    this.rezultati = rezultati;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(),
        user.getUsername(),
        user.getEmail(),
        user.getPassword(),
        user.getPlanIshrane(),
        user.getRezultati(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public List<PlanIshrane> getPlanIshrane() {
    return planIshrane;
  }

  public void setPlanIshrane(List<PlanIshrane> planIshrane) {
    this.planIshrane = planIshrane;
  }

  public List<Rezultat> getRezultati() {
    return rezultati;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
