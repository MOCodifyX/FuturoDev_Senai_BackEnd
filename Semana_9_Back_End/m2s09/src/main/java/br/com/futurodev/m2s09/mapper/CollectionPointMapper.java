package br.com.futurodev.m2s09.mapper;

import br.com.futurodev.m2s09.dto.*;
import br.com.futurodev.m2s09.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionPointMapper {

    private CollectionPointMapper() {}

    public static CollectionPointResponseDTO toDto(CollectionPoint entity) {
        List<CollectionPointMaterialResponseDTO> materials = entity.getAcceptedMaterials() != null
                ? entity.getAcceptedMaterials().stream()
                .map(material -> new CollectionPointMaterialResponseDTO(
                        material.getId(),
                        material.getElectronicWaste().getId(),
                        material.getElectronicWaste().getType(),
                        material.getMaxCapacity()
                ))
                .collect(Collectors.toList())
                : new ArrayList<>();

        return new CollectionPointResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getCollectionDay(),
                materials
        );
    }

    public static void toEntity(CollectionPoint entity, CollectionPointRequestDTO dto, List<ElectronicWaste> wastes) {
        entity.setName(dto.name());
        entity.setAddress(dto.address());
        entity.setCollectionDay(dto.collectionDay());

        if (entity.getAcceptedMaterials() == null) {
            entity.setAcceptedMaterials(new ArrayList<>());
        }

        if (dto.materials() != null) {
            entity.getAcceptedMaterials().removeIf(material ->
                    dto.materials().stream()
                            .noneMatch(m -> m.electronicWasteId().equals(material.getElectronicWaste().getId()))
            );

            for (CollectionPointMaterialRequestDTO matDto : dto.materials()) {
                boolean exists = entity.getAcceptedMaterials().stream()
                        .anyMatch(m -> m.getElectronicWaste().getId().equals(matDto.electronicWasteId()));

                if (!exists) {
                    ElectronicWaste waste = wastes.stream()
                            .filter(w -> w.getId().equals(matDto.electronicWasteId()))
                            .findFirst()
                            .orElseThrow();

                    CollectionPointMaterial material = new CollectionPointMaterial();
                    material.setElectronicWaste(waste);
                    material.setMaxCapacity(matDto.maxCapacity());
                    material.setCollectionPoint(entity);
                    entity.getAcceptedMaterials().add(material);
                }
            }
        }
    }
}


