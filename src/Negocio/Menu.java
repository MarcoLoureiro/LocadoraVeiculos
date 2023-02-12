package Negocio;

import Automoveis.Caminhao;
import Automoveis.Carro;
import Automoveis.Moto;
import Automoveis.Veiculo;
import Pessoas.Pessoa;
import Pessoas.PessoaFisica;
import Pessoas.PessoaJuridica;

import javax.swing.*;
import java.util.List;

public class Menu {

    public void mostrarMenuAtualizacao(Veiculo veiculo) {

        try {
            Integer opcao = 0;
            while (opcao != 4) {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu veiculo:\n" + "1 - Nome: " + veiculo.getNome() + "\n" +
                        "2- Tamanho: " + veiculo.getTamanho() + "\n 3- Placa: " + veiculo.getPlaca() + "\nDigite o número que deseja modificar"));
                switch (opcao) {
                    case 1:
                        veiculo.setNome(JOptionPane.showInputDialog(null, "Digite o novo nome do veículo"));
                        break;
                    case 2:
                        veiculo.setTamanho(JOptionPane.showInputDialog(null, "Digite o novo tamanho do veículo"));
                        break;
                    case 3:
                        veiculo.setPlaca(JOptionPane.showInputDialog(null, "Digite os digitos da nova placa"));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida " + e.getMessage());
        }
    }

    public Veiculo mostrarMenuCadastro(List<Veiculo> listaDeVeiculos) {

        String opcao = JOptionPane.showInputDialog(null, "Digite o tipo de veículo para cadastrar (ex: carro, moto ou caminhão :");
        if (opcao.equals("carro") || opcao.equals("moto") || opcao.equals("caminhão")) {
            String nomeVeiculo = JOptionPane.showInputDialog(null, "Digite o novo nome do veículo para cadastrar (ex: Relâmpago Marquinhos)");
            String placaVeiculo = JOptionPane.showInputDialog(null, "Digite os digitos da nova placa para cadastrar (ex: OVO-VIAJAR07)");
            String tamanhoVeiculo = JOptionPane.showInputDialog(null, "Digite o tamanho para cadastrar (ex: pequeno,medio,SUV):");

            boolean isCadastravel = isCadastravel(listaDeVeiculos, placaVeiculo);
            if (isCadastravel) {
                switch (opcao) {
                    case "carro":
                        Carro carro = new Carro(nomeVeiculo, tamanhoVeiculo, placaVeiculo);
//                            listaDeVeiculos.add(carro);
                        return carro;
                    case "moto":
                        Moto moto = new Moto(nomeVeiculo, tamanhoVeiculo, placaVeiculo);
//                            listaDeVeiculos.add(moto);
                        return moto;
                    case "caminhão":
                        Caminhao caminhao = new Caminhao(nomeVeiculo, tamanhoVeiculo, placaVeiculo);
//                            listaDeVeiculos.add(caminhao);
                        return caminhao;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de veículo inválido!");
            }
        }
        return null;

    }

    public Pessoa mostrarMenuCadastroPessoa(List<Pessoa> pessoas){
        String opcao = JOptionPane.showInputDialog(null, "Digite o tipo de pessoa para cadastrar (ex: fisica ou juridica):");
        switch (opcao){
            case "fisica":
                String nomePf = JOptionPane.showInputDialog(null, "Digite o nome");
                Integer cpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o cpf"));
                PessoaFisica pessoaFisica = new PessoaFisica(nomePf,cpf);
                return pessoaFisica;
            case "juridica":
                String nomePj = JOptionPane.showInputDialog(null, "Digite o nome");
                Integer cnpj = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o cnpj"));
                PessoaJuridica pessoaJuridica = new PessoaJuridica(nomePj,cnpj);
                return pessoaJuridica;
        }
        return null;
    }

    private static boolean isCadastravel(List<Veiculo> listaDeVeiculos, String placaVeiculo) {
        boolean isCadastravel = true;
        varrerLista:
        for (int i = 0; i < listaDeVeiculos.size(); i++) {
            if (listaDeVeiculos.get(i).getPlaca() == placaVeiculo) {
                JOptionPane.showMessageDialog(null, "Veículo com placa já cadastrada!");
                isCadastravel = false;
                break varrerLista;
            }
        }
        return isCadastravel;
    }
    



}
