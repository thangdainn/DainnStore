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
    public RomDTO findByCapacity(String capacity) {
        return romDAO.findByCapacity(capacity);
    }

    @Override
    public List<RomDTO> findByProduct_Id(Integer id) {
        return romDAO.findByProduct_Id(id);
    }

    @Override
    public List<RomDTO> findByProduct_IdAndQuantityGreaterZero(Integer id) {
        return romDAO.findByProduct_IdAndQuantityGreaterZero(id);
    }

    @Override
    public RomDTO findTop1ByProduct_Id(Integer id) {
        return romDAO.findTop1ByProduct_Id(id);
    }

    @Override
    public RomDTO findById(Integer id) {
        return romDAO.findById(id);
    }

    @Override
    public int getQuantityOfPR(Integer prodId, Integer romId) {
        return romDAO.getQuantityOfPR(prodId,romId);
    }

    @Override
    public void updateQuantityOfPR(Integer prodId, Integer romId, Integer quantity) {
        romDAO.updateQuantityOfPR(prodId, romId, quantity);
    }

}
