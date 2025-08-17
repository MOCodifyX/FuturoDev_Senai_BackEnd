package br.com.futurodev.m2s08.service;

import br.com.futurodev.m2s08.entity.ProjetoEntity;
import br.com.futurodev.m2s08.entity.OrganizacaoEntity;
import br.com.futurodev.m2s08.repository.ProjetoRepository;
import br.com.futurodev.m2s08.repository.OrganizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private OrganizacaoRepository organizacaoRepository;

    @Override
    public List<ProjetoEntity> listarTodos() {
        return projetoRepository.findAll();
    }

    @Override
    public Optional<ProjetoEntity> buscarPorId(Long id) {
        return projetoRepository.findById(id);
    }

    @Override
    public ProjetoEntity salvar(ProjetoEntity projeto) {
        // valida se a organização existe
        OrganizacaoEntity org = projeto.getOrganizacao();
        if (org == null || !organizacaoRepository.existsById(org.getId())) {
            throw new RuntimeException("Organização não encontrada.");
        }
        return projetoRepository.save(projeto);
    }

    @Override
    public void deletar(Long id) {
        projetoRepository.deleteById(id);
    }

    @Override
    public List<ProjetoEntity> buscarComFiltros(String regiao, String nomeOrganizacao) {
        if (regiao != null && nomeOrganizacao != null) {
            return projetoRepository.findByRegiaoContainingIgnoreCaseAndOrganizacao_NomeContainingIgnoreCase(regiao, nomeOrganizacao);
        } else if (regiao != null) {
            return projetoRepository.findByRegiaoContainingIgnoreCase(regiao);
        } else if (nomeOrganizacao != null) {
            return projetoRepository.findByOrganizacao_NomeContainingIgnoreCase(nomeOrganizacao);
        } else {
            return projetoRepository.findAll();
        }
    }
}

