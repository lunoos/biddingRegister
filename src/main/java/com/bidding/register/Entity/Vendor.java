package com.bidding.register.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_seq")
    @SequenceGenerator(name = "vendor_seq", sequenceName = "vendor_seq", allocationSize = 1)
    private Long vendorId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "vendor_name", nullable = false)
    private String vendorName;

    @Column(name = "vendor_description")
    private String vendorDescription;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorDescription() {
		return vendorDescription;
	}

	public void setVendorDescription(String vendorDescription) {
		this.vendorDescription = vendorDescription;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", userId=" + userId + ", vendorName=" + vendorName
				+ ", vendorDescription=" + vendorDescription + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

	public Vendor(Long vendorId, Long userId, String vendorName, String vendorDescription, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.vendorId = vendorId;
		this.userId = userId;
		this.vendorName = vendorName;
		this.vendorDescription = vendorDescription;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
