package Negocio;

import Automoveis.Veiculo;
import Interfaces.Calculadora;
import Pessoas.PessoaFisica;
import Pessoas.PessoaJuridica;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContabilizadoraVeiculos implements Calculadora {

    @Override
    public int calcularNumeroDeDiarias(Veiculo veiculo) {
        Integer dias = 0;
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataInicio = LocalDateTime.parse(JOptionPane.showInputDialog(null, "Digite a data inicial (Ex: 21/05/2023 15:00)"), dateTimeFormatter);
            LocalDateTime dataFim = LocalDateTime.parse(JOptionPane.showInputDialog(null, "Digite a data de saída (Ex: 22/05/2023 15:00"), dateTimeFormatter);
            String tipoPessoa = JOptionPane.showInputDialog(null,"Digite se você é pessoa fisica ou juridica (ex: fisica)");
            if(tipoPessoa.equals("fisica")){
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setNome("Marco");
                pessoaFisica.setCpf(123456);
                veiculo.setPessoaFisica(pessoaFisica);
            }else{
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setNome("Marco");
                pessoaJuridica.setCnpj(12341243);
                veiculo.setPessoaJuridica(pessoaJuridica);
            }
            veiculo.setDataInicio(dataInicio);
            veiculo.setDataFim(dataFim);
            dias = (int) Math.ceil(Duration.between(veiculo.getDataInicio(), veiculo.getDataFim()).toDays());
        } catch (RuntimeException e) {
            System.out.println("Erro, data mal formatada " + e.getMessage());
        }

        return dias;
    }

    @Override
    public int calcularTamanho(Veiculo veiculo) {
        Integer valorTamanho = 0;
        switch (veiculo.getTamanho()) {
            case "pequeno":
                valorTamanho = 100;
                break;
            case "medio":
                valorTamanho = 150;
                break;
            case "SUV":
                valorTamanho = 200;
                break;
        }
        return valorTamanho;
    }

}
