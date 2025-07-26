package model;

public class Cao extends Animal {
    private String porte; // Pequeno, Médio, Grande
    private boolean necessitaPasseio;

    public Cao(String nome, int idade, String condicaoSaude, String temperamento, String status, String porte, boolean necessitaPasseio) {
        super( nome, "Cão", idade, condicaoSaude, temperamento, status);
        this.porte = porte;
        this.necessitaPasseio = necessitaPasseio;
    }

    public String getPorte() {
        return porte;
    }

    public boolean isNecessitaPasseio() {
        return necessitaPasseio;
    }

    @Override
    public void gerarRelatorio() {
        super.gerarRelatorio();
        System.out.println("Porte: " + porte);
        System.out.println("Necessita passeio: " + (necessitaPasseio ? "Sim" : "Não"));
    }
}


