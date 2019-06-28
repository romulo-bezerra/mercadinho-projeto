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
        String nome = "João da Silva";
        Sexo sexo = Sexo.MASCULINO;
        Proprietario proprietario = new Proprietario(nome, nascimento, sexo);
        
        Estoque estoque = new Estoque();
        Mercadinho mercadinho = new Mercadinho("São Lunga");
        mercadinho.setEstoque(estoque);
        mercadinho.setProprietario(proprietario);
        
        imprimeDetalhesMercadinho(mercadinho);
        
        LocalDate dataValidade = LocalDate.of(2019, Month.DECEMBER, 1);
        LocalDate dataValidadeVencida = LocalDate.of(2019, Month.MARCH, 1);
        LocalDate dataFabricacao = LocalDate.of(2019, Month.MARCH, 1);
        LocalDate dataMaisAntiga = LocalDate.of(2018, Month.FEBRUARY, 1);
        
        //Alimentos
        Produto arroz = new Alimento("Arroz", dataFabricacao, dataValidade, 10, ClassificacaoProdutoAlimento.ARTIFICIAL);
        Produto feijao = new Alimento("Feijão", dataFabricacao, dataValidade, 10, ClassificacaoProdutoAlimento.ARTIFICIAL);
        Produto cuscuz = new Alimento("Cuscuz", dataMaisAntiga, dataValidade, 10, ClassificacaoProdutoAlimento.ARTIFICIAL);

        //Bebidas
        Produto passport = new Bebida("Passport", dataFabricacao, dataValidade, 10, 14);
        Produto vodkaSky = new Bebida("Vodka Sky", dataFabricacao, dataValidade, 10, 14);
        Produto blackEwhite = new Bebida("Black&White", dataFabricacao, dataValidade, 10, 14);
        
        //Limpeza
        Produto detergente = new Limpeza("Detergente", dataFabricacao, dataValidade, 10, ClassificacaoProdutoLimpeza.NAO_NOCIVO);
        Produto condicionador = new Limpeza("Condicionador", dataFabricacao, dataValidadeVencida, 10, ClassificacaoProdutoLimpeza.NAO_NOCIVO);
        Produto shampoo = new Limpeza("Shampoo", dataFabricacao, dataValidade, 10, ClassificacaoProdutoLimpeza.NAO_NOCIVO);
    
        //Salvando produtos
        estoque.adicionarProduto(arroz);
        estoque.adicionarProduto(feijao);
        estoque.adicionarProduto(cuscuz);
        estoque.adicionarProduto(passport);
        estoque.adicionarProduto(vodkaSky);
        estoque.adicionarProduto(blackEwhite);
        estoque.adicionarProduto(detergente);
        estoque.adicionarProduto(condicionador);
        estoque.adicionarProduto(shampoo);
        
        System.out.println("Atualizando Alimento Arroz.\nArroz antes: " + arroz);
        arroz.setValor(15);
        estoque.atualizarProduto(arroz);
        System.out.println("Atualizando Alimento Arroz.\nArroz depois: " + arroz);
        
        System.out.println("\nBuscando Alimento 'Feijão': " + estoque.buscarProdutoPorCodigo(2));
        
        System.out.println("\nRemovendo feijão: " + estoque.removerProduto(feijao));
        
        System.out.println("\nQuantidade de produtos cadastrados: " + estoque.recuperarQuantidadeProdutosCadastrados());
        
        System.out.println("\nValor total mercadorias no estoque: " + estoque.valorTotalProdutos());
        
        System.out.println("\nProduto mais antigo no estoque: " + estoque.recuperarProdutoMaisAntigo());
        
        System.out.println("\nProdutos vencidos no estoque: " + estoque.recuperarProdutosVencidos());
        
        System.out.println("\nListando todos os produtos");
        System.out.println(estoque.listarTodosProdutos());
        
    }
    
    public static void imprimeDetalhesMercadinho(Mercadinho mercadinho) {
        System.out.println("----- INFORMAÇÕES DO SISTEMA -----");
        System.out.println("- Mercadinho: " + mercadinho.getNome());
        System.out.println("- Detalhes do Proprietário");
        System.out.println("   -Nome: " + mercadinho.getProprietario().getNome());
        System.out.println("   -Sexo: " + mercadinho.getProprietario().getSexo());
        System.out.println("   -Nascimento: " + mercadinho.getProprietario().getNascimento() + "\n");
    }
    
}

    