package br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto;

import br.edu.ecit.primeiroprojeto.mercadinho.modelo.enumeracao.ClassificacaoProdutoLimpeza;
import java.time.LocalDate;
import java.util.Objects;

public final class Limpeza extends Produto {

    private ClassificacaoProdutoLimpeza classificacaoLimpeza;

    public Limpeza(String descricao, LocalDate dataFabricacao,
            LocalDate dataValidade, float valor,
            ClassificacaoProdutoLimpeza classificacaoLimpeza) {
        super(descricao, dataFabricacao, dataValidade, valor);
        this.classificacaoLimpeza = classificacaoLimpeza;
    }

    public ClassificacaoProdutoLimpeza getClassificacaoLimpeza() {
        return classificacaoLimpeza;
    }

    public void setClassificacaoLimpeza(ClassificacaoProdutoLimpeza classificacaoLimpeza) {
        this.classificacaoLimpeza = classificacaoLimpeza;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.classificacaoLimpeza);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Limpeza other = (Limpeza) obj;
        if (this.classificacaoLimpeza != other.classificacaoLimpeza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + super.getCodigo() + ", descricao="
                + super.getDescricao() + ", dataFabricacao="
                + super.getDataFabricacao() + ", dataValidade="
                + super.getDataValidade() + ", valor=" + super.getValor()
                + ", classificacaoLimpeza=" + classificacaoLimpeza + '}';
    }

}
