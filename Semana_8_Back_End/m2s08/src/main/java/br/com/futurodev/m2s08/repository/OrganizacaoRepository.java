package br.com.futurodev.m2s08.repository;

import br.com.futurodev.m2s08.entity.OrganizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizacaoRepository extends JpaRepository<OrganizacaoEntity, Long> {

    // Buscar por nome
    List<OrganizacaoEntity> findByNomeContainingIgnoreCaseOrderById(String nome);

    // Buscar por contato
    List<OrganizacaoEntity> findByContatoContainingIgnoreCaseOrderById(String contato);

    // Buscar por nome E contato
    List<OrganizacaoEntity> findByNomeContainingIgnoreCaseAndContatoContainingIgnoreCaseOrderById(String nome, String contato);
}

