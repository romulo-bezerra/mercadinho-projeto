package br.edu.ecit.primeiroprojeto.mercadinho.modelo;

import br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Estoque {

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
    
    public Boolean removerProduto(int codigoProduto) {
        Produto resultado = buscarProdutoPorCodigo(codigoProduto);
        return produtos.remove(resultado);
    }
    
    public Boolean atualizarProduto(Produto produtoAtualizado) {
        Produto produto = buscarProdutoPorCodigo(produtoAtualizado.getCodigo());
        return produtos.remove(produto) && produtos.add(produtoAtualizado);
    }
    
    public Produto buscarProdutoPorCodigo(int codigoProduto) {
        for (Produto produto : produtos) 
            if (produto.getCodigo() == codigoProduto) return produto;
        return null;
    }
    
    public int recuperarQuantidadeProdutosCadastrados() {
        return produtos.size();
    }
    
    public List<Produto> listarTodosProdutos() {
        return produtos;
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
