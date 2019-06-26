package br.edu.ecit.primeiroprojeto.mercadinho.modelo;

import java.util.Objects;

public class Mercadinho {

    private String nome;
    private Proprietario proprietario;
    private Estoque estoque;
    
    public Mercadinho() {}

    public Mercadinho(String nome, Proprietario proprietario, Estoque estoque) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.proprietario);
        hash = 43 * hash + Objects.hashCode(this.estoque);
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
        final Mercadinho other = (Mercadinho) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.proprietario, other.proprietario)) {
            return false;
        }
        if (!Objects.equals(this.estoque, other.estoque)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mercadinho{" + "nome=" + nome + ", proprietario=" 
                + proprietario + ", estoque=" + estoque + '}';
    }
    
}
