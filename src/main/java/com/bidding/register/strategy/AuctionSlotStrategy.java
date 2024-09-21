package com.bidding.register.strategy;

import com.bidding.register.dto.AvailableSlotDTO;
import com.bidding.register.dto.SlotDuration;

public interface AuctionSlotStrategy {

	public AvailableSlotDTO getAvailableSlot(SlotDuration slotDuration);
}
