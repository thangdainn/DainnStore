package com.dainn.dao;

import com.dainn.dto.RomDTO;

import java.util.List;

public interface IRomDAO {
    List<RomDTO> findAll();
    List<RomDTO> findByProduct_Id(Integer id);
    List<RomDTO> findByProduct_IdAndQuantityGreaterZero(Integer id);
    RomDTO findTop1ByProduct_Id(Integer id);
    RomDTO findById(Integer id);
}
