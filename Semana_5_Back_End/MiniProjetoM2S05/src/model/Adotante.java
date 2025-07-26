package model;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class Adotante implements IValidavel, IRelatorio {
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String preferencias;
    private boolean ativo;

    private static int contadorId = 1;

    // Registro dos animais já adotados por esse adotante
    private List<Animal> animaisAdotados;

    //Contrutores
    public Adotante(String nome,String cpf, String endereco, String preferencias) {
        this.id = contadorId++;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.preferencias = preferencias;
        this.animaisAdotados = new ArrayList<>();
        this.ativo = true;
    }

    //Getters
    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public List<Animal> getAnimaisAdotados() {
        return animaisAdotados;
    }

    public boolean isAtivo(){
        return ativo;
    }

    public void adicionarAnimalAdotado(Animal animal) {
        animaisAdotados.add(animal);
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPreferencias(String preferencias){
        this.preferencias = preferencias;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }

    @Override
    public boolean validar(){
        return cpf != null && !cpf.isEmpty() && endereco != null && !endereco.isEmpty();
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório do Adotante:");
        System.out.println("ID: " + id);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Preferências: " + preferencias);
        if (animaisAdotados.isEmpty()) {
            System.out.println("Animais adotados: Nenhum");
        } else {
            // Junta os nomes dos animais com vírgula
            String nomesAnimais = animaisAdotados.stream()
                    .map(Animal::getNome)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
            System.out.println("Animais adotados: " + nomesAnimais);
        }
    }
}




