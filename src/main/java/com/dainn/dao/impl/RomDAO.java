package com.dainn.dao.impl;

import com.dainn.dao.IRomDAO;
import com.dainn.dto.RomDTO;
import com.dainn.mapper.RomMapper;

import java.util.List;

public class RomDAO extends AbstractDAO<RomDTO> implements IRomDAO {
    @Override
    public List<RomDTO> findAll() {
        String sql = "SELECT * FROM rom WHERE capacity != '' ORDER BY percent ASC";
        return query(sql, new RomMapper());
    }

    @Override
    public RomDTO findByCapacity(String capacity) {
        String sql = "SELECT * FROM rom WHERE capacity = ?";
        List<RomDTO> list = query(sql, new RomMapper(), capacity);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<RomDTO> findByProduct_Id(Integer id) {
        String sql = "SELECT * FROM rom r JOIN product_rom pr ON r.id = pr.rom_id WHERE pr.product_id = ? ORDER BY r.percent ASC";
        return query(sql, new RomMapper(), id);
    }

    @Override
    public List<RomDTO> findByProduct_IdAndQuantityGreaterZero(Integer id) {
        String sql = "SELECT * FROM rom r JOIN product_rom pr ON r.id = pr.rom_id" +
                " WHERE pr.product_id = ? AND pr.quantity > 0 ORDER BY r.percent ASC";
        return query(sql, new RomMapper(), id);
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
        String sql = "UPDATE product_rom pr" +
                " JOIN (SELECT product_id, rom_id, SUM(quantity) AS total_quantity" +
                " FROM product_rom" +
                " WHERE product_id = ? AND rom_id = ?" +
                " GROUP BY product_id, rom_id) qty" +
                " ON pr.product_id = qty.product_id AND pr.rom_id = qty.rom_id" +
                " SET pr.quantity = qty.total_quantity + ?";
        update(sql, prodId, romId, quantity);
    }
}
