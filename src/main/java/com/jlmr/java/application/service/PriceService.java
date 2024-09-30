package com.jlmr.java.application.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jlmr.java.domain.model.Price;
import com.jlmr.java.infrastructure.controller.vo.request.PriceRequestVO;
import com.jlmr.java.infrastructure.controller.vo.response.PriceResponseVO;

@Service
public class PriceService {

	@Autowired
	private com.jlmr.java.infrastructure.repository.PriceRepository priceRepository;

	public ResponseEntity<PriceResponseVO> getPrice(PriceRequestVO priceRequest) {
		List<Price> prices = priceRepository.findByBrandProductAndDate(priceRequest.getBrandId(),
				priceRequest.getProductId(), priceRequest.getDate());

		if (prices.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Optional<Price> maxPriorityPrice = prices.stream().max(Comparator.comparing(Price::getPriority));
		if (maxPriorityPrice.isPresent()) {
			Price price = maxPriorityPrice.get();
			return ResponseEntity.ok(new PriceResponseVO(priceRequest, price));
		}
		// Return 204 http code
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

}
