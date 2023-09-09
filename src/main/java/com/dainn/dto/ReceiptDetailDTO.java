package com.dainn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptDetailDTO {
    private Integer receiptId;
    private Integer productId;
    private Integer quantity;
    private Integer price;

}
