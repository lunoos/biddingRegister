package com.bidding.register.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.register.Entity.Bidder;
import com.bidding.register.repository.BidderRepository;

@Service
public class BidderServiceImpl implements BidderService {

	@Autowired
    private  BidderRepository bidderRepository;


    public Bidder createBidder(Bidder bidder) {
        return bidderRepository.save(bidder);
    }

    public Optional<Bidder> getBidderById(Long bidderId) {
        return bidderRepository.findById(bidderId);
    }

    public List<Bidder> getBiddersByUserId(Long userId) {
        return bidderRepository.findByUserId(userId);
    }

    public List<Bidder> getBiddersBySlotId(Long slotId) {
        return bidderRepository.findBySlotId(slotId);
    }

    public void deleteBidder(Long bidderId) {
        bidderRepository.deleteById(bidderId);
    }
}
