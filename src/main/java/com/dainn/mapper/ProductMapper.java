package com.dainn.mapper;

import com.dainn.dto.ProductDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements IRowMapper<ProductDTO>{
    @Override
    public ProductDTO mapRow(ResultSet rs) {
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(rs.getInt("id"));
            productDTO.setCategoryId(rs.getInt("category_id"));
            productDTO.setName(rs.getString("name"));
            productDTO.setPrice(rs.getInt("price"));
            productDTO.setQuantity(rs.getInt("quantity"));
            productDTO.setImage(rs.getString("image"));
            productDTO.setStatus(rs.getInt("status"));
            return productDTO;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
