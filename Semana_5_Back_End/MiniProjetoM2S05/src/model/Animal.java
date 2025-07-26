package model;

public abstract class Animal implements IValidavel, IRelatorio {
    protected int id;
    protected String nome;
    protected String especie;
    protected int idade;
    protected String condicaoSaude;
    protected String temperamento;
    protected String estagio;
    protected boolean ativo;

    private static int contadorId = 1;

    public Animal(String nome, String especie, int idade, String condicaoSaude, String temperamento, String estagio) {
        this.id = contadorId++;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.condicaoSaude = condicaoSaude;
        this.temperamento = temperamento;
        this.estagio = estagio;
        this.ativo = true;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public String getEstagio() {
        return estagio;
    }

    public String getEspecie() {
        return especie;
    }

    public boolean isAtivo() {
        return ativo;
    }

    //Setters
    public void setEstagio(String estagio) {
        this.estagio = estagio;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }

    public boolean validar() {
        return estagio.equalsIgnoreCase("Disponível") && condicaoSaude.equalsIgnoreCase("Saudável");
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório completo do Animal:");
        System.out.println("ID: " + id);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Idade: " + idade);
        System.out.println("Condição de Saúde: " + condicaoSaude);
        System.out.println("Temperamento: " + temperamento);
        System.out.println("Estagio da Adoção: " + estagio);
    }

}

