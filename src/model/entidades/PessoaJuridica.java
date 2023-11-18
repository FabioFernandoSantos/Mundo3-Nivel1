package model.entidades;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {

    // Campo adicional
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
        super(); // Chama o construtor da classe pai (Pessoa)
    }

    // Construtor completo
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome); // Chama o construtor da classe pai com id e nome
        this.cnpj = cnpj;
    }

    // Método exibir() sobrescrito
    @Override
    public void exibir() {
        // Primeiro chama o método exibir da classe pai
        super.exibir();
        // Em seguida, imprime as informações do CNPJ
        System.out.println("CNPJ: " + cnpj);
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
