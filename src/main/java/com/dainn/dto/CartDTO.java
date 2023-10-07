package com.dainn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Integer id;
    private Integer accountId;
    private Integer productId;
    private Integer romId;
    private Integer price;
    private Integer quantity;
}
