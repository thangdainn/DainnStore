package com.dainn.service.impl;

import com.dainn.dao.ICategoryDAO;
import com.dainn.dao.IProductDAO;
import com.dainn.dao.impl.CategoryDAO;
import com.dainn.dao.impl.ProductDAO;
import com.dainn.dto.CategoryDTO;
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
    public List<ProductDTO> findByCategoryName(String name, Integer status) {
        Integer categoryId = categoryDAO.findByName(name).getId();
        return productDAO.findByCategoryId(categoryId, status);
    }

    @Override
    public List<ProductDTO> findAll(Integer status) {
        return productDAO.findAll(status);
    }

    @Override
    public List<ProductDTO> findByQuantityGreaterZero(Integer status) {
        return productDAO.findByQuantityGreaterZero(status);
    }

    @Override
    public List<ProductDTO> findByPriceInRanges(Integer fromPrice, Integer toPrice, String categoryName, Integer status) {
        CategoryDTO categoryDTO = categoryDAO.findByName(categoryName);
        return productDAO.findByInRanges(fromPrice, toPrice, categoryDTO.getId(), status);
    }

    @Override
    public List<ProductDTO> findByPriceInRanges(Integer fromPrice, Integer toPrice, Integer status) {
        return productDAO.findByInRanges(fromPrice, toPrice, status);
    }

    @Override
    public List<ProductDTO> findByNameContaining(String keyword, String categoryName, Integer status) {
        CategoryDTO categoryDTO = categoryDAO.findByName(categoryName);
        return productDAO.findByNameContaining(keyword, categoryDTO.getId(), status);
    }

    @Override
    public List<ProductDTO> findByNameContaining(String keyword, Integer status) {
        return productDAO.findByNameContaining(keyword, status);
    }

    @Override
    public ProductDTO findById(Integer id) {
        return productDAO.findById(id);
    }

    @Override
    public void updateQuantityById(Integer id) {
        productDAO.updateQuantityById(id);
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        Integer id = dto.getId();
        productDAO.update(dto);
        return productDAO.findById(id);
    }
}
