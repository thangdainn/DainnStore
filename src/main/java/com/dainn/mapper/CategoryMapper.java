package com.dainn.mapper;

import com.dainn.dto.CategoryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements IRowMapper<CategoryDTO>{
    @Override
    public CategoryDTO mapRow(ResultSet rs) {
        try {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(rs.getInt("id"));
            categoryDTO.setName(rs.getString("name"));
            categoryDTO.setDescription(rs.getString("description"));
            return categoryDTO;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
