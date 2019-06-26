package br.edu.ecit.primeiroprojeto.mercadinho.app;

import br.edu.ecit.primeiroprojeto.mercadinho.modelo.Estoque;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.Mercadinho;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.Proprietario;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.enumeracao.ClassificacaoProdutoAlimento;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.enumeracao.ClassificacaoProdutoLimpeza;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.enumeracao.Sexo;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto.Alimento;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto.Bebida;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto.Limpeza;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto.Produto;
import java.time.LocalDate;
import java.time.Month;

public class App {
    
    public static void main(String[] args) {
        
        LocalDate nascimento = LocalDate.of(1997, Month.MARCH, 10);
        Proprietario proprietario = new Proprietario("Rômulo", nascimento, Sexo.MASCULINO);
        
        Estoque estoque = new Estoque();
        Mercadinho mercadinho = new Mercadinho("São Lunga", proprietario, estoque);
        
        Produto macarrao = new Alimento(ClassificacaoProdutoAlimento.ARTIFICIAL,
                "Macarrão", LocalDate.of(2019, Month.MARCH, 10), 
                LocalDate.of(2019, Month.OCTOBER, 10), 10F);
        
        Produto vodka = new Bebida(14F, "Vodka Sky", LocalDate.of(2019, Month.OCTOBER, 9), 
                LocalDate.of(2019, Month.OCTOBER, 10), 10F);
        
        Produto detergente = new Limpeza(ClassificacaoProdutoLimpeza.NAO_NOCIVO,
                "Detergente", LocalDate.of(2019, Month.MARCH, 9), 
                LocalDate.of(2019, Month.OCTOBER, 10), 10F);
        
        Produto shampoo = new Limpeza(ClassificacaoProdutoLimpeza.NAO_NOCIVO,
                "Shampoo", LocalDate.of(2019, Month.MARCH, 10), LocalDate.of(2019, Month.JUNE, 20), 10F);
        
        estoque.adicionarProduto(vodka);
        estoque.adicionarProduto(macarrao);
        estoque.adicionarProduto(detergente);
        estoque.adicionarProduto(shampoo);
        
        System.out.println("Produtos no Estoque: " + estoque.toString());
        System.out.println("Quantidade Produtos Cadastrados: " + estoque.recuperarQuantidadeProdutosCadastrados());
        System.out.println("Produto mais antigo: " + estoque.recuperarProdutoMaisAntigo().toString());
        System.out.println("Produtos vencidos: " + estoque.recuperarProdutosVencidos().toString());
        System.out.println("Valor total de produtos: " + estoque.valorTotalProdutos());
        
    }
    
}