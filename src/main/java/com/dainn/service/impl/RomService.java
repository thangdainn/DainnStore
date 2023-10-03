package com.dainn.service.impl;

import com.dainn.dao.IRomDAO;
import com.dainn.dao.impl.RomDAO;
import com.dainn.dto.RomDTO;
import com.dainn.service.IRomService;

import java.util.List;

public class RomService implements IRomService {

    private IRomDAO romDAO;

    public RomService() {
        this.romDAO = new RomDAO();
    }

    @Override
    public List<RomDTO> findAll() {
        return romDAO.findAll();
    }

    @Override
    public List<RomDTO> findByProduct_Id(Integer id) {
        return romDAO.findByProduct_Id(id);
    }

}
