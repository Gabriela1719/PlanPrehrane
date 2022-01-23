package com.example.planprehrane.Repositories;

import com.example.planprehrane.Models.Namirnice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamirniceRepository extends JpaRepository<Namirnice, Long> {
    }

