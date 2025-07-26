package model;

public class Gato extends Animal {
    private boolean conviveComOutrosGatos;

    public Gato(String nome, int idade, String condicaoSaude, String temperamento, String status, boolean conviveComOutrosGatos) {
        super(nome, "Gato", idade, condicaoSaude, temperamento, status);
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }

    public boolean isConviveComOutrosGatos() {
        return conviveComOutrosGatos;
    }

    @Override
    public void gerarRelatorio() {
        super.gerarRelatorio();
        System.out.println("Convive com outros gatos: " + (conviveComOutrosGatos ? "Sim" : "Não"));
    }
}


