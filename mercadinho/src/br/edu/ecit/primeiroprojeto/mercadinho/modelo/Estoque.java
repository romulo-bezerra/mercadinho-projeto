package br.edu.ecit.primeiroprojeto.mercadinho.modelo;

import br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private final List<Produto> produtos;
    
    public Estoque() {
        this.produtos = new ArrayList<>();
    }
    
    public Boolean adicionarProduto(Produto produto) {
        final int limiteProdutosEstoque = 1000;
    
        if (produtos.size() < limiteProdutosEstoque) {
            return produtos.add(produto);
        }
        return false;
    }
    
    public Boolean removerProduto(Produto produto) {
        return produtos.remove(produto);
    }
    
    public Boolean atualizarProduto(int codigoProduto, Produto produtoAtualizado) {
        Produto produtoRemovido = produtos.remove(codigoProduto);        
        produtoRemovido.setDataFabricacao(produtoAtualizado.getDataFabricacao());
        produtoRemovido.setDataValidade(produtoAtualizado.getDataValidade());
        produtoRemovido.setDescricao(produtoAtualizado.getDescricao());
        produtoRemovido.setValor(produtoAtualizado.getValor());
        return produtos.add(produtoRemovido);
    }
    
    public Produto buscarProdutoPorCodigo(int codigoProduto) {
        return produtos.get(codigoProduto);
    }
    
    public int recuperarQuantidadeProdutosCadastrados() {
        return produtos.size();
    }
    
    public float valorTotalProdutos() {
        float valorTotal = 0F;
        
        for (Produto produto : produtos) {
            valorTotal += produto.getValor();
        }
        return valorTotal;
    }
    
    public Produto recuperarProdutoMaisAntigo() {
        Produto produtoMaisAntigo = produtos.get(0);
        
        for (Produto produto : produtos) {
            LocalDate dataProdutoAtual = produto.getDataFabricacao();
            if (dataProdutoAtual.isBefore(produtoMaisAntigo.getDataFabricacao())) {
                produtoMaisAntigo = produto;
            }
        }
        return produtoMaisAntigo;
    }
    
    public List<Produto> recuperarProdutosVencidos() {        
        List<Produto> produtosVencidos = new ArrayList<>();
        
        for (Produto produto : produtos) {
            if (produto.getDataValidade().isBefore(LocalDate.now())) {
                produtosVencidos.add(produto);
            }
        }
        return produtosVencidos;
    }

    @Override
    public String toString() {
        return "Estoque{" + "produtos=" + produtos + '}';
    }
    
}
