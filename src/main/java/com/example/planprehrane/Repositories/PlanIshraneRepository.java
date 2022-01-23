package com.example.planprehrane.Repositories;

import com.example.planprehrane.Models.PlanIshrane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanIshraneRepository extends JpaRepository<PlanIshrane, Long> {
}
