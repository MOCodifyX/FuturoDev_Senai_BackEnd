package br.com.futurodev.m2s09.dto;

import java.util.List;

public record CollectionPointResponseDTO(
        Long id,
        String name,
        String address,
        String collectionDay,
        List<CollectionPointMaterialResponseDTO> materials
) {}

