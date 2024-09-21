package com.bidding.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.register.Entity.Config;

import java.util.List;
import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    Optional<List<Config>> findByConfigCode(String configCode);
}
