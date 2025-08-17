package br.com.futurodev.m2s08.service;

import br.com.futurodev.m2s08.entity.ProjetoEntity;
import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    List<ProjetoEntity> listarTodos();

    Optional<ProjetoEntity> buscarPorId(Long id);

    ProjetoEntity salvar(ProjetoEntity projeto);

    void deletar(Long id);

    List<ProjetoEntity> buscarComFiltros(String regiao, String nomeOrganizacao);
}


