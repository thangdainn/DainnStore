package com.dainn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private Integer categoryId;
    private String name;
    private Integer price;
    private Integer quantity;
    private String image;
    private Integer status;

}
