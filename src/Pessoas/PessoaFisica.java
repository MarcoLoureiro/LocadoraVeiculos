package Pessoas;

import java.util.List;

public class PessoaFisica extends Pessoa{
    private String nome;
    private Integer cpf;


    public PessoaFisica(){}
    public PessoaFisica(String nome, Integer cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }


}
