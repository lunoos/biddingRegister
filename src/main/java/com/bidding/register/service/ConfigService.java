package com.bidding.register.service;

import java.util.List;
import java.util.Optional;

import com.bidding.register.Entity.Config;

public interface ConfigService {

	public Optional<Config> getConfigById(Long configId);

    public List<Config> getConfigByCode(String configCode);
    
}
