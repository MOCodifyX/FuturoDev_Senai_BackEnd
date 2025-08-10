package br.futurodev.jmt.semana7.service;

import br.futurodev.jmt.semana7.model.Coletor;
import br.futurodev.jmt.semana7.model.Rota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {

    public void cadastrarRota(Rota rota) {
        Rota.incluirRota(rota);
    }

    public List<Rota> consultarRotas() {
        return Rota.getRotasCadastradas();
    }

    public void cadastrarColetor(Coletor coletor) {
        Coletor.incluirColetor(coletor);
    }

    public List<Coletor> consultarColetores() {
        return Coletor.getColetoresCadastrados();
    }

    public Coletor buscarColetorPorId(int id) {
        return consultarColetores()
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Rota buscarRotaPorId(int id) {
        return consultarRotas()
                .stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

