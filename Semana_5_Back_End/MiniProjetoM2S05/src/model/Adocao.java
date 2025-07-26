package model;

public class Adocao {
    private int id;
    private Adotante adotante;
    private Animal animalAdotado;
    private String data;
    private boolean termoAssinado;

    private static int contadorId = 1;

    public Adocao(Adotante adotante, Animal animalAdotado, String data, boolean termoAssinado) {
        this.id = contadorId++;
        this.adotante = adotante;
        this.animalAdotado = animalAdotado;
        this.data = data;
        this.termoAssinado = termoAssinado;

        if (termoAssinado) {
            animalAdotado.setEstagio("Adotado");
            adotante.adicionarAnimalAdotado(animalAdotado);
        }
    }

    //Getters e Setters
    public int getId(){
        return id;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public Animal getAnimalAdotado() {
        return animalAdotado;
    }

    public boolean isTermoAssinado() {
        return termoAssinado;
    }

    public void setTermoAssinado(boolean termoAssinado) {
        this.termoAssinado = termoAssinado;

        if (termoAssinado) {
            animalAdotado.setEstagio("Adotado");
            adotante.adicionarAnimalAdotado(animalAdotado);
        }
    }

    public void gerarRelatorio() {
        System.out.println("===== Registro de Adoção =====");
        System.out.println("Adotante CPF: " + adotante.getCpf());
        System.out.println("Animal: " + animalAdotado.getNome());
        System.out.println("Data: " + data);
        System.out.println("Termo Assinado: " + (termoAssinado ? "Sim" : "Não"));
    }


}

