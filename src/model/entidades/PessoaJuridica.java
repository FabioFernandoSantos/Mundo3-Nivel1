package model.entidades;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {

    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
        super(); // Chama o construtor da classe pai (Pessoa)
    }

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome); // Chama o construtor da classe pai com id e nome
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        super.exibir();
        // Exibe as informações do objeto
        System.out.println("CNPJ: " + cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
