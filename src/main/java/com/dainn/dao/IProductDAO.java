package com.dainn.dao;

import com.dainn.dto.CategoryDTO;
import com.dainn.dto.ProductDTO;

import java.util.List;

public interface IProductDAO {
    List<ProductDTO> findByCategoryId(Integer id);
    List<ProductDTO> findAll();

}
