package br.futurodev.jmt.semana7.controller;

import br.futurodev.jmt.semana7.model.Contrato;
import br.futurodev.jmt.semana7.service.ContratoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping("/{idColetor}")
    public Contrato registrarContrato(@PathVariable int idColetor,
                                      @RequestBody List<Integer> idsRotas) {
        return contratoService.registrarContrato(idColetor, idsRotas);
    }

    @GetMapping
    public List<Contrato> consultarContratos() {
        return contratoService.consultarContratos();
    }
}

