package com.dainn.service;

import com.dainn.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findByCategoryName(String name);
    List<ProductDTO> findAll();
    List<ProductDTO> findByPriceInRanges(Integer fromPrice, Integer toPrice, String categoryName, Integer status);
    List<ProductDTO> findByPriceInRanges(Integer fromPrice, Integer toPrice, Integer status);
    List<ProductDTO> findByNameContaining(String keyword, String categoryName, Integer status);
    List<ProductDTO> findByNameContaining(String keyword, Integer status);
}
