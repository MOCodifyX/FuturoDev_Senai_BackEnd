package br.com.futurodev.m2s09.dto;

import java.util.List;

public record CollectionPointRequestDTO(
        String name,
        String address,
        String collectionDay,
        List<CollectionPointMaterialRequestDTO> materials
) {}

