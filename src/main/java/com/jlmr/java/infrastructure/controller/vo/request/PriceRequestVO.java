package com.jlmr.java.infrastructure.controller.vo.request;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequestVO {

	private Long brandId;
    private Long productId;
    private LocalDateTime date;
}
