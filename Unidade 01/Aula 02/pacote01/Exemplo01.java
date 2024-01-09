package pacote01;

import pacote02.Carro;

public class Exemplo01 {
    public static void main(String[] args){
        Pessoa pessoa = new Pessoa();
        Produto produto = new Produto();
        Carro carro = new Carro();

        pessoa.setNome("Leo");
        pessoa.setIdade(27);
        System.out.println(pessoa.nome);
        System.out.println(pessoa.idade);
        //System.out.println(pessoa.peso);

        produto.setNome("Macarrao");
        produto.setPreco(10.50);
        System.out.println(produto.nome);
        System.out.println(produto.preco);
        //System.out.println(produto.peso);

        carro.setMarca("FIAT");
        System.out.println(carro.marca);
        //System.out.println(carro.modelo);
        //System.out.println(carro.cor);
    }
}
