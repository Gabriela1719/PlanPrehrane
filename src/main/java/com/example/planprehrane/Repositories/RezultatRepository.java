package com.example.planprehrane.Repositories;

import com.example.planprehrane.Models.Rezultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezultatRepository extends JpaRepository<Rezultat, Long>{
}
