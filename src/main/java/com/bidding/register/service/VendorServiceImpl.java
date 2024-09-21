package com.bidding.register.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.register.Entity.Vendor;
import com.bidding.register.exception.VendorAlreadyExistsException;
import com.bidding.register.repository.VendorRepository;

import jakarta.transaction.Transactional;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorRepository vendorRepository;

	@Transactional
	@Override
    public Vendor registerVendor(Vendor vendor) {
		if(vendorRepository.findByUserId(vendor.getUserId()).isPresent())
			throw new VendorAlreadyExistsException("Vendor already exit for given userId.");
        return vendorRepository.save(vendor);
    }

	@Transactional
	@Override
    public void deleteVendor(Long vendorId) {
        vendorRepository.deleteById(vendorId);
    }

	@Transactional
	@Override
    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

	@Override
    public Optional<Vendor> getVendorByUserId(Long userId) {
        return vendorRepository.findByUserId(userId);
    }
}
