package br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Produto {

    private static int codigoSequencia;
    private final int codigo;
    private String descricao;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private float valor;
    
    public Produto(String descricao, LocalDate dataFabricacao,
            LocalDate dataValidade, float valor) {
        this.codigo = ++codigoSequencia;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.dataFabricacao);
        hash = 47 * hash + Objects.hashCode(this.dataValidade);
        hash = 47 * hash + Float.floatToIntBits(this.valor);
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataFabricacao, other.dataFabricacao)) {
            return false;
        }
        if (!Objects.equals(this.dataValidade, other.dataValidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao
                + ", dataFabricacao=" + dataFabricacao + ", dataValidade="
                + dataValidade + ", valor=" + valor + '}';
    }

}
