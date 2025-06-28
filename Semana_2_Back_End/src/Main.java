import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tomate;
        double tomateValor =  4.50;
        int tomateQuantidade = 0;

        String batata;
        double batataValor = 2.80;
        int batataQuantidade = 0;


        String cebola;
        double cebolaValor = 3.20;
        int cebolaQuantidade = 0;

        int opcao;
        int quantidade;

        do {

            System.out.println("=======MENU=======");

            System.out.println("[1] 🛒 Venda");
            System.out.println("[2] 📦 Reposição");
            System.out.println("[3] 📝 Relatório");
            System.out.println("[0] ❌ Sair");

            System.out.println("==================");

            System.out.print("Digite uma Opção: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    do {
                        System.out.println("================================");
                        System.out.println("Escola um Produto Para Vender");
                        System.out.println("[1] 🔙 Voltar");
                        System.out.println("[2] 🍅 Tomate");
                        System.out.println("[3] 🥔 Batata");
                        System.out.println("[4] 🧅 Cebola");
                        System.out.println("================================");


                        System.out.print("Digite uma Opção: ");
                        opcao = scanner.nextInt();

                        switch (opcao){
                            case 1:
                                System.out.println("Voltando...");
                                break;
                            case 2:
                                System.out.print("Digite a Quantidade Vendida: ");
                                quantidade = scanner.nextInt();
                                if (tomateQuantidade < quantidade){
                                    System.out.println("Venda Inválida! Quantidade em Estoque: " + tomateQuantidade);
                                    break;
                                }else {
                                    tomateQuantidade = tomateQuantidade - quantidade;
                                    System.out.println("Sucesso... Total Vendido: ( " + quantidade + " ) Retirado do Estoque de Tomates");
                                    break;
                                }
                            case 3:
                                System.out.print("Digite a Quantidade Vendida: ");
                                quantidade = scanner.nextInt();
                                if (batataQuantidade < quantidade){
                                    System.out.println("Venda Inválida! Quantidade em Estoque: " + batataQuantidade);
                                    break;
                                }else {
                                    batataQuantidade = batataQuantidade - quantidade;
                                    System.out.println("Sucesso... Total Vendido: ( " + quantidade + " ) Retirado do Estoque de Batatas");
                                    break;
                                }
                            case 4:
                                System.out.print("Digite a Quantidade Vendida: ");
                                quantidade = scanner.nextInt();
                                if (cebolaQuantidade < quantidade){
                                    System.out.println("Venda Inválida! Quantidade em Estoque: " + cebolaQuantidade);
                                    break;
                                }else {
                                    cebolaQuantidade = cebolaQuantidade - quantidade;
                                    System.out.println("Sucesso... Total Vendido: ( " + quantidade + " ) Retirado do Estoque de Cebolas");
                                    break;
                                }
                            default:
                                System.out.println("Opção Inválida");
                        }
                    } while (opcao != 1);
                    break;

                case 2:

                    do {
                        System.out.println("================================");
                        System.out.println("Escola um Produto Para Reposição");
                        System.out.println("[1] 🔙 Voltar");
                        System.out.println("[2] 🍅 Tomate");
                        System.out.println("[3] 🥔 Batata");
                        System.out.println("[4] 🧅 Cebola");
                        System.out.println("================================");


                        System.out.print("Digite uma Opção: ");
                        opcao = scanner.nextInt();

                        switch (opcao){
                            case 1:
                                System.out.println("Voltando...");
                                break;
                            case 2:
                                System.out.print("Digite a Quantidade Adicionada: ");
                                quantidade = scanner.nextInt();
                                tomateQuantidade = tomateQuantidade + quantidade;
                                System.out.println("Sucesso... Total Adicionado: ( " + quantidade + " ) ao Estoque de Tomates");
                                break;
                            case 3:
                                System.out.print("Digite a Quantidade Adicionada: ");
                                quantidade = scanner.nextInt();
                                batataQuantidade = batataQuantidade + quantidade;
                                System.out.println("Sucesso... Total Adicionado: ( " + quantidade + " ) ao Estoque de Batatas");
                                break;
                            case 4:
                                System.out.print("Digite a Quantidade Adicionada: ");
                                quantidade = scanner.nextInt();
                                cebolaQuantidade = cebolaQuantidade + quantidade;
                                System.out.println("Sucesso... Total Adicionado: ( " + quantidade + " ) ao Estoque de Cebolas");
                                break;
                            default:
                                System.out.println("Opção Inválida");
                        }
                    } while (opcao != 1);
                    break;

                case 3:
                    System.out.println("=====================Relatórios=====================");
                    System.out.println("Tomates | Estoque: " + tomateQuantidade + "| Unidade: R$" + tomateValor + "| Valor: R$" + (tomateValor*tomateQuantidade));
                    System.out.println("Batatas | Estoque: " + batataQuantidade + "| Unidade: R$" + batataValor + "| Valor: R$" + (batataValor*batataQuantidade));
                    System.out.println("Cebolas | Estoque: " + cebolaQuantidade + "| Unidade: R$" + cebolaValor + "| Valor: R$" + (cebolaValor*cebolaQuantidade));
                    System.out.println("TOTAL EM ESTOQUE: R$" + ((tomateValor*tomateQuantidade)+(batataValor*batataQuantidade)+(cebolaValor*cebolaQuantidade)));
                    System.out.println("====================================================");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }

        } while (opcao != 0);

    }
}
