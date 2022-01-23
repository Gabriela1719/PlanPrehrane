package com.example.planprehrane.Repositories;

import com.example.planprehrane.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
