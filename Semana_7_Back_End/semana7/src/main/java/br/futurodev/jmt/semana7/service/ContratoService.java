package br.futurodev.jmt.semana7.service;

import br.futurodev.jmt.semana7.model.Coletor;
import br.futurodev.jmt.semana7.model.Contrato;
import br.futurodev.jmt.semana7.model.Rota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoService {

    private final CadastroService cadastroService;

    public ContratoService(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    public Contrato registrarContrato(int idColetor, List<Integer> idsRotas) {
        Coletor coletor = cadastroService.buscarColetorPorId(idColetor);
        if (coletor == null) {
            throw new IllegalArgumentException("Coletor não encontrado");
        }

        List<Rota> rotas = new ArrayList<>();
        for (Integer idRota : idsRotas) {
            Rota rota = cadastroService.buscarRotaPorId(idRota);
            if (rota == null) {
                throw new IllegalArgumentException("Rota com id " + idRota + " não encontrada");
            }
            rotas.add(rota);
        }

        Contrato contrato = new Contrato(coletor, rotas);
        Contrato.incluirContrato(contrato);
        return contrato;
    }

    public List<Contrato> consultarContratos() {
        return Contrato.getContratosCadastrados();
    }
}

