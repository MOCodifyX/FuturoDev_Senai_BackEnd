package br.com.futurodev.m2s09.service;

import br.com.futurodev.m2s09.dto.ElectronicWasteRequestDTO;
import br.com.futurodev.m2s09.dto.ElectronicWasteResponseDTO;

import java.util.List;

public interface ElectronicWasteService {

    List<ElectronicWasteResponseDTO> getAll();

    ElectronicWasteResponseDTO getById(Long id);

    ElectronicWasteResponseDTO create(ElectronicWasteRequestDTO dto);

    ElectronicWasteResponseDTO update(Long id, ElectronicWasteRequestDTO dto);

    void delete(Long id);
}

