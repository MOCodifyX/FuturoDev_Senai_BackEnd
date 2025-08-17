package br.com.futurodev.m2s08.controller;

import br.com.futurodev.m2s08.entity.ProjetoEntity;
import br.com.futurodev.m2s08.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjetoController {

    private final ProjetoService projetoService;

    @GetMapping
    public List<ProjetoEntity> listar(
            @RequestParam(required = false) String regiao,
            @RequestParam(required = false) String nomeOrganizacao) {
        return projetoService.buscarComFiltros(regiao, nomeOrganizacao);
    }

    @GetMapping("/{id}")
    public Optional<ProjetoEntity> buscar(@PathVariable Long id) {
        return projetoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjetoEntity criar(@RequestBody ProjetoEntity projeto) {
        return projetoService.salvar(projeto);
    }

    @PutMapping("/{id}")
    public ProjetoEntity atualizar(@PathVariable Long id, @RequestBody ProjetoEntity dados) {
        return projetoService.buscarPorId(id)
                .map(proj -> {
                    proj.setNome(dados.getNome());
                    proj.setDescricao(dados.getDescricao());
                    proj.setRegiao(dados.getRegiao());
                    proj.setEstimativaReducaoCO2(dados.getEstimativaReducaoCO2());
                    proj.setOrganizacao(dados.getOrganizacao());
                    return projetoService.salvar(proj);
                }).orElseThrow(() -> new RuntimeException("Projeto não encontrado."));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        projetoService.deletar(id);
    }
}

