package com.bidding.register;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bidding.register.strategy.AuctionSlotStrategy;

@Configuration
public class RegisterConfig {

	@Autowired
    private List<AuctionSlotStrategy> auctionSlotStratergies;
	
	
	//@DependsOn("LatestFeedStratergy")
	 @Bean
	    public Map<String, AuctionSlotStrategy> auctionStatMap() {
		 Map<String, AuctionSlotStrategy> implementationMap = auctionSlotStratergies.stream().collect(Collectors.toMap(AuctionSlotStrategy::getName, stat -> stat));
		 return implementationMap;
	 }
}
