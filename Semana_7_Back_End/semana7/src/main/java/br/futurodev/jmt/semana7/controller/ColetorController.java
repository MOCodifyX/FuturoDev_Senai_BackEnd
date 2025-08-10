package br.futurodev.jmt.semana7.controller;

import br.futurodev.jmt.semana7.model.Coletor;
import br.futurodev.jmt.semana7.service.CadastroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coletores")
public class ColetorController {

    private final CadastroService service;

    public ColetorController(CadastroService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastrarColetor(@RequestBody Coletor coletor) {
        service.cadastrarColetor(coletor);
    }

    @GetMapping
    public List<Coletor> consultarColetores() {
        return service.consultarColetores();
    }
}
