package com.dainn.service;

import com.dainn.dto.RomDTO;

import java.util.List;

public interface IRomService {
    List<RomDTO> findAll();
    List<RomDTO> findByProduct_Id(Integer id);
}
