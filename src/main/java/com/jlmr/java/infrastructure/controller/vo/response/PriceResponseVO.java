package com.jlmr.java.infrastructure.controller.vo.response;

import java.time.LocalDateTime;

import com.jlmr.java.domain.model.Price;
import com.jlmr.java.infrastructure.controller.vo.request.PriceRequestVO;

import lombok.Data;



@Data
public class PriceResponseVO {

	private Long price;
	private Long brandId;
	private Long productId;
	private LocalDateTime date;
	private Double finalPrice;

	public PriceResponseVO(PriceRequestVO priceRequest, Price price) {
	    this.date = priceRequest.getDate();
	    this.brandId = price.getBrand().getId();
	    this.finalPrice = price.getPrice();
	    this.price = price.getPriceList();
	    this.productId = price.getProductId();
	}

}
