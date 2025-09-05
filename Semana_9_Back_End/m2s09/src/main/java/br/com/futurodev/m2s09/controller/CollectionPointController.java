package br.com.futurodev.m2s09.controller;

import br.com.futurodev.m2s09.dto.CollectionPointRequestDTO;
import br.com.futurodev.m2s09.dto.CollectionPointResponseDTO;
import br.com.futurodev.m2s09.service.CollectionPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/collection-points")
public class CollectionPointController {

    private final CollectionPointService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CollectionPointResponseDTO create(@RequestBody CollectionPointRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<CollectionPointResponseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CollectionPointResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public CollectionPointResponseDTO update(@PathVariable Long id,
                                             @RequestBody CollectionPointRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/electronic-waste/name/{name}")
    public List<CollectionPointResponseDTO> getByElectronicWasteName(@PathVariable String name) {
        return service.getByElectronicWasteName(name);
    }
}

