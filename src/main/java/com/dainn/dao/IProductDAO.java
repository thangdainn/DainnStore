package com.dainn.dao;

import com.dainn.dto.CategoryDTO;
import com.dainn.dto.ProductDTO;

import java.util.List;

public interface IProductDAO {
    List<ProductDTO> findByCategoryId(Integer id);
    List<ProductDTO> findAll();
    List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer categoryId, Integer status);
    List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer status);
    List<ProductDTO> findByNameContaining(String keyword, Integer categoryId, Integer status);
    List<ProductDTO> findByNameContaining(String keyword, Integer status);
}
