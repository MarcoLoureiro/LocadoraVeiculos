import Automoveis.Caminhao;
import Automoveis.Carro;
import Automoveis.Moto;
import Automoveis.Veiculo;
import Negocio.ConcessionariaVeiculos;
import Negocio.ContabilizadoraVeiculos;
import Pessoas.Pessoa;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import Pessoas.PessoaFisica;
import Pessoas.PessoaJuridica;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Chevrolet","pequeno","TO7-OVN");
        Moto moto = new Moto("Honda","medio","TO5-QTN");
        Caminhao caminhao = new Caminhao("BMW","SUV","OVO-VIAJAR");
        List<Veiculo> listaDeVeiculos = new ArrayList<>(List.of(carro,moto,caminhao));
        System.out.println(listaDeVeiculos);
        ConcessionariaVeiculos concessionariaVeiculos = new ConcessionariaVeiculos();


        Pessoa p = new Pessoa();
        PessoaFisica pessoaFisica = new PessoaFisica("José",123456);
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Marco",01020304);
        List<Pessoa> listaPessoas = new ArrayList<>(List.of(pessoaFisica,pessoaJuridica));

        for (Pessoa pessoa: listaPessoas) {
            if(pessoa instanceof PessoaJuridica)
                System.out.println("{"+((PessoaJuridica) pessoa).getNome()+"}");
            if(pessoa instanceof PessoaFisica)
                System.out.print("{"+((PessoaFisica) pessoa).getNome()+"}");
        }

        p.cadastrarNaLista(listaPessoas);
        System.out.println("CPF ou CNPJ da Pessoa buscada: "+p.buscar(listaPessoas,"123456"));
        p.atualizar(listaPessoas,"123456");

        for (Pessoa pessoa: listaPessoas) {
            if(pessoa instanceof PessoaJuridica)
                System.out.println("{"+((PessoaJuridica) pessoa).getNome()+"}");
            if(pessoa instanceof PessoaFisica)
                System.out.print("{"+((PessoaFisica) pessoa).getNome()+"}");
        }

        try {
            concessionariaVeiculos.alugar(listaDeVeiculos);
            concessionariaVeiculos.devolver(listaDeVeiculos,"OVO-VIAJAR");
            concessionariaVeiculos.cadastrarNaLista(listaDeVeiculos);

            System.out.println(listaDeVeiculos);

            concessionariaVeiculos.buscar(listaDeVeiculos,"T07-OVN");
            concessionariaVeiculos.atualizar(listaDeVeiculos,"OVO-VIAJAR");

            System.out.println(listaDeVeiculos);
        } catch (InstanceNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}