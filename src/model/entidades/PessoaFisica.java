package model.entidades;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {

    private String cpf;
    private int idade;

    // Construtor padrão
    public PessoaFisica() {
        super(); // Chama o construtor da classe pai (Pessoa)
    }

    // Construtor completo
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome); // Chama o construtor da classe pai com id e nome
        this.cpf = cpf;
        this.idade = idade;
    }

    @Override
    public void exibir() {
        // Chama o método exibir da classe pai
        super.exibir();
        // Mostra as informações do objeto
        System.out.println("CPF: " + cpf + ", Idade: " + idade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
