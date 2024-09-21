package com.bidding.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bidding.register.Entity.Vendor;
import com.bidding.register.service.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
    private VendorService vendorService;


    @PostMapping
    public ResponseEntity<Vendor> registerVendor(@RequestBody Vendor vendor) {
        Vendor registeredVendor = vendorService.registerVendor(vendor);
        return new ResponseEntity<>(registeredVendor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long vendorId) {
        vendorService.deleteVendor(vendorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{vendorId}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long vendorId, @RequestBody Vendor vendor) {
        vendor.setVendorId(vendorId);
        Vendor updatedVendor = vendorService.updateVendor(vendor);
        return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Vendor> getVendorByUserId(@PathVariable Long userId) {
        return vendorService.getVendorByUserId(userId)
                .map(vendor -> new ResponseEntity<>(vendor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}