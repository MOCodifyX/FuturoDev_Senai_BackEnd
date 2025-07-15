package model;

public class ItemCardapio {

    //Atributos Privados
    private String codigo;
    private String nome;
    private double preco;

    // Construtor
    public ItemCardapio(String codigo, String nome, double preco){
        this.codigo = codigo;
        this.nome = nome;
        setPreco(preco);
    }

    // Getters
    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    // Setter com validação
    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: o preço deve ser maior que zero.");
        }
    }

    // toString formatado
    public String toString() {
        return String.format("Código: %s | Nome: %s | Preço: R$ %.2f", codigo, nome, preco);
    }
}
