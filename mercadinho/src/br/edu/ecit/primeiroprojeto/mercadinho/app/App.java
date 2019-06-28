package br.edu.ecit.primeiroprojeto.mercadinho.app;

import br.edu.ecit.primeiroprojeto.mercadinho.modelo.Estoque;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.Mercadinho;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.Proprietario;
import br.edu.ecit.primeiroprojeto.mercadinho.modelo.enumeracao.Sexo;
import java.time.LocalDate;
import java.time.Month;

public class App {
    
    public static void main(String[] args) {
        
        LocalDate nascimento = LocalDate.of(1997, Month.MARCH, 10);
        Proprietario proprietario = new Proprietario("Rômulo", nascimento, Sexo.MASCULINO);
        
        Estoque estoque = new Estoque();
        Mercadinho mercadinho = new Mercadinho("São Lunga", proprietario, estoque);
        
        
    }
    
}