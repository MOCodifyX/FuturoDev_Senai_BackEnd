package br.com.futurodev.m2s09.service;

import br.com.futurodev.m2s09.dto.ElectronicWasteRequestDTO;
import br.com.futurodev.m2s09.dto.ElectronicWasteResponseDTO;
import br.com.futurodev.m2s09.entity.ElectronicWaste;
import br.com.futurodev.m2s09.mapper.ElectronicWasteMapper;
import br.com.futurodev.m2s09.repository.ElectronicWasteRepository;
import br.com.futurodev.m2s09.service.ElectronicWasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectronicWasteServiceImpl implements ElectronicWasteService {

    private final ElectronicWasteRepository repository;

    @Override
    public List<ElectronicWasteResponseDTO> getAll() {
        List<ElectronicWaste> entities = repository.findAll(Sort.by(Sort.Direction.ASC, "type"));
        return entities.stream()
                .map(ElectronicWasteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ElectronicWasteResponseDTO getById(Long id) {
        ElectronicWaste entity = findEntityById(id);
        return ElectronicWasteMapper.toDto(entity);
    }

    @Override
    public ElectronicWasteResponseDTO create(ElectronicWasteRequestDTO dto) {
        ElectronicWaste entity = saveEntity(new ElectronicWaste(), dto);
        return ElectronicWasteMapper.toDto(entity);
    }

    @Override
    public ElectronicWasteResponseDTO update(Long id, ElectronicWasteRequestDTO dto) {
        ElectronicWaste entity = saveEntity(findEntityById(id), dto);
        return ElectronicWasteMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        ElectronicWaste entity = findEntityById(id);
        repository.delete(entity);
    }

    private ElectronicWaste findEntityById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    private ElectronicWaste saveEntity(ElectronicWaste entity, ElectronicWasteRequestDTO dto) {
        ElectronicWasteMapper.toEntity(entity, dto);
        return repository.save(entity);
    }
}
