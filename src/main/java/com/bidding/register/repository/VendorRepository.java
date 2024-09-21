package com.bidding.register.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.register.Entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findByUserId(Long userId);
}
