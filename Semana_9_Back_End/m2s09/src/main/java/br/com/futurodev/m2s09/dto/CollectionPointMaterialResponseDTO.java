package br.com.futurodev.m2s09.dto;

public record CollectionPointMaterialResponseDTO(
        Long id,
        Long electronicWasteId,
        String electronicWasteType,
        Integer maxCapacity
) {}

