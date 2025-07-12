package Models;

public class Genero {

    public int id;
    public String nome;
    public String descricao;

    public String getInfo() {
        return "ID: " + id + "\nGênero: " + nome + "\nDescrição: " + descricao;
    }

}
