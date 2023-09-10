package com.dainn.dao;

import com.dainn.dto.CategoryDTO;

public interface ICategoryDAO {
    CategoryDTO findByName(String name);
}
