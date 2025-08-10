package br.futurodev.jmt.semana7.model;

import java.util.ArrayList;
import java.util.List;

public class Coletor {

    private static int contadorId = 1;
    private static List<Coletor> coletoresCadastrados = new ArrayList<>();

    private int id;
    private String nome;
    private String descricao;

    public Coletor(String nome, String descricao) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static void incluirColetor(Coletor coletor) {
        coletoresCadastrados.add(coletor);
    }

    public static List<Coletor> getColetoresCadastrados() {
        return coletoresCadastrados;
    }
}
