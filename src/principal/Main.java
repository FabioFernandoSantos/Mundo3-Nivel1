package principal;

import java.io.IOException;
import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

public class Main {

    public static void main(String[] args) {
        // Instanciando o primeiro repositório
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        // Adicionando duas pessoas físicas
        PessoaFisica pf1 = new PessoaFisica(1, "Julio Marques", "123.456.789-00", 36);
        PessoaFisica pf2 = new PessoaFisica(2, "Ingrid Albuquerque", "987.654.321-00", 35);

        repo1.inserir(pf1);
        repo1.inserir(pf2);

        // Persistindo os dados em um arquivo
        String nomeArquivo = "pessoasFisicas.dat";
        try {
            repo1.persistir(nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro: " + e);
        }

        // Instanciando o segundo repositório
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        // Recuperando os dados do arquivo
        try {
            repo2.recuperar(nomeArquivo);
            System.out.println("## Dados de Pessoas Fisicas Armazenados");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro: " + e);
        }

        System.out.println("### Pessoas Cadastradas:");
        for (PessoaFisica pf : repo2.obterTodos()) {
            pf.exibir();
        }

        // Instanciando o repositório de pessoas jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        // Adicionando duas pessoas jurídicas
        PessoaJuridica pj1 = new PessoaJuridica(1, "XPTO Sales", "12.345.678/0001-99");
        PessoaJuridica pj2 = new PessoaJuridica(2, "XPTO Solutions", "98.765.432/0001-11");

        repo3.inserir(pj1);
        repo3.inserir(pj2);

        // Persistindo os dados em um arquivo
        String nomeArquivoPJ = "pessoasJuridicas.dat";
        try {
            repo3.persistir(nomeArquivoPJ);
            System.out.println("\n## Dados de Pessoas Juridicas Armazenados");
        } catch (IOException e) {
            System.err.println("Erro Encontrado: " + e);
        }

        // Instanciando o segundo repositório de pessoas jurídicas
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        // Recuperando os dados do arquivo
        String nomeArquivoPJ2 = "pessoasJuridicas.dat"; // O mesmo nome de arquivo usado para persistir
        try {
            repo4.recuperar(nomeArquivoPJ2);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro Encontrado: " + e);
        }

        // Exibindo os dados das pessoas jurídicas recuperadas
        System.out.println("### Pessoas Juridicas Recuperadas:");
        for (PessoaJuridica pj : repo4.obterTodos()) {
            pj.exibir();
        }

    }
}
