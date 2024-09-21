package com.bidding.register.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bidder")
public class Bidder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bidder_seq")
    @SequenceGenerator(name = "bidder_seq", sequenceName = "bidder_seq", allocationSize = 1)
    @Column(name = "bidder_id")
    private Long bidderId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "slot_id", nullable = false)
    private Long slotId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    

    public Long getBidderId() {
		return bidderId;
	}



	public void setBidderId(Long bidderId) {
		this.bidderId = bidderId;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getSlotId() {
		return slotId;
	}



	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public Bidder(Long bidderId, Long userId, Long slotId, LocalDateTime createdAt) {
		super();
		this.bidderId = bidderId;
		this.userId = userId;
		this.slotId = slotId;
		this.createdAt = createdAt;
	}



	public Bidder() {
		super();
		// TODO Auto-generated constructor stub
	}



	@PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
