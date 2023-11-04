package com.dainn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Integer points;
    private Integer status;
    
}
