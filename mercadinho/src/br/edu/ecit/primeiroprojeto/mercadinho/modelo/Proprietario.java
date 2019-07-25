package br.edu.ecit.primeiroprojeto.mercadinho.modelo;

import br.edu.ecit.primeiroprojeto.mercadinho.modelo.enumeracao.Sexo;
import java.time.LocalDate;
import java.util.Objects;

public final class Proprietario {

    private String nome;
    private LocalDate nascimento;
    private Sexo sexo;

    public Proprietario() {}
    
    public Proprietario(String nome, LocalDate nascimento, Sexo sexo) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.nascimento);
        hash = 29 * hash + Objects.hashCode(this.sexo);
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
        final Proprietario other = (Proprietario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proprietario{" + "nome=" + nome + ", nascimento=" 
                + nascimento + ", sexo=" + sexo + '}';
    }
    
}
