package com.bidding.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.register.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByVendorId(Long vendorId);
}