package br.com.futurodev.m2s08.repository;

import br.com.futurodev.m2s08.entity.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {

    // Buscar por Região
    List<ProjetoEntity> findByRegiaoContainingIgnoreCase(String regiao);

    // Buscar por Organização
    List<ProjetoEntity> findByOrganizacao_NomeContainingIgnoreCase(String nomeOrganizacao);

    // Buscar por Região e Organização
    List<ProjetoEntity> findByRegiaoContainingIgnoreCaseAndOrganizacao_NomeContainingIgnoreCase(String regiao, String nomeOrganizacao);
}

