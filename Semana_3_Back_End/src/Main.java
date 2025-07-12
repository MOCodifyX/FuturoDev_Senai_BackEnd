import Models.Genero;
import Models.Disco;
import Models.Autor;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Genero> listaGeneros = new ArrayList<>();
    public static List<Disco> listaDiscos = new ArrayList<>();
    public static List<Autor> listaAutores = new ArrayList<>();

    public static Scanner scanner = new Scanner(System.in);
    public static int _idAutor = 1;
    public static int _idDisco = 1;
    public static int _idGenero = 1;

    public static void main(String[] args) {
        int opcMenu;

        System.out.println("Inicializando Sistema...");

        do{
            System.out.println("=======| MENU DE CONTROLE |=======");
            System.out.println("[1] Gêneros");
            System.out.println("[2] Discos");
            System.out.println("[3] Autores");
            System.out.println("[0] Sair");
            System.out.println("==================================");
            System.out.print("Digite Sua Opção:");
            opcMenu = scanner.nextInt();

            switch (opcMenu) {
                case 1:
                    menuGeneros();
                    break;

                case 2:
                    menuDiscos();
                    break;

                case 3:
                    menuAutores();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção Inválida!!!");
            }

        }while(opcMenu != 0);
    }

    public static void menuGeneros(){
        int opcGeneros;

        do{
            System.out.println("========| MENU DE GÊNEROS |========");
            System.out.println("[1] Novo Gênero");
            System.out.println("[2] Excluir Gênero");
            System.out.println("[3] Listar Gêneros");
            System.out.println("[0] Voltar");
            System.out.println("===================================");
            System.out.print("Digite Sua Opção:");
            opcGeneros = scanner.nextInt();

            switch (opcGeneros) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Nome do Gênero: ");
                    String nome = scanner.nextLine();

                    System.out.print("Descrição do Gênero: ");
                    String descricao = scanner.nextLine();

                    Genero novoGenero = new Genero();
                    novoGenero.id = _idGenero++;
                    novoGenero.nome = nome;
                    novoGenero.descricao = descricao;

                    listaGeneros.add(novoGenero);
                    System.out.println("✅ Gênero cadastrado com sucesso! ID: " + novoGenero.id);

                    break;

                case 2:
                    if (listaGeneros.isEmpty()) {
                        System.out.println("❌ Nenhum gênero cadastrado.");
                        break;
                    }

                    System.out.println("Digite o ID do gênero a ser excluído:");
                    for (Genero g : listaGeneros) {
                        System.out.println("ID: " + g.id + " | Nome: " + g.nome);
                    }

                    int idExcluir = scanner.nextInt();

                    Genero generoExcluir = listaGeneros.stream()
                            .filter(g -> g.id == idExcluir)
                            .findFirst()
                            .orElse(null);

                    if (generoExcluir != null) {
                        listaGeneros.remove(generoExcluir);
                        System.out.println("🗑️ Gênero excluído com sucesso.");
                    } else {
                        System.out.println("ID inválido. Nenhum gênero encontrado.");
                    }

                    break;

                case 3:
                    if (listaGeneros.isEmpty()) {
                        System.out.println("Nenhum gênero cadastrado.");
                    } else {
                        System.out.println("\n📚 Lista de Gêneros:");
                        for (Genero g : listaGeneros) {
                            System.out.println("------------------------");
                            System.out.println(g.getInfo());
                            System.out.println("------------------------");
                        }
                    }

                    break;

                case 0:
                    System.out.println("Voltando para o Menu de Controle...");
                    break;

                default:
                    System.out.println("Opção Inválida!!!");
            }

        }while(opcGeneros != 0);
    }

    public static void menuDiscos(){
        int opcDiscos;

        do{
            System.out.println("==========| MENU DISCOS |==========");
            System.out.println("[1] Novo Disco");
            System.out.println("[2] Inativar Disco");
            System.out.println("[3] Listar Discos");
            System.out.println("[0] Voltar");
            System.out.println("===================================");
            System.out.print("Digite Sua Opção:");
            opcDiscos = scanner.nextInt();

            switch (opcDiscos) {
                case 1:
                    if (listaGeneros.isEmpty()) {
                        System.out.println("⚠️ Nenhum gênero cadastrado. Cadastre um gênero antes de criar um disco.");

                        break;
                    }

                    scanner.nextLine();
                    System.out.print("Nome do Disco: ");
                    String nomeDisco = scanner.nextLine();

                    System.out.println("Escolha o Gênero do Disco pelo ID:");
                    for (Genero g : listaGeneros) {
                        System.out.println("ID: " + g.id + " | Nome: " + g.nome);
                    }

                    int idGeneroEscolhido = scanner.nextInt();

                    Genero generoSelecionado = listaGeneros.stream()
                            .filter(g -> g.id == idGeneroEscolhido)
                            .findFirst()
                            .orElse(null);

                    if (generoSelecionado == null) {
                        System.out.println("❌ Gênero não encontrado.");

                        break;
                    }

                    Disco novoDisco = new Disco();
                    novoDisco.id = _idDisco++;
                    novoDisco.nome = nomeDisco;
                    novoDisco.genero = generoSelecionado;
                    novoDisco.ativo = true;

                    listaDiscos.add(novoDisco);
                    System.out.println("✅ Disco cadastrado com sucesso! ID: " + novoDisco.id);

                    break;

                case 2:
                    if (listaDiscos.isEmpty()) {
                        System.out.println("⚠️ Nenhum Disco cadastrado. Cadastre um Disco antes de Inativar.");

                        break;
                    }

                    System.out.println("Digite o ID do Disco a ser Inativo:");
                    for (Disco d : listaDiscos) {
                        System.out.println("ID: " + d.id + " | Nome: " + d.nome);
                    }

                    int idDiscoInativar = scanner.nextInt();

                    Disco discoInativar = listaDiscos.stream()
                            .filter(d -> d.id == idDiscoInativar)
                            .findFirst()
                            .orElse(null);

                    if (discoInativar == null) {
                        System.out.println("❌ Disco não encontrado.");
                    } else if (!discoInativar.ativo) {
                        System.out.println("⚠️ Este disco já está inativo.");
                    } else {
                        discoInativar.ativo = false;
                        System.out.println("🛑 Disco inativado com sucesso.");
                    }

                    break;

                case 3:
                    if (listaDiscos.isEmpty()) {
                        System.out.println("Nenhum Disco cadastrado.");
                    } else {
                        System.out.println("\n📚 Lista de Discos:");
                        for (Disco d : listaDiscos) {
                            System.out.println("------------------------");
                            System.out.println(d.getInfo());
                            System.out.println("------------------------");
                        }
                    }

                    break;

                case 0:
                    System.out.println("Voltando para o Menu de Controle...");
                    break;

                default:
                    System.out.println("Opção Inválida!!!");
            }

        }while(opcDiscos != 0);
    }

    public static void menuAutores(){
        int opcAutores;

        do{
            System.out.println("==========| MENU AUTORES|==========");
            System.out.println("[1] Novo Autor");
            System.out.println("[2] Listar Autores");
            System.out.println("[0] Voltar");
            System.out.println("===================================");
            System.out.print("Digite Sua Opção:");
            opcAutores = scanner.nextInt();

            switch (opcAutores) {
                case 1:
                    if (listaDiscos.isEmpty()) {
                        System.out.println("⚠️ Nenhum Disco cadastrado. Cadastre um Disco antes de inserir um Autor.");

                        break;
                    }

                    scanner.nextLine();
                    System.out.print("Nome do Autor: ");
                    String nome = scanner.nextLine();

                    System.out.println("Escolha do Disco desse Autor pelo ID:");
                    for (Disco d : listaDiscos) {
                        System.out.println("ID: " + d.id + " | Disco: " + d.nome);
                    }

                    int idDiscoEscolhido = scanner.nextInt();

                    Disco discoSelecionado = listaDiscos.stream()
                            .filter(d -> d.id == idDiscoEscolhido)
                            .findFirst()
                            .orElse(null);

                    if (discoSelecionado == null) {
                        System.out.println("❌ Disco não encontrado.");

                        break;
                    }

                    Autor novoAutor = new Autor();
                    novoAutor.id = _idAutor++;
                    novoAutor.nome = nome;
                    novoAutor.disco = discoSelecionado;

                    listaAutores.add(novoAutor);
                    System.out.println("✅ Autor cadastrado com sucesso! ID: " + novoAutor.id);

                    break;

                case 2:
                    if (listaAutores.isEmpty()) {
                        System.out.println("Nenhum Autor cadastrado.");
                    } else {
                        System.out.println("\n📚 Lista de Autores:");
                        for (Autor a : listaAutores) {
                            System.out.println("------------------------");
                            System.out.println(a.getInfo());
                            System.out.println("------------------------");
                        }
                    }

                    break;

                case 0:
                    System.out.println("Voltando para o Menu de Controle...");
                    break;

                default:
                    System.out.println("Opção Inválida!!!");
            }

        }while(opcAutores != 0);
    }
}
