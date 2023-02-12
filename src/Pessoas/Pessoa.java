package Pessoas;

import Interfaces.GenericoDAO;
import Negocio.Menu;

import javax.swing.*;
import java.util.List;

public class Pessoa implements GenericoDAO {

    private PessoaFisica pessoaFisica;

    private PessoaJuridica pessoaJuridica;

    public Pessoa() {
    }

    public Pessoa(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Pessoa(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
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

    @Override
    public void cadastrarNaLista(List listaDeVeiculosOuPessoas) {
        Menu menu = new Menu();
        List<Pessoa> listaDePessoas = listaDeVeiculosOuPessoas;
        listaDePessoas.add(menu.mostrarMenuCadastroPessoa(listaDeVeiculosOuPessoas));
    }

    @Override
    public Object buscar(List listaDeVeiculosOuPessoas, String identificador) {
        List<Pessoa> listaPessoas = listaDeVeiculosOuPessoas;


        varrerLista:
        for (int i = 0; i < listaPessoas.size(); i++) {

            if (listaPessoas.get(i) instanceof PessoaFisica) {
                List<PessoaFisica> pessoaFisicaList = listaDeVeiculosOuPessoas;
                if (pessoaFisicaList.get(i).getCpf() == Integer.parseInt(identificador)) {
                    return ((PessoaFisica) listaPessoas.get(i)).getCpf();
                }
            } else if(listaPessoas.get(i) instanceof PessoaJuridica ){
                List<PessoaJuridica> pessoaJuridica = listaDeVeiculosOuPessoas;
                if (pessoaJuridica.get(i).getCnpj() == Integer.parseInt(identificador)) {
                    return ((PessoaJuridica) listaPessoas.get(i)).getCnpj();
                }
            }

        }
        return null;
    }

    @Override
    public void atualizar(List listaDeVeiculosOuPessoas, String identificador) {
        List<Pessoa> listaPessoas = listaDeVeiculosOuPessoas;
        varrerLista:
        for (int i = 0; i < listaPessoas.size(); i++) {
            if(listaPessoas.get(i) instanceof PessoaFisica){
                if (((PessoaFisica) listaPessoas.get(i)).getCpf() == Integer.parseInt(identificador)) {
                    List<PessoaFisica> pessoaFisicaList = listaDeVeiculosOuPessoas;
                    pessoaFisicaList.get(i).setNome(JOptionPane.showInputDialog(null, "Digite o novo nome para atualizar"));
                    pessoaFisicaList.get(i).setCpf(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo CPF para atualizar")));
                    JOptionPane.showMessageDialog(null, "Pessoa com cpf: " + pessoaFisicaList.get(i).getCpf()+" e nome "+pessoaFisicaList.get(i).getNome() + " atualizada!");
                    break varrerLista;
                }
            }else if(listaPessoas.get(i) instanceof PessoaJuridica){
                if(((PessoaJuridica) listaPessoas.get(i)).getCnpj() == Integer.parseInt(identificador)){
                    List<PessoaJuridica> pessoaJuridicaList = listaDeVeiculosOuPessoas;
                    pessoaJuridicaList.get(i).setNome(JOptionPane.showInputDialog(null, "Digite o novo nome para atualizar"));
                    pessoaJuridicaList.get(i).setCnpj(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo CNPJ para atualizar")));
                    JOptionPane.showMessageDialog(null, "Pessoa com cnpj: " + pessoaJuridicaList.get(i).getCnpj() +" e nome "+pessoaJuridicaList.get(i).getNome() + " atualizada!");
                    break varrerLista;
                }
            }
        }
    }

}