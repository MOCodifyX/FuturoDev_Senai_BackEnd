package br.futurodev.jmt.semana7.model;

import java.util.ArrayList;
import java.util.List;

public class Contrato {

    private static int contadorId = 1;
    private static List<Contrato> contratosCadastrados = new ArrayList<>();

    private int id;
    private Coletor coletor;
    private List<Rota> rotas;

    public Contrato() {
    }

    public Contrato(Coletor coletor, List<Rota> rotas) {
        this.id = contadorId++;
        this.coletor = coletor;
        this.rotas = rotas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coletor getColetor() {
        return coletor;
    }

    public void setColetor(Coletor coletor) {
        this.coletor = coletor;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }

    public static void incluirContrato(Contrato contrato) {
        contratosCadastrados.add(contrato);
    }

    public static List<Contrato> getContratosCadastrados() {
        return contratosCadastrados;
    }
}
