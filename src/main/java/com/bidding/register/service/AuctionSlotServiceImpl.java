package com.bidding.register.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bidding.register.Entity.AuctionSlot;
import com.bidding.register.dto.AvailableSlotDTO;
import com.bidding.register.dto.SlotDuration;
import com.bidding.register.repository.AuctionSlotRepository;
import com.bidding.register.strategy.AuctionSlotStrategy;

import jakarta.transaction.Transactional;

@Service
public class AuctionSlotServiceImpl implements AuctionSlotService {

	@Autowired
    private  AuctionSlotRepository auctionSlotRepository;
	
	@Autowired
	private Map<String, AuctionSlotStrategy> auctionStatMap;
	
	@Value("${app.auctionStrategy}")
	private String auctionSlotStrategy;

	@Transactional
    public AuctionSlot createAuctionSlot(AuctionSlot auctionSlot) {
        return auctionSlotRepository.save(auctionSlot);
    }

    public Optional<AuctionSlot> getAuctionSlotById(Long slotId) {
        return auctionSlotRepository.findById(slotId);
    }

    public List<AuctionSlot> getAuctionSlotsByCategoryCode(String CategoryCode) {
        return auctionSlotRepository.findByCategoryCode(CategoryCode);
    }

    @Transactional
    public void deleteAuctionSlot(Long slotId) {
        auctionSlotRepository.deleteById(slotId);
    }

    /**
     * Can add time out to block the slot for a certain time.
     */
	@Override
	public AvailableSlotDTO getAvaiSlotDTO(SlotDuration duration) {
		return auctionStatMap.get(auctionSlotStrategy).getAvailableSlot(duration);
	}

}