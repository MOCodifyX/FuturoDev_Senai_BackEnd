package model;

public class Pessoa {

    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        //setNome(nome);
        //setIdade(idade);
    }

    public Pessoa(String nome, int idade, String cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public Pessoa(String nome){
        //this(nome, 0);
        this.nome = nome;
        this.idade = 0;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()) {
            //lançar um erro
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        if(idade < 0 || idade > 120) {
            //lançar um erro
            throw new IllegalArgumentException("Idade Inválida");
        }
        this.idade = idade;
    }
}
