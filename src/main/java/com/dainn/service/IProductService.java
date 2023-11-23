package com.dainn.service;

import com.dainn.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findByCategoryName(String name, Integer status);
    List<ProductDTO> findAll(Integer status);
    List<ProductDTO> findByQuantityGreaterZero(Integer status);
    List<ProductDTO> findByPriceInRanges(Integer fromPrice, Integer toPrice, String categoryName, Integer status, String keyword);
    List<ProductDTO> findByPriceInRanges(Integer fromPrice, Integer toPrice, Integer status, String keyword);
    List<ProductDTO> findByNameContaining(String keyword, String categoryName, Integer status);
    List<ProductDTO> findByNameContaining(String keyword, Integer status);
    List<ProductDTO> findByIdOrNameContaining(String keyword, Integer status);
    ProductDTO findById(Integer id);
    void updateQuantityById(Integer id);
    ProductDTO update(ProductDTO dto);
    ProductDTO save(ProductDTO dto);
    void delete(Integer id);
}
