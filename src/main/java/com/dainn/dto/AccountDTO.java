package com.dainn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
	
	private Integer id;
	private String username;
	private String password;
	private String fullName;
	private String phone;
	private String address;
	private Integer status;
	private String roleId;
	
}
