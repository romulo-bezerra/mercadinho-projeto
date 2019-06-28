package br.edu.ecit.primeiroprojeto.mercadinho.modelo.produto;

import java.time.LocalDate;

public final class Bebida extends Produto {
    
    private float graduacaoAlcoolica;

    public Bebida(String descricao, LocalDate dataFabricacao, 
            LocalDate dataValidade, float valor, 
            float graduacaoAlcoolica) {
        super(descricao, dataFabricacao, dataValidade, valor);
        this.graduacaoAlcoolica = graduacaoAlcoolica;
    }

    public float getGraduacaoAlcoolica() {
        return graduacaoAlcoolica;
    }

    public void setGraduacaoAlcoolica(float graduacaoAlcoolica) {
        this.graduacaoAlcoolica = graduacaoAlcoolica;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Float.floatToIntBits(this.graduacaoAlcoolica);
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
        final Bebida other = (Bebida) obj;
        if (Float.floatToIntBits(this.graduacaoAlcoolica) != Float.floatToIntBits(other.graduacaoAlcoolica)) {
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
                + ", graduacaoAlcoolica=" + graduacaoAlcoolica + '}';
    }
    
}
