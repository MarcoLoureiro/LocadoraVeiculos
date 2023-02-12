package Interfaces;

import java.util.List;

public interface GenericoDAO<E> {
    void cadastrarNaLista(List<E> listaDeVeiculosOuPessoas);
    E buscar(List<E> listaDeVeiculosOuPessoas,String identificador);
    void atualizar(List<E> listaDeVeiculosOuPessoas, String identificador);
}
