package com.jlmr.java.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jlmr.java.application.service.PriceService;
import com.jlmr.java.infrastructure.controller.vo.request.PriceRequestVO;
import com.jlmr.java.infrastructure.controller.vo.response.PriceResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping(value = "/price")
@Tag(name = "Price", description = "Controller of Price endpoints")
public class PriceController {

	@Autowired
	private PriceService priceService;

	@PostMapping
	@Operation(summary = "Obtains product price by date and brand", description = "Retrieve a productId, brandId, date and final price", tags = {
			"Price" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = PriceResponseVO.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	public ResponseEntity<PriceResponseVO> getPrice(@RequestBody PriceRequestVO priceRequestVO) {
		return (ResponseEntity<PriceResponseVO>) priceService.getPrice(priceRequestVO);
	}

}
