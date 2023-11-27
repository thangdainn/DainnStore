package com.dainn.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	
    private Integer id;
    private Date createdDate;
    private Integer totalPrice;
    private Integer accountId;
    private Integer customerId;
}
