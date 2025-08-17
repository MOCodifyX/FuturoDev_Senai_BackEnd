package br.com.futurodev.m2s08.service;

import br.com.futurodev.m2s08.entity.OrganizacaoEntity;
import br.com.futurodev.m2s08.repository.OrganizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizacaoServiceImpl implements OrganizacaoService {

    private final OrganizacaoRepository organizacaoRepository;

    @Override
    public List<OrganizacaoEntity> listarTodas() {
        return organizacaoRepository.findAll();
    }

    @Override
    public Optional<OrganizacaoEntity> buscarPorId(Long id) {
        return organizacaoRepository.findById(id);
    }

    @Override
    public OrganizacaoEntity salvar(OrganizacaoEntity organizacao) {
        return organizacaoRepository.save(organizacao);
    }

    @Override
    public void deletar(Long id) {
        organizacaoRepository.deleteById(id);
    }

    @Override
    public List<OrganizacaoEntity> buscarComFiltros(String nome, String contato) {
        if (nome != null && contato != null) {
            return organizacaoRepository.findByNomeContainingIgnoreCaseAndContatoContainingIgnoreCaseOrderById(nome, contato);
        } else if (nome != null) {
            return organizacaoRepository.findByNomeContainingIgnoreCaseOrderById(nome);
        } else if (contato != null) {
            return organizacaoRepository.findByContatoContainingIgnoreCaseOrderById(contato);
        } else {
            return organizacaoRepository.findAll();
        }
    }
}

