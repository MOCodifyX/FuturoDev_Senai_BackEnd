package br.com.futurodev.m2s08.controller;

import br.com.futurodev.m2s08.entity.OrganizacaoEntity;
import br.com.futurodev.m2s08.service.OrganizacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizacaoController {

    private final OrganizacaoService organizacaoService;

    @GetMapping
    public List<OrganizacaoEntity> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String contato) {
        return organizacaoService.buscarComFiltros(nome, contato);
    }

    @GetMapping("/{id}")
    public Optional<OrganizacaoEntity> buscar(@PathVariable Long id) {
        return organizacaoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizacaoEntity criar(@RequestBody OrganizacaoEntity organizacao) {
        return organizacaoService.salvar(organizacao);
    }

    @PutMapping("/{id}")
    public OrganizacaoEntity atualizar(@PathVariable Long id, @RequestBody OrganizacaoEntity dados) {
        return organizacaoService.buscarPorId(id)
                .map(org -> {
                    org.setNome(dados.getNome());
                    org.setContato(dados.getContato());
                    return organizacaoService.salvar(org);
                }).orElseThrow(() -> new RuntimeException("Organização não encontrada."));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        organizacaoService.deletar(id);
    }
}


