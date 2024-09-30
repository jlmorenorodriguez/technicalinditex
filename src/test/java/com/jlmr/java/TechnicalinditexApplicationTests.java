package com.jlmr.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jlmr.java.infrastructure.controller.PriceController;
import com.jlmr.java.infrastructure.controller.vo.request.PriceRequestVO;
import com.jlmr.java.infrastructure.controller.vo.response.PriceResponseVO;

@SpringBootTest
class TechnicalinditexApplicationTests {


	@Autowired
	private PriceController priceController;


    private void testPriceRequest(String date, double expectedPrice){
    	PriceRequestVO request = PriceRequestVO.builder()
                .brandId(1L)
                .productId(35455L)
                .date(LocalDateTime.parse(date))
                .build();
		ResponseEntity<PriceResponseVO> result = priceController.getPrice(request);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(result.getBody().getFinalPrice(), expectedPrice);

    }

    @Test
    public void test1() throws URISyntaxException {
        testPriceRequest("2020-06-14T10:00:00.000", 35.5);
    }

    @Test
    public void test2() throws URISyntaxException {
        testPriceRequest("2020-06-14T16:00:00.000", 25.45);
    }

    @Test
    public void test3() throws URISyntaxException {
        testPriceRequest("2020-06-14T21:00:00.000", 35.5);
    }

    @Test
    public void test4() throws URISyntaxException {
        testPriceRequest("2020-06-15T10:00:00.000", 30.5);
    }

    @Test
    public void test5() throws URISyntaxException {
        testPriceRequest("2020-06-16T21:00:00.000", 38.95);
    }
}
