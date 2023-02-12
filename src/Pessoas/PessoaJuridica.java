package Pessoas;

public class PessoaJuridica extends Pessoa{

    private String nome;
    private Integer cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, Integer cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }
}
