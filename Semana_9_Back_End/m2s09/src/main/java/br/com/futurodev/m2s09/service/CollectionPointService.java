package br.com.futurodev.m2s09.service;

import br.com.futurodev.m2s09.dto.CollectionPointRequestDTO;
import br.com.futurodev.m2s09.dto.CollectionPointResponseDTO;

import java.util.List;

public interface CollectionPointService {

    List<CollectionPointResponseDTO> getAll();

    CollectionPointResponseDTO getById(Long id);

    CollectionPointResponseDTO create(CollectionPointRequestDTO dto);

    CollectionPointResponseDTO update(Long id, CollectionPointRequestDTO dto);

    List<CollectionPointResponseDTO> getByElectronicWasteName(String name);

    void delete(Long id);

}
