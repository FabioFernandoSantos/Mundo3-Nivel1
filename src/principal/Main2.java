package principal;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

public class Main2 {

    private static Scanner scanner = new Scanner(System.in);
    private static PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
    private static PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer do scanner
            processarOpcao(opcao);
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opcao:");
        System.out.println("=====================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo ID");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Dados");
        System.out.println("0 - Finalizar Programa");
        System.out.println("=====================");
        System.out.print("Digite uma opcao: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> incluir();
            case 2 -> alterar();
            case 3 -> excluir();
            case 4 -> exibirPorId();
            case 5 -> exibirTodos();
            case 6 -> salvarDados();
            case 7 -> recuperarDados();
            case 0 -> System.out.println("Finalizando...");
            default -> System.out.println("\n ## Opção inválida! ##");
        }
    }

    private static void incluir() {
        System.out.println("Incluir Pessoa (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            PessoaFisica pf = new PessoaFisica();

            System.out.println("Digite um ID: ");
            pf.setId(parseInt(scanner.nextLine()));

            System.out.println("Digite o nome: ");
            pf.setNome(scanner.nextLine());

            System.out.println("Digite o CPF: ");
            pf.setCpf(scanner.nextLine());

            System.out.println("Digite a idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            pf.setIdade(idade);

            repoFisica.inserir(pf);
            System.out.println("\n## Pessoa Fisica adicionada com sucesso! ##");
        } else if (tipo == 2) {
            PessoaJuridica pj = new PessoaJuridica();

            System.out.println("Digite um ID: ");
            pj.setId(parseInt(scanner.nextLine()));

            System.out.println("Digite o nome:");
            pj.setNome(scanner.nextLine());

            System.out.println("Digite o CNPJ:");
            pj.setCnpj(scanner.nextLine());

            repoJuridica.inserir(pj);
            System.out.println("\n## Pessoa Juridica adicionada com sucesso! ##");
        } else {
            System.out.println("\n## Tipo inválido. ##");
        }
    }

    private static void alterar() {
        System.out.println("Alterar Pessoa (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o ID da pessoa:");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            PessoaFisica pf = repoFisica.obter(id);
            if (pf != null) {
                System.out.println("Dados atuais: ");
                pf.exibir();

                System.out.println("Digite o novo nome (deixe em branco para nao alterar):");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) {
                    pf.setNome(nome);
                }

                System.out.println("Digite o novo CPF (deixe em branco para nao alterar):");
                String cpf = scanner.nextLine();
                if (!cpf.isEmpty()) {
                    pf.setCpf(cpf);
                }

                System.out.println("Digite a nova idade (insira 0 para nao alterar):");
                int idade = scanner.nextInt();
                scanner.nextLine();
                if (idade != 0) {
                    pf.setIdade(idade);
                }

                repoFisica.alterar(pf);
                System.out.println("\n## Pessoa Fisica atualizada com sucesso!");
            } else {
                System.out.println("\n## Pessoa Fisica não encontrada.");
            }
        } else if (tipo == 2) {
            PessoaJuridica pj = repoJuridica.obter(id);
            if (pj != null) {
                System.out.println("Dados atuais: ");
                pj.exibir();

                System.out.println("Digite o novo nome (deixe em branco para nao alterar):");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) {
                    pj.setNome(nome);
                }

                System.out.println("Digite o novo CNPJ (deixe em branco para nao alterar):");
                String cnpj = scanner.nextLine();
                if (!cnpj.isEmpty()) {
                    pj.setCnpj(cnpj);
                }

                repoJuridica.alterar(pj);
                System.out.println("\n## Pessoa Juridica atualizada com sucesso! ##");
            } else {
                System.out.println("\n## Pessoa Juridica não encontrada. ##");
            }
        } else {
            System.out.println("\n## Tipo invalido. ##");
        }
    }

    private static void excluir() {
        System.out.println("Excluir Pessoa (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer do scanner

        System.out.println("Digite o ID da pessoa a ser excluída:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer do scanner

        if (tipo == 1) {
            PessoaFisica pf = repoFisica.obter(id);
            if (pf != null) {
                repoFisica.excluir(id);
                System.out.println("\n## Pessoa Fisica removida com sucesso! ##");
            } else {
                System.out.println("\n## Pessoa Fisica não encontrada. ##");
            }
        } else if (tipo == 2) {
            PessoaJuridica pj = repoJuridica.obter(id);
            if (pj != null) {
                repoJuridica.excluir(id);
                System.out.println("\n## Pessoa Jurídica removida com sucesso! ##");
            } else {
                System.out.println("\n## Pessoa Jurídica não encontrada. ##");
            }
        } else {
            System.out.println("\n## Tipo inválido. ##");
        }
    }

    private static void exibirPorId() {
        // Implementação para exibir uma entidade com base no tipo e ID
    }

    private static void exibirTodos() {
        // Implementação para exibir todas as entidades de um tipo
    }

    private static void salvarDados() {
        // Implementação para salvar dados em um arquivo ou banco de dados
    }

    private static void recuperarDados() {
        // Implementação para recuperar dados de um arquivo ou banco de dados
    }
}
