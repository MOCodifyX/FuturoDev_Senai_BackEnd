package br.futurodev.jmt.semana7.controller;

import br.futurodev.jmt.semana7.model.Rota;
import br.futurodev.jmt.semana7.service.CadastroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    private final CadastroService service;

    public RotaController(CadastroService service) {
        this.service = service;
    }

    @PostMapping
    public void cadastrarRota(@RequestBody Rota rota) {
        service.cadastrarRota(rota);
    }

    @GetMapping
    public List<Rota> consultarRotas() {
        return service.consultarRotas();
    }
}
