package com.dainn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
	private Integer orderId;
	private Integer productId;
	private Integer romId;
	private Integer quantity;
	private Integer price;
}
