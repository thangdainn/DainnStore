package com.dainn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Integer id;
    private java.sql.Timestamp createdDate;
    private Integer totalPrice;
    private Integer accountId;
    private Integer customerId;
    private Integer status;
}
