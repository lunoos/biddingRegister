package com.bidding.register.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.register.Entity.Config;
import com.bidding.register.exception.ConfigFetchException;
import com.bidding.register.repository.ConfigRepository;

@Service
public class ConfigServiceImpl implements ConfigService{

	@Autowired
	private  ConfigRepository configRepository;


    public Optional<Config> getConfigById(Long configId) {
        return configRepository.findById(configId);
    }

    public List<Config> getConfigByCode(String configCode) {
    	List<Config> list = configRepository.findByConfigCode(configCode).orElseThrow(() -> new ConfigFetchException("Error fetching the config value"));
        return list;
    }

}
