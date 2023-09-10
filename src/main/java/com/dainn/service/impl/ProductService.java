package com.dainn.service.impl;

import com.dainn.dao.ICategoryDAO;
import com.dainn.dao.IProductDAO;
import com.dainn.dao.impl.CategoryDAO;
import com.dainn.dao.impl.ProductDAO;
import com.dainn.dto.ProductDTO;
import com.dainn.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private IProductDAO productDAO;
    private ICategoryDAO categoryDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
        this.categoryDAO = new CategoryDAO();
    }

    @Override
    public List<ProductDTO> findByCategoryName(String name) {
        Integer categoryId = categoryDAO.findByName(name).getId();
        return productDAO.findByCategoryId(categoryId);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productDAO.findAll();
    }
}
