package Automoveis;

import Pessoas.PessoaFisica;
import Pessoas.PessoaJuridica;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Veiculo<E> {
    private String nome;
    private double aluguel;

    private String tamanho;

    private String placa;
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private List<Veiculo> veiculosAlugados;

    private PessoaFisica pessoaFisica;

    private PessoaJuridica pessoaJuridica;

    public Veiculo(String modelo,String tamanho,String placa) {
        this.nome = modelo;
        this.tamanho = tamanho;
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAluguel() {
        return aluguel;
    }

    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }

    public LocalDateTime getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<Veiculo> getVeiculosAlugados() {
        return veiculosAlugados;
    }

    @Override
    public String toString() {
        return "Veiculo {" +
                "nome='" + nome + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }


    public void setVeiculosAlugados(Veiculo veiculo) {
         getVeiculosAlugados().add(veiculo);
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
}
