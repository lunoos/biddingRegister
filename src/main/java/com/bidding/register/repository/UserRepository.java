package com.bidding.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.register.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User findByEmail(String email);
}