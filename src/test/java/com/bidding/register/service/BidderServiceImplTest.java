package com.bidding.register.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bidding.register.Entity.Bidder;
import com.bidding.register.repository.BidderRepository;

@ExtendWith(MockitoExtension.class)
class BidderServiceImplTest {

    @Mock
    private BidderRepository bidderRepository;

    @InjectMocks
    private BidderServiceImpl bidderService;

    private Bidder bidder;

    @BeforeEach
    void setUp() {
        bidder = new Bidder();
        bidder.setBidderId(1L);
        bidder.setUserId(1L);
        bidder.setSlotId(1L);
    }

    @Test
    void testCreateBidder() {
        when(bidderRepository.save(bidder)).thenReturn(bidder);

        Bidder result = bidderService.createBidder(bidder);

        assertNotNull(result);
        assertEquals(bidder.getBidderId(), result.getBidderId());
        verify(bidderRepository).save(bidder);
    }

    @Test
    void testGetBidderById() {
        when(bidderRepository.findById(1L)).thenReturn(Optional.of(bidder));

        Optional<Bidder> result = bidderService.getBidderById(1L);

        assertTrue(result.isPresent());
        assertEquals(bidder.getBidderId(), result.get().getBidderId());
    }

    @Test
    void testGetBiddersByUserId() {
        List<Bidder> bidders = Arrays.asList(bidder);
        when(bidderRepository.findByUserId(1L)).thenReturn(bidders);

        List<Bidder> result = bidderService.getBiddersByUserId(1L);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(bidder.getBidderId(), result.get(0).getBidderId());
    }

    @Test
    void testGetBiddersBySlotId() {
        List<Bidder> bidders = Arrays.asList(bidder);
        when(bidderRepository.findBySlotId(1L)).thenReturn(bidders);

        List<Bidder> result = bidderService.getBiddersBySlotId(1L);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(bidder.getBidderId(), result.get(0).getBidderId());
    }

    @Test
    void testDeleteBidder() {
        bidderService.deleteBidder(1L);

        verify(bidderRepository).deleteById(1L);
    }
}