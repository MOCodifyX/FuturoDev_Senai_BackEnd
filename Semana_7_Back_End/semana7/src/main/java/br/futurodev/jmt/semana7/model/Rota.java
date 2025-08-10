package br.futurodev.jmt.semana7.model;

import java.util.ArrayList;
import java.util.List;

public class Rota {

    private static int contadorId = 1;
    private static List<Rota> rotasCadastradas = new ArrayList<>();

    private int id;
    private String descricao;
    private String areaAbrangencia;
    private double percentualEficiencia;


    public Rota(String descricao, String areaAbrangencia, double percentualEficiencia) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.areaAbrangencia = areaAbrangencia;
        this.percentualEficiencia = percentualEficiencia;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAreaAbrangencia() {
        return areaAbrangencia;
    }

    public double getPercentualEficiencia() {
        return percentualEficiencia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAreaAbrangencia(String areaAbrangencia) {
        this.areaAbrangencia = areaAbrangencia;
    }

    public void setPercentualEficiencia(double percentualEficiencia) {
        this.percentualEficiencia = percentualEficiencia;
    }

    public static void incluirRota(Rota rota) {
        rotasCadastradas.add(rota);
    }

    public static List<Rota> getRotasCadastradas() {
        return rotasCadastradas;
    }
}
