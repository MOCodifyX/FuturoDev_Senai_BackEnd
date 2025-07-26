import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // Lista estática para armazenar todos os adotantes
    static List<Adotante> listaAdotantes = new ArrayList<>();
    // Lista estática para armazenar todos os Animais
    static List<Animal> listaAnimais = new ArrayList<>();
    // Lista estática para armazenar todos os Animais
    static List<Adocao> listaAdocoes = new ArrayList<>();

    // Menu Principal da Aplicação
    public static void main(String[] args) {
        int opcMain;

        do {

            System.out.println("\n ===//Menu de Gestão da ONG//===");
            System.out.println("[1] 👤 Gestão de Adotantes");
            System.out.println("[2] 🐈‍⬛ Gestão de Animais");
            System.out.println("[3] 🏠 Gestão de Adoções");
            System.out.println("[0] ❌ Sair");
            System.out.println("================================");
            System.out.print("Escolha sua Opção: ");
            opcMain = scanner.nextInt();

            switch (opcMain) {
                case 1:
                    gestaoAdotantes();
                    break;
                case 2:
                    gestaoAnimais();
                    break;
                case 3:
                    gestaoAdocoes();
                    break;
                case 0:
                    System.out.print(" Saindo do Sistema...");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente.");

            }

        } while (opcMain != 0);
    }

    // Menu de Gestão de Adotantes
    public static void gestaoAdotantes(){
        int opcAdotantes;

        do{

            System.out.println("\n ===//Menu de Gestão de Adotantes//===");
            System.out.println("[1] ➕ Adicionar Perfil Adotantes");
            System.out.println("[2] ✍️ Edição de Perfil Adotante");
            System.out.println("[3] 🔄️ Desabilitar/Habilitar adotante");
            System.out.println("[4] 📖 Listar Todos Adotantes");
            System.out.println("[0] 🔙 Voltar ao Menu Principal");
            System.out.println("======================================");
            System.out.print("Escolha sua Opção: ");
            opcAdotantes = scanner.nextInt();

            switch (opcAdotantes){
                case 1:
                    adicionarAdotante();
                    break;
                case 2:
                    editarAdotante();
                    break;
                case 3:
                    alternarStatusAdotante();
                    break;
                case 4:
                    listarTodosAdotantes();
                    break;
                case 0:
                    System.out.println("🔙 Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente.");
            }

        }while (opcAdotantes != 0);
    }

    // Menu de Gestão de Animais
    public static void gestaoAnimais(){
        int opcAnimais;

        do{

            System.out.println("\n ===//Menu de Gestão de Animais//===");
            System.out.println("[1] 🐶 Adicionar Cachorro");
            System.out.println("[2] 😸 Adicionar Gato");
            System.out.println("[3] ➖ Remover Animal");
            System.out.println("[4] 🔄️ Desabilitar/Habilitar Animal");
            System.out.println("[5] 📖 Listar Todos Animais");
            System.out.println("[0] 🔙 Voltar ao Menu Principal");
            System.out.println("====================================");
            System.out.print("Escolha sua Opção: ");
            opcAnimais = scanner.nextInt();

            switch (opcAnimais){
                case 1:
                    adicionarCao();
                    break;
                case 2:
                    adicionarGato();
                    break;
                case 3:
                    removerAnimal();
                    break;
                case 4:
                    alternarStatusAnimal();
                    break;
                case 5:
                    listarTodosAnimais();
                    break;
                case 0:
                    System.out.println("🔙 Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente.");
            }

        }while (opcAnimais != 0);
    }

    // Menu de Gestão de Adoções
    public static void gestaoAdocoes(){
        int opcAdocoes;

        do{

            System.out.println("\n ===//Menu de Gestão de Adoções//===");
            System.out.println("[1] ➕ Gerar Adoção");
            System.out.println("[2] 🫱🏻‍🫲🏻 Realizar Adoção");
            System.out.println("[3] 📖 Listar Adoções");
            System.out.println("[0] 🔙 Voltar ao Menu Principal");
            System.out.println("====================================");
            System.out.print("Escolha sua Opção: ");
            opcAdocoes = scanner.nextInt();

            switch (opcAdocoes){
                case 1:
                    gerarAdocao();
                    break;
                case 2:
                    realizarAdocao();
                    break;
                case 3:
                    listarAdocoes();
                    break;
                case 0:
                    System.out.println("🔙 Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente.");
            }

        }while (opcAdocoes != 0);
    }


    //Métodos do Menu de Gestão de Adoção

    public static void adicionarAdotante() {
        scanner.nextLine();
        System.out.print("Digite o nome do adotante: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do adotante: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite as preferências: ");
        String preferencias = scanner.nextLine();

        Adotante novoAdotante = new Adotante(nome, cpf, endereco, preferencias);

        if (novoAdotante.validar()) {
            listaAdotantes.add(novoAdotante);
            System.out.println("Adotante adicionado com sucesso!");
        } else {
            System.out.println("Dados inválidos. Adotante não adicionado.");
        }
    }

    public static void editarAdotante() {
        scanner.nextLine();

        System.out.print("Digite o ID do adotante que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Busca adotante pelo ID
        Adotante adotanteParaEditar = null;
        for (Adotante adotante : listaAdotantes) {
            if (adotante.getId() == id) {
                adotanteParaEditar = adotante;
                break;
            }
        }

        if (adotanteParaEditar == null) {
            System.out.println("Adotante com ID " + id + " não encontrado.");
            return;
        }

        // Mostrar dados atuais
        System.out.println("===============================");
        System.out.println("Editando adotante: ");
        System.out.println("===============================");
        adotanteParaEditar.gerarRelatorio();
        System.out.println("===============================");

        // Solicitar novos dados
        System.out.print("Digite novo CPF (ou Enter para manter): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty()) {
            adotanteParaEditar.setCpf(cpf);
        }

        System.out.print("Digite novo endereço (ou Enter para manter): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) {
            adotanteParaEditar.setEndereco(endereco);
        }

        System.out.print("Digite novas preferências (ou Enter para manter): ");
        String preferencias = scanner.nextLine();
        if (!preferencias.isEmpty()) {
            adotanteParaEditar.setPreferencias(preferencias);
        }

        if (adotanteParaEditar.validar()) {
            System.out.println("Adotante atualizado com sucesso!");
        } else {
            System.out.println("Dados inválidos após edição. Alterações não foram aplicadas.");
        }
    }

    public static void alternarStatusAdotante() {
        scanner.nextLine();
        System.out.print("Digite o ID do adotante para alterar status: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Adotante adotante = buscarAdotantePorId(id);
        if (adotante != null) {
            adotante.setAtivo(!adotante.isAtivo());
            System.out.println("Status do adotante '" + adotante.getCpf() + "' agora é: " + (adotante.isAtivo() ? "Ativo" : "Inativo"));
        } else {
            System.out.println("Adotante com ID " + id + " não encontrado.");
        }
    }

    private static Adotante buscarAdotantePorId(int id) {
        for (Adotante a : listaAdotantes) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public static void listarTodosAdotantes() {
        System.out.println("\n📋 Lista de Todos os Adotantes:");

        if (listaAdotantes.isEmpty()) {
            System.out.println("Nenhum adotante cadastrado.");
            return;
        }

        for (Adotante adotante : listaAdotantes) {
            System.out.println("===============================");
            adotante.gerarRelatorio();
            System.out.println("===============================");
        }
    }

    //Métodos do Menu de Gestão de Animais

    public static void adicionarCao() {
        scanner.nextLine();

        System.out.println("\n=== Cadastro de Cachorro ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Condição de Saúde: ");
        String condicaoSaude = scanner.nextLine();

        System.out.print("Temperamento: ");
        String temperamento = scanner.nextLine();

        // STATUS
        System.out.println("===============================");
        System.out.println("Estágio de Adoção:");
        System.out.println("[1] Disponível");
        System.out.println("[2] Adotado");
        System.out.println("[3] Em tratamento");
        System.out.println("===============================");
        System.out.print("Escolha o Estágio: ");
        int opcStatus = scanner.nextInt();
        scanner.nextLine();

        String estagio;
        switch (opcStatus) {
            case 1:
                estagio = "Disponível";
                break;
            case 2:
                estagio = "Adotado";
                break;
            case 3:
                estagio = "Em tratamento";
                break;
            default:
                estagio = "Indefinido";
        }

        // PORTE
        System.out.println("===============================");
        System.out.println("Porte:");
        System.out.println("[1] Pequeno");
        System.out.println("[2] Médio");
        System.out.println("[3] Grande");
        System.out.println("===============================");
        System.out.print("Escolha o porte: ");
        int opcPorte = scanner.nextInt();
        scanner.nextLine();

        String porte;
        switch (opcPorte) {
            case 1:
                porte = "Pequeno";
                break;
            case 2:
                porte = "Médio";
                break;
            case 3:
                porte = "Grande";
                break;
            default:
                porte = "Indefinido";
        }

        // PASSEIO
        System.out.println("===============================");
        System.out.println("Necessita passeio?");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        System.out.println("===============================");
        System.out.print("Escolha: ");
        int opcPasseio = scanner.nextInt();
        scanner.nextLine();
        boolean necessitaPasseio = opcPasseio == 1;

        Cao novoCao = new Cao(nome, idade, condicaoSaude, temperamento, estagio, porte, necessitaPasseio);
        listaAnimais.add(novoCao);

        System.out.println("✅ Cachorro cadastrado com sucesso!");
    }

    public static void adicionarGato() {
        scanner.nextLine();

        System.out.println("\n=== Cadastro de Gato ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Condição de Saúde: ");
        String condicaoSaude = scanner.nextLine();

        System.out.print("Temperamento: ");
        String temperamento = scanner.nextLine();

        // STATUS
        System.out.println("===============================");
        System.out.println("Estágio de Adoção:");
        System.out.println("[1] Disponível");
        System.out.println("[2] Adotado");
        System.out.println("[3] Em tratamento");
        System.out.println("===============================");
        System.out.print("Escolha o Estágio: ");
        int opcEstagio = scanner.nextInt();
        scanner.nextLine();

        String estagio;
        switch (opcEstagio) {
            case 1:
                estagio = "Disponível";
                break;
            case 2:
                estagio = "Adotado";
                break;
            case 3:
                estagio = "Em tratamento";
                break;
            default:
                estagio = "Indefinido";
        }

        // CONVIVE COM OUTROS GATOS?
        System.out.println("===============================");
        System.out.println("Convive com outros gatos?");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        System.out.println("===============================");
        System.out.print("Escolha: ");
        int opcConvive = scanner.nextInt();
        scanner.nextLine();

        boolean conviveComOutrosGatos = opcConvive == 1;

        Gato novoGato = new Gato(nome, idade, condicaoSaude, temperamento, estagio, conviveComOutrosGatos);
        listaAnimais.add(novoGato);

        System.out.println("✅ Gato cadastrado com sucesso!");
    }

    public static void removerAnimal() {
        scanner.nextLine();

        System.out.print("Digite o ID do animal que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animalParaRemover = null;

        for (Animal animal : listaAnimais) {
            if (animal.getId() == id) {
                animalParaRemover = animal;
                break;
            }
        }

        if (animalParaRemover != null) {
            listaAnimais.remove(animalParaRemover);
            System.out.println("Animal removido com sucesso!");
        } else {
            System.out.println("Animal com ID " + id + " não encontrado.");
        }
    }

    public static void alternarStatusAnimal() {
        scanner.nextLine();
        System.out.print("Digite o ID do animal para alterar status: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animal = buscarAnimalPorId(id);
        if (animal != null) {
            animal.setAtivo(!animal.isAtivo());
            System.out.println("Status do animal '" + animal.getNome() + "' agora é: " + (animal.isAtivo() ? "Ativo" : "Inativo"));
        } else {
            System.out.println("Animal com ID " + id + " não encontrado.");
        }
    }

    private static Animal buscarAnimalPorId(int id) {
        for (Animal a : listaAnimais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public static void listarTodosAnimais() {
        System.out.println("\n📋 Lista de Todos os Animais:");

        if (listaAnimais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }

        for (Animal animal : listaAnimais) {
            System.out.println("===============================");
            animal.gerarRelatorio();
            System.out.println("===============================");
        }
    }

    //Métodos do Menu de Gestão de Adoções

    public static void gerarAdocao() {
        System.out.println("\n📄 Gerar nova Adoção (reserva):");

        // Verificar se há adotantes habilitados
        List<Adotante> adotantesHabilitados = listaAdotantes.stream()
                .filter(Adotante::isAtivo)
                .toList();

        if (adotantesHabilitados.isEmpty()) {
            System.out.println("❌ Nenhum adotante habilitado disponível.");
            return;
        }

        // Verificar se há animais disponíveis e saudáveis
        List<Animal> animaisDisponiveis = listaAnimais.stream()
                .filter(a -> a.isAtivo()
                        && a.getEstagio().equalsIgnoreCase("Disponível"))
                .toList();

        if (animaisDisponiveis.isEmpty()) {
            System.out.println("❌ Nenhum animal disponível e saudável para adoção.");
            return;
        }

        // Mostrar adotantes disponíveis
        System.out.println("\n👨‍👩‍👧 Adotantes disponíveis:");
        for (Adotante a : adotantesHabilitados) {
            System.out.println("[" + a.getId() + "] " + a.getNome());
        }

        System.out.print("Digite o ID do adotante: ");
        int idAdotante = scanner.nextInt();

        Adotante adotanteSelecionado = adotantesHabilitados.stream()
                .filter(a -> a.getId() == idAdotante)
                .findFirst()
                .orElse(null);

        if (adotanteSelecionado == null) {
            System.out.println("❌ Adotante inválido.");
            return;
        }

        // Mostrar animais disponíveis
        System.out.println("\n🐶 Animais disponíveis:");
        for (Animal animal : animaisDisponiveis) {
            System.out.println("[" + animal.getId() + "] " + animal.getNome() + " - " + animal.getEspecie());
        }

        System.out.print("Digite o ID do animal: ");
        int idAnimal = scanner.nextInt();

        Animal animalSelecionado = animaisDisponiveis.stream()
                .filter(a -> a.getId() == idAnimal)
                .findFirst()
                .orElse(null);

        if (animalSelecionado == null) {
            System.out.println("❌ Animal inválido.");
            return;
        }

        // Criar nova adoção pendente
        System.out.print("Data da solicitação (dd/mm/aaaa): ");
        scanner.nextLine();
        String data = scanner.nextLine();

        Adocao novaAdocao = new Adocao(adotanteSelecionado, animalSelecionado, data, false);
        listaAdocoes.add(novaAdocao);

        animalSelecionado.setEstagio("Em processo");

        System.out.println("✅ Adoção gerada com sucesso! Aguardando assinatura do termo.");
    }

    public static void realizarAdocao() {
        System.out.println("\n🤝 Realizar adoção:");

        // Filtrar adoções pendentes (termo assinado = false)
        List<Adocao> adocoesPendentes = listaAdocoes.stream()
                .filter(a -> !a.isTermoAssinado())
                .toList();

        if (adocoesPendentes.isEmpty()) {
            System.out.println("❌ Não há adoções pendentes para realizar.");
            return;
        }

        // Listar adoções pendentes
        System.out.println("Adoções pendentes:");
        for (Adocao a : adocoesPendentes) {
            System.out.println("ID: " + a.getId() + " - Adotante: " + a.getAdotante().getNome() +
                    ", Animal: " + a.getAnimalAdotado().getNome());
        }

        System.out.print("Digite o ID da adoção para realizar: ");
        int idAdocao = scanner.nextInt();

        Adocao adocaoSelecionada = adocoesPendentes.stream()
                .filter(a -> a.getId() == idAdocao)
                .findFirst()
                .orElse(null);

        if (adocaoSelecionada == null) {
            System.out.println("❌ Adoção inválida.");
            return;
        }

        // Marcar termo como assinado
        adocaoSelecionada.setTermoAssinado(true);

        System.out.println("✅ Adoção realizada com sucesso!");
    }

    public static void listarAdocoes() {
        System.out.println("\n📋 Lista de Adoções:");

        if (listaAdocoes.isEmpty()) {
            System.out.println("Nenhuma adoção cadastrada.");
            return;
        }

        for (Adocao adocao : listaAdocoes) {
            System.out.println("===============================");
            adocao.gerarRelatorio();
            System.out.println("===============================");
        }
    }
}



