package Negocio;

import Automoveis.Caminhao;
import Automoveis.Carro;
import Automoveis.Moto;
import Automoveis.Veiculo;
import Interfaces.GenericoDAO;
import Interfaces.Locadora;

import javax.management.InstanceNotFoundException;
import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class ConcessionariaVeiculos<E> implements Locadora, GenericoDAO {

    private Carro carro;
    private Moto moto;
    private Caminhao caminhao;


    ContabilizadoraVeiculos contabilizadora = new ContabilizadoraVeiculos();

    @Override
    public double alugar(List veiculos) throws InstanceNotFoundException {
        List<Veiculo> listaVeiculosConvertida = veiculos;
        String placasDisponiveisParaAlugar = "";
        for (Veiculo veiculo : listaVeiculosConvertida) {
            placasDisponiveisParaAlugar += " {" + veiculo.getPlaca() + "} ";
        }
        String placaParaAlugar = JOptionPane.showInputDialog(null, "Selecione uma placa dos veículos disponíveis para alugar: " + placasDisponiveisParaAlugar + "\n");
        if (!verificarAlugado(listaVeiculosConvertida, placaParaAlugar)) {
            Veiculo veiculoParaAlugar = (Veiculo) buscar(veiculos, placaParaAlugar);
            Integer quantidadeDiarias = contabilizadora.calcularNumeroDeDiarias(veiculoParaAlugar);
            veiculoParaAlugar.setAluguel(quantidadeDiarias * contabilizadora.calcularTamanho(veiculoParaAlugar));
            JOptionPane.showMessageDialog(null,"Veículo "+veiculoParaAlugar.getPlaca() +"\nAluguel: R$"+veiculoParaAlugar.getAluguel());
            return veiculoParaAlugar.getAluguel();
        }
        return 0;
    }

    @Override
    public boolean verificarAlugado(List veiculos, String placa) {

        boolean isAlugado = false;
        List<Veiculo> veiculosConvertidos = (List<Veiculo>) veiculos;

        for (int i = 0; i < veiculosConvertidos.size(); i++) {
            if(veiculosConvertidos.get(i).getPlaca().equals(placa) && veiculosConvertidos.get(i).getDataInicio() != null){
                isAlugado = true;
            }else{
                isAlugado = false;
            }
        }
//        Optional<Veiculo> veiculoRepetido = veiculosConvertidos.stream().
//                filter(v -> v.getPlaca().equals(placa)).
//                findFirst();
//        return veiculoRepetido.equals(placa) ? false : true;
        return isAlugado;
    }

    @Override
    public void cadastrarNaLista(List listaDeVeiculosOuPessoas) {
        Menu menu = new Menu();
        List<Veiculo> listaDeVeiculosParaVerificar = listaDeVeiculosOuPessoas;
        listaDeVeiculosParaVerificar.add(menu.mostrarMenuCadastro(listaDeVeiculosParaVerificar));
        JOptionPane.showMessageDialog(null, "Veiculo cadastrado!\n" + listaDeVeiculosParaVerificar);
    }

    @Override
    public Object buscar(List listaDeVeiculosOuPessoas, String identificador) {
        List<Veiculo> listaBuscada = listaDeVeiculosOuPessoas;
        varrerLista:
        for (int i = 0; i < listaBuscada.size(); i++) {
            if (listaBuscada.get(i).getPlaca().equals(identificador)) {
                return listaBuscada.get(i);
            } else if (listaBuscada.get(i).getPlaca().equals(identificador) && i == listaBuscada.size()) {
                JOptionPane.showMessageDialog(null, "Veículo de placa " + identificador + " não encontrado");
            }
        }
        return null;
    }

    //Parei aqui, falta ajeitar os metodos de crud pra buscar por placa (tira o Object e coloca String mesmo)
    @Override
    public void atualizar(List listaDeVeiculosOuPessoas, String placa) {
        List<Veiculo> listaConvertida = listaDeVeiculosOuPessoas;

        varrerLista:
        for (int i = 0; i < listaConvertida.size(); i++) {
            if (listaConvertida.get(i).getPlaca().equals(placa)) {
                listaConvertida.get(i).setNome(JOptionPane.showInputDialog(null, "Digite o novo nome"));
                listaConvertida.get(i).setPlaca(JOptionPane.showInputDialog(null, "Digite a nova placa"));
                listaConvertida.get(i).setTamanho(JOptionPane.showInputDialog(null, "Digite o novo tamanho"));
                JOptionPane.showMessageDialog(null, "Veículo de placa " + listaConvertida.get(i).getPlaca() + " atualizado!");
                break varrerLista;
            } else if (listaConvertida.get(i).getPlaca() != placa && i == listaConvertida.size()) {
                JOptionPane.showMessageDialog(null, "Veículo de placa " + placa + " não cadastrado");
            }
        }

    }

    public void devolver(List<Veiculo> veiculosAlugados, String placa) {
        if (!verificarAlugado(veiculosAlugados, placa)) {

        } else {
            for (int i = 0; i < veiculosAlugados.size(); i++) {
                double desconto = 0;
                if (veiculosAlugados.get(i).getPlaca().equals(placa)) {
                    int dias = (int) Math.ceil(Duration.between(veiculosAlugados.get(i).getDataInicio(), veiculosAlugados.get(i).getDataFim()).toDays());
                    if(dias > 5 && veiculosAlugados.get(i).getPessoaFisica() != null){
                        desconto = veiculosAlugados.get(i).getAluguel() * 0.05;
                            veiculosAlugados.get(i).setAluguel(veiculosAlugados.get(i).getAluguel() - desconto);
                    }else if(dias > 3 && veiculosAlugados.get(i).getPessoaJuridica() != null){
                            desconto = veiculosAlugados.get(i).getAluguel() * 0.1;
                            veiculosAlugados.get(i).setAluguel(veiculosAlugados.get(i).getAluguel() - desconto);
                    }else{

                    }
                    JOptionPane.showMessageDialog(null,"Veículo removido\nDesconto: "+desconto+"\naluguel: "+veiculosAlugados.get(i).getAluguel()+" R$");
                    veiculosAlugados.remove(i);
                }
            }
        }

    }


}

