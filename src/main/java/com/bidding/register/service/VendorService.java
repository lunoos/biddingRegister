package com.bidding.register.service;

import java.util.Optional;

import com.bidding.register.Entity.Vendor;

public interface VendorService{
	
	public Vendor registerVendor(Vendor vendor);

    public void deleteVendor(Long vendorId);

    public Vendor updateVendor(Vendor vendor);

    public Optional<Vendor> getVendorByUserId(Long userId);
}
