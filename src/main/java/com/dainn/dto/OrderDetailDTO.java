package com.dainn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Integer price;

}
