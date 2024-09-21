package com.bidding.register.service;

import java.util.List;
import java.util.Optional;

import com.bidding.register.Entity.AuctionSlot;
import com.bidding.register.dto.AvailableSlotDTO;
import com.bidding.register.dto.SlotDuration;

public interface AuctionSlotService {

	public AuctionSlot createAuctionSlot(AuctionSlot auctionSlot);

    public Optional<AuctionSlot> getAuctionSlotById(Long slotId) ;

    public List<AuctionSlot> getAuctionSlotsByCategoryCode(String CategoryCode);

    public void deleteAuctionSlot(Long slotId);
    
    public AvailableSlotDTO getAvaiSlotDTO(SlotDuration duration);
    
}
