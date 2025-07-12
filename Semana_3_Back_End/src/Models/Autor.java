package Models;

public class Autor {

    public int id;
    public String nome;
    public Disco disco;

    public String getInfo() {
        return "ID: " + id + "\nNome: " + nome + "\nDisco: " + disco.nome;
    }

}

