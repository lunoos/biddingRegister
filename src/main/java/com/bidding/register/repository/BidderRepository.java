package com.bidding.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.register.Entity.Bidder;

public interface BidderRepository extends JpaRepository<Bidder, Long> {
    List<Bidder> findByUserId(Long userId);
    List<Bidder> findBySlotId(Long slotId);
}
