import model.ItemCardapio;
import model.Restaurante;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Cantina do Sabor");

        int opcao;

        do {
            System.out.println("\n--- MENU RESTAURANTE ---");
            System.out.println("[1] ✅ Cadastrar item");
            System.out.println("[2] 📖 Ver cardápio");
            System.out.println("[3] 📋 Fazer pedido");
            System.out.println("[4] 🔎 Ver estatísticas");
            System.out.println("[0] ❌ Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código do item: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Nome do item: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço do item: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    ItemCardapio novoItem = new ItemCardapio(codigo, nome, preco);
                    restaurante.adicionarItem(novoItem);
                    System.out.println("Item adicionado com sucesso!");
                    break;

                case 2:
                    restaurante.listarCardapio();
                    break;

                case 3:
                    System.out.print("Digite os códigos dos itens do pedido (separados por espaço): ");
                    String linhaCodigos = scanner.nextLine();
                    String[] codigosPedido = linhaCodigos.split(" ");

                    double total = restaurante.fazerPedido(codigosPedido);
                    System.out.printf("Total do pedido: R$ %.2f%n", total);
                    break;

                case 4:
                    System.out.println("Total de restaurantes: " + Restaurante.getTotalRestaurantes());
                    System.out.println("Total de itens no sistema: " + Restaurante.getTotalItens());
                    break;

                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

