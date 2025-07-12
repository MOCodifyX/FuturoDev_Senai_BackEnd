import model.Biblioteca;
import model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static Scanner ler = new Scanner(System.in);

    // Inicialização da Aplicação
    public static void main(String[] args) {
        int opcMain;
        Biblioteca minhaBiblioteca = new Biblioteca();

      do{

          System.out.println("\n ---Menu de Gestão da Biblioteca---");
          System.out.println("[1] 📚 Gestão de Livros");
          System.out.println("[2] 📦 Gestão de Empréstimos");
          System.out.println("[3] 📝 Relatórios e Consultas");
          System.out.println("[4] 📓 Administração do Sistema");
          System.out.println("[0] ❌ Sair");
          System.out.print("Escolha sua Opção: ");
          opcMain = ler.nextInt();

          switch (opcMain){
              case 1:
                  gestaoLivros(minhaBiblioteca);
                  break;
              case 2:
                  gestaoEmprestimos(minhaBiblioteca);
                  break;
              case 3:
                  gestaoConsultas(minhaBiblioteca);
                  break;
              case 4:
                  gestaoSistema(minhaBiblioteca);
                  break;
              case 0:
                  System.out.print("Saindo do Sistema...");
                  break;
              default:
                  System.out.print("Opção Inválida!!!");

          }

      }while (opcMain != 0);

    }

    // Menu de Livros
    public static void gestaoLivros(Biblioteca biblioteca){
        int opcLivros;

        do{

            System.out.println("\n ---Menu de Gestão de Livros---");
            System.out.println("[1] ✅ Cadastrar Novo Livro");
            System.out.println("[2] 📖 Editar Informações do Livro");
            System.out.println("[3] ❌ Remover Livro do Acervo");
            System.out.println("[4] 📝 Listar Todos os Livros");
            System.out.println("[5] 🔎 Buscar Livro por ISBN");
            System.out.println("[0] 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha sua Opção: ");
            opcLivros = ler.nextInt();

            switch (opcLivros){
                case 1:

                    //Buscar dados
                    System.out.print("Informe o ISBN: ");
                    ler.nextLine();
                    String isbn = ler.nextLine();
                    System.out.print("Informe o Título: ");
                    String titulo = ler.nextLine();
                    System.out.print("Informe o Autor: ");
                    String autor = ler.nextLine();

                    //Criar Livro
                    Livro livro = new Livro(isbn, titulo, autor);
                    biblioteca.adicionarLivro(livro);
                    System.out.print("📕 Livro Adicionado com Sucesso!!! ");

                    break;

                case 2:

                    editarLivro(biblioteca);
                    System.out.print("📕 Livro Alterado com Sucesso!!! ");
                    break;
                case 3:
                    ler.nextLine();
                    System.out.print("Informe o ISBN do livro a ser Removido: ");
                    String isbnRemover = ler.nextLine();

                    Livro livroParaRemover = biblioteca.buscarLivroPorISBN(isbnRemover);
                    if (livroParaRemover != null) {
                        biblioteca.removerLivro(isbnRemover);
                        System.out.println("📕 Livro removido com sucesso!");
                    } else {
                        System.out.println("❌ Livro não encontrado.");
                    }
                    break;

                case 4:

                    biblioteca.exibirRelatorio();

                    break;

                case 5:

                    ler.nextLine();
                    System.out.print("Informe o ISBN a ser buscado: ");
                    String isbnBusca = ler.nextLine();
                    Livro livroBuscado = biblioteca.buscarLivroPorISBN(isbnBusca);
                    if (livroBuscado != null) {
                        System.out.println(livroBuscado.gerarDescricao());
                    } else {
                        System.out.println("❌ Livro não encontrado.");
                    }

                    break;

                case 0:
                    System.out.print("Saindo do Sistema...");
                    break;
                default:
                    System.out.print("Opção Inválida!!!");

            }

        }while (opcLivros != 0);

    }

    // Menu de Empréstimos
    public static void gestaoEmprestimos(Biblioteca biblioteca){
        int opcEmprestimos;

        do{

            System.out.println("\n ---Menu de Gestão de Empréstimos---");
            System.out.println("[1] ✅ Cadastrar Empréstimo");
            System.out.println("[2] ❎ Registrar Devolução");
            System.out.println("[3] 📝 Listar Livros Emprestados");
            System.out.println("[4] 📝 Listar Livros Disponíveis");
            System.out.println("[0] 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha sua Opção: ");
            opcEmprestimos = ler.nextInt();
            ler.nextLine();

            switch (opcEmprestimos){
                case 1:

                    System.out.print("Informe o ISBN do livro para empréstimo: ");
                    String isbnEmprestimo = ler.nextLine();
                    boolean emprestado = biblioteca.emprestarLivro(isbnEmprestimo);
                    if (emprestado) {
                        System.out.println("📚 Livro emprestado com sucesso!");
                    } else {
                        System.out.println("❌ Livro não encontrado ou já emprestado.");
                    }

                    break;

                case 2:

                    System.out.print("Informe o ISBN do livro para devolução: ");
                    String isbnDevolucao = ler.nextLine();
                    boolean devolvido = biblioteca.devolverLivro(isbnDevolucao);
                    if (devolvido) {
                        System.out.println("📚 Livro devolvido com sucesso!");
                    } else {
                        System.out.println("❌ Livro não encontrado ou não está emprestado.");
                    }

                    break;

                case 3:

                    System.out.println("\nLivros emprestados:");
                    boolean temEmprestados = false;
                    for (Livro livro : biblioteca.getAcervo()) {
                        if (livro.isEmprestado()) {
                            System.out.println("- " + livro.getTitulo() + " (" + livro.getIsbn() + ")");
                            temEmprestados = true;
                        }
                    }
                    if (!temEmprestados) {
                        System.out.println("Nenhum livro está emprestado no momento.");
                    }

                    break;
                case 4:

                    System.out.println("\nLivros disponíveis:");
                    boolean temDisponiveis = false;
                    for (Livro livro : biblioteca.getAcervo()) {
                        if (!livro.isEmprestado()) {
                            System.out.println("- " + livro.getTitulo() + " (" + livro.getIsbn() + ")");
                            temDisponiveis = true;
                        }
                    }
                    if (!temDisponiveis) {
                        System.out.println("Nenhum livro disponível no momento.");
                    }

                    break;
                case 0:
                    System.out.print("Saindo do Sistema...");
                    break;
                default:
                    System.out.print("Opção Inválida!!!");

            }

        }while (opcEmprestimos != 0);

    }

    // Menu de Consultas
    public static void gestaoConsultas(Biblioteca biblioteca){
        int opcConsulta;

        do{

            System.out.println("\n ---Menu de Gestão de Livros---");
            System.out.println("[1] 📝 Relatório Completo do Acervo");
            System.out.println("[2] 📖 Editar Informações do Livro");
            System.out.println("[3] ❌ Remover Livro do Acervo");
            System.out.println("[0] 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha sua Opção: ");
            opcConsulta = ler.nextInt();

            switch (opcConsulta){
                case 1:

                    biblioteca.exibirRelatorio();

                    break;

                case 2:

                    editarLivro(biblioteca);

                    break;

                case 3:

                    ler.nextLine();
                    System.out.print("Informe o ISBN do livro a ser Removido: ");
                    String isbnRemover = ler.nextLine();
                    Livro livroRemover = biblioteca.buscarLivroPorISBN(isbnRemover);
                    if (livroRemover != null) {
                        biblioteca.removerLivro(isbnRemover);
                        System.out.println("📕 Livro removido com sucesso!");
                    } else {
                        System.out.println("❌ Livro não encontrado.");
                    }

                    break;

                case 0:

                    System.out.print("Saindo do Sistema...");

                    break;

                default:
                    System.out.print("Opção Inválida!!!");

            }

        }while (opcConsulta != 0);

    }

    // Menu de Sistemas
    public static void gestaoSistema(Biblioteca biblioteca){
        int opcSistema;

        do{

            System.out.println("\n ---Menu de Gestão de Livros---");
            System.out.println("[1] 📋 Total de Livros Cadastrados");
            System.out.println("[2] 📋 Total de Bibliotecas");
            System.out.println("[0] 🔙 Voltar ao Menu Principal");
            System.out.print("Escolha sua Opção: ");
            opcSistema = ler.nextInt();

            switch (opcSistema){
                case 1:

                    System.out.println("📋 Total de Livros: " + Livro.getTotalLivros());

                    break;

                case 2:

                    System.out.println("📋 Total de Bibliotecas: " + biblioteca.getTotalBibliotecas());

                    break;

                case 0:
                    System.out.print("Saindo do Sistema...");
                    break;
                default:
                    System.out.print("Opção Inválida!!!");

            }

        }while (opcSistema != 0);

    }

    //Logica Editar Livro
    public static void editarLivro(Biblioteca biblioteca) {
        ler.nextLine(); // limpar buffer do teclado

        System.out.print("Informe o ISBN do livro a ser alterado: ");
        String isbn = ler.nextLine();

        Livro livroEdit = biblioteca.buscarLivroPorISBN(isbn);

        if (livroEdit != null) {
            System.out.print("Informe o novo título (ou Enter para manter o atual): ");
            String novoTitulo = ler.nextLine();
            if (!novoTitulo.isBlank()) {
                livroEdit.setTitulo(novoTitulo);
            }

            System.out.print("Informe o novo autor (ou Enter para manter o atual): ");
            String novoAutor = ler.nextLine();
            if (!novoAutor.isBlank()) {
                livroEdit.setAutor(novoAutor);
            }

            // Se quiser manter alterarLivro, chame aqui:
            // biblioteca.alterarLivro(livroEdit);

            System.out.println("📘 Livro alterado com sucesso!");
        } else {
            System.out.println("❌ Livro não encontrado.");
        }
    }
}

