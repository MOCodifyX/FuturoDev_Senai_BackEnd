package br.com.futurodev.m2s09.controller;

import br.com.futurodev.m2s09.dto.ElectronicWasteRequestDTO;
import br.com.futurodev.m2s09.dto.ElectronicWasteResponseDTO;
import br.com.futurodev.m2s09.service.ElectronicWasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/electronic-waste")
public class ElectronicWasteController {

    private final ElectronicWasteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ElectronicWasteResponseDTO create(@RequestBody ElectronicWasteRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ElectronicWasteResponseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ElectronicWasteResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ElectronicWasteResponseDTO update(@PathVariable Long id,
                                             @RequestBody ElectronicWasteRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}



