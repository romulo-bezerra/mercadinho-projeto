package br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto;

import br.edu.ecit.primeiroprojeto.mercadinho.modelo.enumeracao.ClassificacaoProdutoAlimento;
import java.time.LocalDate;
import java.util.Objects;

public final class Alimento extends Produto {

    private ClassificacaoProdutoAlimento classificacaoAlimento;

    public Alimento(String descricao, LocalDate dataFabricacao,
            LocalDate dataValidade, float valor,
            ClassificacaoProdutoAlimento classificacaoAlimento) {
        super(descricao, dataFabricacao, dataValidade, valor);
        this.classificacaoAlimento = classificacaoAlimento;
    }

    public ClassificacaoProdutoAlimento getClassificacaoAlimento() {
        return classificacaoAlimento;
    }

    public void setClassificacaoAlimento(ClassificacaoProdutoAlimento classificacaoAlimento) {
        this.classificacaoAlimento = classificacaoAlimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.classificacaoAlimento);
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
        final Alimento other = (Alimento) obj;
        if (this.classificacaoAlimento != other.classificacaoAlimento) {
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
                + ", classificacaoAlimento=" + classificacaoAlimento + '}';
    }

}
