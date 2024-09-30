package com.jlmr.java.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Entity
@Builder 
@Table(name = "PRICES")
public class Price {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
	private Brand brand;
	
    @Column(name = "START_DATE")
	private LocalDateTime startDate;
	
    @Column(name = "END_DATE")
	private LocalDateTime endDate;
	
    @Column(name = "PRICE_LIST")
	private Long priceList;
	
    @Column(name = "PRODUCT_ID")
	private Long productId;
	
    @Column(name = "PRIORITY")
	private Integer priority;
	
    @Column(name = "PRICE")
	private Double price;
	
    @Column(name = "CURR")
	private String curr;
    
    @Tolerate
    public Price(){}
    
}
