package com.dainn.service;

import com.dainn.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findByCategoryName(String name);
    List<ProductDTO> findAll();
}
