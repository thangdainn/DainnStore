package com.dainn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptDTO {
    private Integer id;
    private Integer supplierId;
    private Integer accountId;
    private java.sql.Timestamp createdDate;
    private Integer totalPrice;
    private Integer status;
}
