package Interfaces;

import Automoveis.Veiculo;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface Locadora<E> {

    double alugar(List<? extends Veiculo> veiculos) throws InstanceNotFoundException;

    boolean verificarAlugado(List<E> veiculos, String placa);

}
