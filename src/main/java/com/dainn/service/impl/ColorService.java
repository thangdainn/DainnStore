package com.dainn.service.impl;

import com.dainn.dao.IColorDAO;
import com.dainn.dao.impl.ColorDAO;
import com.dainn.dto.ColorDTO;
import com.dainn.service.IColorService;

import java.util.List;

public class ColorService implements IColorService {

    private IColorDAO colorDAO;

    public ColorService() {
        this.colorDAO = new ColorDAO();
    }

    @Override
    public List<ColorDTO> findAll() {
        return colorDAO.findAll();
    }

    @Override
    public List<ColorDTO> findByName(String name) {
        return colorDAO.findByName(name);
    }
}
