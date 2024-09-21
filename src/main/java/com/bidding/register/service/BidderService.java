package com.bidding.register.service;

import java.util.List;
import java.util.Optional;

import com.bidding.register.Entity.Bidder;

public interface BidderService {

	public Bidder createBidder(Bidder bidder);

    public Optional<Bidder> getBidderById(Long bidderId);

    public List<Bidder> getBiddersByUserId(Long userId);

    public List<Bidder> getBiddersBySlotId(Long slotId);

    public void deleteBidder(Long bidderId);
}
