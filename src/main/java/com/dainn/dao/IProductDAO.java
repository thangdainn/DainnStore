package com.dainn.dao;

import com.dainn.dto.CategoryDTO;
import com.dainn.dto.ProductDTO;

import java.util.List;

public interface IProductDAO {
    List<ProductDTO> findByCategoryId(Integer id, Integer status);
    List<ProductDTO> findAll(Integer status);
    List<ProductDTO> findByQuantityGreaterZero(Integer status);
    List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer categoryId, Integer status);
    List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer status);
    List<ProductDTO> findByNameContaining(String keyword, Integer categoryId, Integer status);
    List<ProductDTO> findByNameContaining(String keyword, Integer status);
    ProductDTO findById(Integer id);
    void updateQuantityById(Integer id);
}
