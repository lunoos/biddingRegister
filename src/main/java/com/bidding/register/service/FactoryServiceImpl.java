package com.bidding.register.service;

import org.springframework.stereotype.Service;

import com.bidding.register.dto.AvailableSlotDTO;

@Service
public class FactoryServiceImpl implements FactoryService{

	@Override
	public AvailableSlotDTO getAvailalbleSlotDTO() {
		return new AvailableSlotDTO();
	}

}
