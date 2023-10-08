package com.dainn.dao.impl;

import com.dainn.dao.IRomDAO;
import com.dainn.dto.ProductDTO;
import com.dainn.dto.RomDTO;
import com.dainn.mapper.ProductMapper;
import com.dainn.mapper.RomMapper;

import java.util.List;

public class RomDAO extends AbstractDAO<RomDTO> implements IRomDAO {
    @Override
    public List<RomDTO> findAll() {
        String sql = "SELECT * FROM rom";
        return query(sql, new RomMapper());
    }

    @Override
    public List<RomDTO> findByProduct_Id(Integer id) {
        String sql = "SELECT * FROM rom r JOIN product_rom pr ON r.id = pr.rom_id WHERE pr.product_id = ? ORDER BY r.percent ASC";
        List<RomDTO> roms = query(sql, new RomMapper(), id);
        return roms.isEmpty() ? null : roms;
    }

    @Override
    public List<RomDTO> findByProduct_IdAndQuantityGreaterZero(Integer id) {
        String sql = "SELECT * FROM rom r JOIN product_rom pr ON r.id = pr.rom_id" +
                " WHERE pr.product_id = ? AND pr.quantity > 0 ORDER BY r.percent ASC";
        List<RomDTO> roms = query(sql, new RomMapper(), id);
        return roms.isEmpty() ? null : roms;
    }

    @Override
    public RomDTO findTop1ByProduct_Id(Integer id) {
        String sql = "SELECT * FROM rom r JOIN product_rom pr ON r.id = pr.rom_id WHERE pr.product_id = ? ORDER BY r.percent ASC LIMIT 1";
        List<RomDTO> roms = query(sql, new RomMapper(), id);
        return roms.isEmpty() ? null : roms.get(0);
    }

    @Override
    public RomDTO findById(Integer id) {
        String sql = "SELECT * FROM rom WHERE id = ?";
        List<RomDTO> list = query(sql, new RomMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int getQuantityOfPR(Integer prodId, Integer romId) {
        String sql = "SELECT sum(quantity) FROM product_rom WHERE product_id = ? AND rom_id = ?";
        return count(sql, prodId, romId);
    }

    @Override
    public void updateQuantityOfPR(Integer prodId, Integer romId, Integer quantity) {
        String sql = "UPDATE product_rom SET quantity = ? WHERE product_id = ? AND rom_id = ?";
        update(sql, quantity, prodId, romId);
    }
}
