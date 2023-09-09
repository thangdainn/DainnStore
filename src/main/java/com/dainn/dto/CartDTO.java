package com.dainn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {
    private Integer accountId;
    private Integer productId;
    private Integer quantity;
}
