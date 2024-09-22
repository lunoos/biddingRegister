package com.bidding.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bidding.register.Entity.Bidder;
import com.bidding.register.service.BidderService;

@RestController
@RequestMapping("/bidders")
public class BidderController {

	@Autowired
    private  BidderService bidderService;

    @PostMapping
    public ResponseEntity<Bidder> createBidder(@RequestBody Bidder bidder) {
        Bidder createdBidder = bidderService.createBidder(bidder);
        return new ResponseEntity<>(createdBidder, HttpStatus.CREATED);
    }

    @GetMapping("/{bidderId}")
    public ResponseEntity<Bidder> getBidderById(@PathVariable Long bidderId) {
        return bidderService.getBidderById(bidderId)
                .map(bidder -> new ResponseEntity<>(bidder, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bidder>> getBiddersByUserId(@PathVariable Long userId) {
        List<Bidder> bidders = bidderService.getBiddersByUserId(userId);
        return new ResponseEntity<>(bidders, HttpStatus.OK);
    }

    @GetMapping("/slot/{slotId}")
    public ResponseEntity<List<Bidder>> getBiddersBySlotId(@PathVariable Long slotId) {
        List<Bidder> bidders = bidderService.getBiddersBySlotId(slotId);
        return new ResponseEntity<>(bidders, HttpStatus.OK);
    }

    @DeleteMapping("/{bidderId}")
    public ResponseEntity<Void> deleteBidder(@PathVariable Long bidderId) {
        bidderService.deleteBidder(bidderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}