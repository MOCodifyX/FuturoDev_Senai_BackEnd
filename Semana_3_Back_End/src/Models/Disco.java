package Models;

public class Disco {

    public int id;
    public String nome;
    public Genero genero;
    public boolean ativo;

    public String getInfo() {
        return "ID: " + id + "\nStatus: " + (ativo ? "Ativo" : "Inativo") + "\nNome: " + nome + "\n--- Gênero do Disco ---\n" + genero.getInfo();
    }

}
