package com.bidding.register.strategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.register.Entity.Config;
import com.bidding.register.dto.AvailableSlotDTO;
import com.bidding.register.dto.SlotDuration;
import com.bidding.register.service.ConfigService;
import com.bidding.register.service.FactoryService;
import com.bidding.register.utils.Constants;

@Service
public class LatestAvailableSlotStrategy implements AuctionSlotStrategy  {
	
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private FactoryService factoryService;

	@Override
	public AvailableSlotDTO getAvailableSlot(SlotDuration slotDuration) {
		// TODO Auto-generated method stub
		List<Config> configListAvlSlt = configService.getConfigByCode(Constants.AVL_SLOT_CONFIG_CODE);
		List<Config> configListBufTime = configService.getConfigByCode(Constants.AVL_SLOT_CONFIG_CODE);
		
		String strTime = configListAvlSlt.get(0).getConfigValue();
		Long buffTimeInMin = Long.parseLong(configListAvlSlt.get(0).getConfigValue());
        
        // Define the formatter with the exact pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd h:mm:ss.SSSSSS a");
        
        // Parse the string into LocalDateTime
        LocalDateTime convertedTime = LocalDateTime.parse(strTime, formatter);
        
        LocalDateTime currentTime = LocalDateTime.now();
        
        LocalDateTime currentTimePlusMin = currentTime.plusMinutes(buffTimeInMin);
        
        LocalDateTime startTime = currentTimePlusMin;
        
        if (convertedTime.isAfter(currentTimePlusMin)) 
        	startTime  = convertedTime;
        
        
        LocalDateTime endTime = startTime.plusMinutes(slotDuration.getVal());
        AvailableSlotDTO availableSlotDTO =  factoryService.getAvailalbleSlotDTO();
        availableSlotDTO.setStartTime(startTime);
        availableSlotDTO.setEndTime(endTime);
		return availableSlotDTO;
	}

}
