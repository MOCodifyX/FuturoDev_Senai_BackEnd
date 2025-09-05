package br.com.futurodev.m2s09.mapper;

import br.com.futurodev.m2s09.dto.ElectronicWasteRequestDTO;
import br.com.futurodev.m2s09.dto.ElectronicWasteResponseDTO;
import br.com.futurodev.m2s09.entity.ElectronicWaste;

public class ElectronicWasteMapper {

    private ElectronicWasteMapper() {}

    public static ElectronicWasteResponseDTO toDto(ElectronicWaste entity) {
        return new ElectronicWasteResponseDTO(
                entity.getId(),
                entity.getType(),
                entity.getDescription()
        );
    }

    public static void toEntity(ElectronicWaste entity, ElectronicWasteRequestDTO dto) {
        entity.setType(dto.type());
        entity.setDescription(dto.description());
    }
}

