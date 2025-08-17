package br.com.futurodev.m2s08.service;

import br.com.futurodev.m2s08.entity.OrganizacaoEntity;
import java.util.List;
import java.util.Optional;

public interface OrganizacaoService {

    List<OrganizacaoEntity> listarTodas();

    Optional<OrganizacaoEntity> buscarPorId(Long id);

    OrganizacaoEntity salvar(OrganizacaoEntity organizacao);

    void deletar(Long id);

    List<OrganizacaoEntity> buscarComFiltros(String nome, String contato);
}


