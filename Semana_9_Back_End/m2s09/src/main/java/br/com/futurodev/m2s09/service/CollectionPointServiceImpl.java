package br.com.futurodev.m2s09.service;

import br.com.futurodev.m2s09.dto.CollectionPointRequestDTO;
import br.com.futurodev.m2s09.dto.CollectionPointResponseDTO;
import br.com.futurodev.m2s09.entity.CollectionPoint;
import br.com.futurodev.m2s09.entity.ElectronicWaste;
import br.com.futurodev.m2s09.mapper.CollectionPointMapper;
import br.com.futurodev.m2s09.repository.CollectionPointRepository;
import br.com.futurodev.m2s09.repository.ElectronicWasteRepository;
import br.com.futurodev.m2s09.service.CollectionPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollectionPointServiceImpl implements CollectionPointService {

    private final CollectionPointRepository repository;
    private final ElectronicWasteRepository wasteRepository;

    @Override
    public List<CollectionPointResponseDTO> getAll() {
        List<CollectionPoint> entities = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return entities.stream()
                .map(CollectionPointMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CollectionPointResponseDTO getById(Long id) {
        CollectionPoint entity = findEntityById(id);
        return CollectionPointMapper.toDto(entity);
    }

    @Override
    public CollectionPointResponseDTO create(CollectionPointRequestDTO dto) {
        CollectionPoint entity = new CollectionPoint();
        saveEntity(entity, dto);
        return CollectionPointMapper.toDto(entity);
    }

    @Override
    public CollectionPointResponseDTO update(Long id, CollectionPointRequestDTO dto) {
        CollectionPoint entity = findEntityById(id);
        saveEntity(entity, dto);
        return CollectionPointMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        CollectionPoint entity = findEntityById(id);
        repository.delete(entity);
    }

    private CollectionPoint findEntityById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    private CollectionPoint saveEntity(CollectionPoint entity, CollectionPointRequestDTO dto) {
        List<ElectronicWaste> wastes = wasteRepository.findAll();
        CollectionPointMapper.toEntity(entity, dto, wastes);
        return repository.save(entity);
    }

    @Override
    public List<CollectionPointResponseDTO> getByElectronicWasteName(String name) {
        List<CollectionPoint> points = repository.findByElectronicWasteNameContaining(name);
        return points.stream()
                .map(CollectionPointMapper::toDto)
                .collect(Collectors.toList());
    }
}

