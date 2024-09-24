package com.bidding.register.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bidding.register.Entity.Vendor;
import com.bidding.register.exception.VendorAlreadyExistsException;
import com.bidding.register.repository.VendorRepository;

@ExtendWith(MockitoExtension.class)
class VendorServiceImplTest {

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private VendorServiceImpl vendorService;

    private Vendor vendor;

    @BeforeEach
    void setUp() {
        vendor = new Vendor();
        vendor.setVendorId(1L);
        vendor.setUserId(1L);
        vendor.setVendorName("Test Vendor");
        vendor.setVendorDescription("Test Description");
    }

    @Test
    void testRegisterVendor_Success() {
        when(vendorRepository.findByUserId(1L)).thenReturn(Optional.empty());
        when(vendorRepository.save(vendor)).thenReturn(vendor);

        Vendor result = vendorService.registerVendor(vendor);

        assertNotNull(result);
        assertEquals(vendor.getVendorId(), result.getVendorId());
        assertEquals(vendor.getUserId(), result.getUserId());
        assertEquals(vendor.getVendorName(), result.getVendorName());
        assertEquals(vendor.getVendorDescription(), result.getVendorDescription());
        verify(vendorRepository).save(vendor);
    }

    @Test
    void testRegisterVendor_VendorAlreadyExists() {
        when(vendorRepository.findByUserId(1L)).thenReturn(Optional.of(vendor));

        assertThrows(VendorAlreadyExistsException.class, () -> vendorService.registerVendor(vendor));
        verify(vendorRepository, never()).save(any(Vendor.class));
    }

    @Test
    void testDeleteVendor() {
        vendorService.deleteVendor(1L);

        verify(vendorRepository).deleteById(1L);
    }

    @Test
    void testUpdateVendor() {
        when(vendorRepository.save(vendor)).thenReturn(vendor);

        Vendor result = vendorService.updateVendor(vendor);

        assertNotNull(result);
        assertEquals(vendor.getVendorId(), result.getVendorId());
        assertEquals(vendor.getUserId(), result.getUserId());
        assertEquals(vendor.getVendorName(), result.getVendorName());
        assertEquals(vendor.getVendorDescription(), result.getVendorDescription());
        verify(vendorRepository).save(vendor);
    }

    @Test
    void testGetVendorByUserId_Found() {
        when(vendorRepository.findByUserId(1L)).thenReturn(Optional.of(vendor));

        Optional<Vendor> result = vendorService.getVendorByUserId(1L);

        assertTrue(result.isPresent());
        assertEquals(vendor.getVendorId(), result.get().getVendorId());
        assertEquals(vendor.getUserId(), result.get().getUserId());
        assertEquals(vendor.getVendorName(), result.get().getVendorName());
        assertEquals(vendor.getVendorDescription(), result.get().getVendorDescription());
    }

    @Test
    void testGetVendorByUserId_NotFound() {
        when(vendorRepository.findByUserId(1L)).thenReturn(Optional.empty());

        Optional<Vendor> result = vendorService.getVendorByUserId(1L);

        assertFalse(result.isPresent());
    }
}