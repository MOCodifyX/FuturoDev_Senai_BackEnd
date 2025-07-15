package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

    // Atributos privados
    private String nome;
    private List<ItemCardapio> cardapio;

    // Variáveis estáticas
    private static int totalItens = 0;
    private static int totalRestaurantes = 0;

    // Construtor
    public Restaurante(String nome) {
        this.nome = nome;
        this.cardapio = new ArrayList<>();
        totalRestaurantes++;
    }

    // Metodo Adicionar item ao Cardápio
    public void adicionarItem(ItemCardapio item) {
        if (item != null) {
            cardapio.add(item);
            totalItens++;
        }
    }

    // Metodo para listar todos os itens do cardápio
    public void listarCardapio() {
        System.out.println("Cardápio do restaurante: " + nome);
        for (ItemCardapio item : cardapio) {
            System.out.println(item);
        }
    }

    // Metodo para busca de ItemCardapio
    public List<ItemCardapio> buscarItens(String... codigos){
        List<ItemCardapio> encontrados = new ArrayList<>();

        for (String codigoBuscado : codigos) {
            for (ItemCardapio item : cardapio) {
                if (item.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                    encontrados.add(item);
                }
            }
        }

        return encontrados;
    }

    // Metodo para fazer pedido e calcular valor total
    public double fazerPedido(String... codigos) {
        double total = 0.0;

        for (String codigoBuscado : codigos) {
            boolean encontrado = false;

            for (ItemCardapio item : cardapio) {
                if (item.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                    total += item.getPreco();
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Item com código '" + codigoBuscado + "' não encontrado. Valor considerado: R$ 0.00");
            }
        }

        return total;
    }

    // Getters estáticos
    public static int getTotalItens() {
        return totalItens;
    }

    public static int getTotalRestaurantes() {
        return totalRestaurantes;
    }

    // Getter do nome
    public String getNome() {
        return nome;
    }

}
