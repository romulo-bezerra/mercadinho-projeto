package br.edu.ecit.primeiroprojeto.mercadinho.loader;

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
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Loader {

    private final Proprietario proprietario;
    private final Mercadinho mercadinho;
    private final Estoque estoque;
    private final Scanner scanner;

    public Loader() {
        this.proprietario = new Proprietario();
        this.mercadinho = new Mercadinho();
        this.estoque = new Estoque();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Loader().executar();
    }

    private void executar() {
        exibirMensagensBoasVindasSistema();
        exibirOpcaCadastroProprietario();
        exibirOpcaoCadastroMercadinho();
        exibirDetalhesMercadinho(mercadinho);
        exibirOpcoesEstoque();
    }
    
    private void exibirOpcoesEstoque(){
        System.out.println("\n# Agora está quase tudo concluído.");
        System.out.println("# Vamos agora ao cadastro de produtos e às funcionalidades do estoque");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        while (true) {            
            exibirMenuEstoque();
            System.out.print("Opção: ");
            int opcaoMenuEstoque = Integer.parseInt(scanner.nextLine());

            switch (opcaoMenuEstoque) {
                
                case 1:
                    System.out.println("\n--------------------------------");
                    System.out.println("CADASTRO DE PRODUTO");
                    System.out.println("--------------------------------"); 
                    System.out.println("Informe o tipo de produto que deseja cadastrar.");
                    System.out.println("1 - Alimento");
                    System.out.println("2 - Bebida");
                    System.out.println("3 - Limpeza");
                    System.out.print("Opção: ");
                    int opcaoProduto = Integer.parseInt(scanner.nextLine());

                    switch (opcaoProduto) {
                        
                        case 1:
                            System.out.println("\nCadastrando alimento...");
                            System.out.print("Informe a descriçao do alimento: ");
                            String descricaoAlimento = scanner.nextLine();

                            System.out.print("Informe a data de fabricacao no formato (dd/mm/aaaa): ");
                            String fabricacao = scanner.nextLine();
                            LocalDate dataFabricacaoAlimento = LocalDate.parse(fabricacao, formatter);

                            System.out.print("Informe a data de validade no formato (dd/mm/aaaa): ");
                            String validade = scanner.nextLine();
                            LocalDate dataValidadeAlimento = LocalDate.parse(validade, formatter);

                            System.out.print("Informe o valor do alimento: ");
                            float valorAlimento = Float.parseFloat(scanner.nextLine());

                            System.out.println("Informe o tipo do alimento");
                            System.out.println("N - NATURAL / A - ARTIFICIAL");
                            System.out.print("Opção: ");
                            String classificacao = scanner.nextLine();
                            ClassificacaoProdutoAlimento classificacaoAlimento 
                                    = ClassificacaoProdutoAlimento.NATURAL;
                            if (classificacao.toUpperCase().trim().equalsIgnoreCase("A")) {
                                classificacaoAlimento = ClassificacaoProdutoAlimento.ARTIFICIAL;
                            }

                            Produto alimento = new Alimento(descricaoAlimento, 
                                    dataFabricacaoAlimento, dataValidadeAlimento, 
                                    valorAlimento, classificacaoAlimento);
                                    
                            if(this.estoque.adicionarProduto(alimento)){
                                System.out.println("--------------------------------");
                                System.out.println("Produto Alimento Cadastrado");
                                System.out.println("--------------------------------");
                            } else System.out.println("Alcançou o limite max de produtos");
                            break;
                        
                        case 2:
                            System.out.println("\nCadastrando bebida...");
                            System.out.print("Informe a descriçao da bebida: ");
                            String descricaoBebida = scanner.nextLine();

                            System.out.print("Informe a data de fabricacao no formato (dd/mm/aaaa): ");
                            String fabricacaoBebida = scanner.nextLine();
                            LocalDate dataFabricacaoBebida = LocalDate.parse(fabricacaoBebida, formatter);

                            System.out.print("Informe a data de validade no formato (dd/mm/aaaa): ");
                            String validadeBebida = scanner.nextLine();
                            LocalDate dataValidadeBebida = LocalDate.parse(validadeBebida, formatter);

                            System.out.print("Informe o valor da bebida: ");
                            float valorBebida = Float.parseFloat(scanner.nextLine());

                            System.out.print("Informe a graduação alcóolica da bebida: ");
                            float graduacaoAlcoolicaBebida = Float.parseFloat(scanner.nextLine());

                            Produto bebida = new Bebida(descricaoBebida, 
                                    dataFabricacaoBebida, dataValidadeBebida, 
                                    valorBebida, graduacaoAlcoolicaBebida);

                            if(this.estoque.adicionarProduto(bebida)){
                                System.out.println("--------------------------------");
                                System.out.println("Produto Bebida Cadastrado");
                                System.out.println("--------------------------------");
                            } else System.out.println("Alcançou o limite max de produtos");
                            break;
                        
                        case 3:
                            System.out.println("\nCadastrando produto limpeza...");
                            System.out.print("Informe a descriçao do produto de limpeza: ");
                            String descricaoProdutoLimpeza = scanner.nextLine();

                            System.out.print("Informe a data de fabricacao no formato (dd/mm/aaaa): ");
                            String fabricacaoProdutoLimpeza = scanner.nextLine();
                            LocalDate dataFabricacaoProdutoLimpeza = LocalDate.parse(fabricacaoProdutoLimpeza, formatter);

                            System.out.print("Informe a data de validade no formato (dd/mm/aaaa): ");
                            String validadeProdutoLimpeza = scanner.nextLine();
                            LocalDate dataValidadeProdutoLimpeza = LocalDate.parse(validadeProdutoLimpeza, formatter);

                            System.out.print("Informe o valor do produto de limpeza: ");
                            float valorProdutoLimpeza = Float.parseFloat(scanner.nextLine());

                            System.out.println("Informe o tipo do produto de limpeza");
                            System.out.println("N - NOCIVO / NN - NÃO NOCIVO");
                            System.out.print("Opção: ");
                            String classificacaoLimpeza = scanner.nextLine();
                            ClassificacaoProdutoLimpeza classificacaoProdutoLimpeza  = ClassificacaoProdutoLimpeza.NOCIVO;
                            if (classificacaoLimpeza.toUpperCase().trim().equalsIgnoreCase("NN")) {
                                classificacaoProdutoLimpeza = ClassificacaoProdutoLimpeza.NAO_NOCIVO;
                            }

                            Produto limpeza = new Limpeza(descricaoProdutoLimpeza, 
                                    dataFabricacaoProdutoLimpeza, dataValidadeProdutoLimpeza, 
                                    valorProdutoLimpeza, classificacaoProdutoLimpeza);

                            if(this.estoque.adicionarProduto(limpeza)){
                                System.out.println("--------------------------------");
                                System.out.println("Produto de Limpeza Cadastrado");
                                System.out.println("--------------------------------");
                            } else System.out.println("Alcançou o limite max de produtos");
                            break;
                        default:
                            System.out.println("\nA opção escolhida não corresponde a nenhuma ação!");
                    }
                  break;
                
                case 2:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nExcluindo um produto...");
                        System.out.println("Escolha o produto que deseja remover do estoque.");
                        System.out.println("Produtos: \n" + estoque.listarTodosProdutos());

                        System.out.print("Informe o codigo do produto que deseja remover: ");
                        int codigoProdutoRemover = Integer.parseInt(scanner.nextLine());
                        estoque.removerProduto(codigoProdutoRemover);

                        System.out.println("--------------------------------");
                        System.out.println("Produto removido");
                        System.out.println("--------------------------------");
                    } else System.out.println("\nNenhum prooduto no estoque");                    
                  break;
                
                case 3:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nAtualizando um produto...");
                        System.out.println("Escolha o produto que deseja atualizar no estoque.");
                        System.out.println("Produtos: \n" + estoque.listarTodosProdutos());

                        System.out.print("Informe o codigo do produto que deseja atualizar: ");
                        int codigoProdutoAtualizar = Integer.parseInt(scanner.nextLine());

                        Produto produtoAtualizar = estoque.buscarProdutoPorCodigo(codigoProdutoAtualizar);

                        if (produtoAtualizar instanceof Alimento){
                                System.out.print("Informe a descriçao do alimento: ");
                                String descricaoAlimentoAtualizar = scanner.nextLine();

                                System.out.print("Informe a data de fabricacao no formato (dd/mm/aaaa): ");
                                String fabricacaoAtualizar = scanner.nextLine();
                                LocalDate dataFabricacaoAlimentoAtualizar = LocalDate.parse(fabricacaoAtualizar, formatter);

                                System.out.print("Informe a data de validade no formato (dd/mm/aaaa): ");
                                String validadeAtualizar = scanner.nextLine();
                                LocalDate dataValidadeAlimentoAtualizar = LocalDate.parse(validadeAtualizar, formatter);

                                System.out.print("Informe o valor do alimento: ");
                                float valorAlimentoAtualizar = Float.parseFloat(scanner.nextLine());

                                System.out.println("Informe o tipo do alimento");
                                System.out.println("N - NATURAL / A - ARTIFICIAL");
                                System.out.print("Opção: ");
                                String classificacaoAtualizar = scanner.nextLine();
                                ClassificacaoProdutoAlimento classificacaoAlimentoAtualizar 
                                        = ClassificacaoProdutoAlimento.NATURAL;
                                if (classificacaoAtualizar.toUpperCase().trim().equalsIgnoreCase("A")) {
                                    classificacaoAlimentoAtualizar = ClassificacaoProdutoAlimento.ARTIFICIAL;
                                }

                                produtoAtualizar.setDescricao(descricaoAlimentoAtualizar);
                                produtoAtualizar.setDataFabricacao(dataFabricacaoAlimentoAtualizar);
                                produtoAtualizar.setDataValidade(dataValidadeAlimentoAtualizar);
                                produtoAtualizar.setValor(valorAlimentoAtualizar);
                                ((Alimento) produtoAtualizar).setClassificacaoAlimento(classificacaoAlimentoAtualizar);
                                this.estoque.atualizarProduto(produtoAtualizar);

                                System.out.println("--------------------------------");
                                System.out.println("Produto Alimento Atualizado");
                                System.out.println("--------------------------------");

                        } else if (produtoAtualizar instanceof Bebida){
                                System.out.println("\nAtualizando bebida...");
                                System.out.print("Informe a descriçao da bebida: ");
                                String descricaoBebidaAtualizar = scanner.nextLine();

                                System.out.print("Informe a data de fabricacao no formato (dd/mm/aaaa): ");
                                String fabricacaoBebidaAtualizar = scanner.nextLine();
                                LocalDate dataFabricacaoBebidaAtualizar = LocalDate.parse(fabricacaoBebidaAtualizar, formatter);

                                System.out.print("Informe a data de validade no formato (dd/mm/aaaa): ");
                                String validadeBebidaAtualizar = scanner.nextLine();
                                LocalDate dataValidadeBebidaAtualizar = LocalDate.parse(validadeBebidaAtualizar, formatter);

                                System.out.print("Informe o valor da bebida: ");
                                float valorBebidaAtualizar = Float.parseFloat(scanner.nextLine());

                                System.out.print("Informe a graduação alcóolica da bebida: ");
                                float graduacaoAlcoolicaBebidaAtualizar = Float.parseFloat(scanner.nextLine());

                                produtoAtualizar.setDescricao(descricaoBebidaAtualizar);
                                produtoAtualizar.setDataFabricacao(dataFabricacaoBebidaAtualizar);
                                produtoAtualizar.setDataValidade(dataValidadeBebidaAtualizar);
                                produtoAtualizar.setValor(valorBebidaAtualizar);
                                ((Bebida) produtoAtualizar).setGraduacaoAlcoolica(graduacaoAlcoolicaBebidaAtualizar);
                                this.estoque.atualizarProduto(produtoAtualizar);

                                System.out.println("--------------------------------");
                                System.out.println("Produto Bebida Atualizado");
                                System.out.println("--------------------------------");

                        } else if (produtoAtualizar instanceof Limpeza){
                                System.out.println("\nAtualizando produto limpeza...");
                                System.out.print("Informe a descriçao do produto de limpeza: ");
                                String descricaoProdutoLimpezaAtualizar = scanner.nextLine();

                                System.out.print("Informe a data de fabricacao no formato (dd/mm/aaaa): ");
                                String fabricacaoProdutoLimpezaAtualizar = scanner.nextLine();
                                LocalDate dataFabricacaoProdutoLimpezaAtualizar = LocalDate.parse(fabricacaoProdutoLimpezaAtualizar, formatter);

                                System.out.print("Informe a data de validade no formato (dd/mm/aaaa): ");
                                String validadeProdutoLimpezaAtualizar = scanner.nextLine();
                                LocalDate dataValidadeProdutoLimpezaAtualizar = LocalDate.parse(validadeProdutoLimpezaAtualizar, formatter);

                                System.out.print("Informe o valor do produto de limpeza: ");
                                float valorProdutoLimpezaAtualizar = Float.parseFloat(scanner.nextLine());

                                System.out.println("Informe o tipo do produto de limpeza");
                                System.out.println("N - NOCIVO / NN - NÃO NOCIVO");
                                System.out.print("Opção: ");
                                String classificacaoLimpezaAtualizar = scanner.nextLine();
                                ClassificacaoProdutoLimpeza classificacaoProdutoLimpezaAtualizar  = ClassificacaoProdutoLimpeza.NOCIVO;
                                if (classificacaoLimpezaAtualizar.toUpperCase().trim().equalsIgnoreCase("NN")) {
                                    classificacaoProdutoLimpezaAtualizar = ClassificacaoProdutoLimpeza.NAO_NOCIVO;
                                }

                                produtoAtualizar.setDescricao(descricaoProdutoLimpezaAtualizar);
                                produtoAtualizar.setDataFabricacao(dataFabricacaoProdutoLimpezaAtualizar);
                                produtoAtualizar.setDataValidade(dataValidadeProdutoLimpezaAtualizar);
                                produtoAtualizar.setValor(valorProdutoLimpezaAtualizar);
                                ((Limpeza) produtoAtualizar).setClassificacaoLimpeza(classificacaoProdutoLimpezaAtualizar);
                                this.estoque.atualizarProduto(produtoAtualizar);

                                System.out.println("--------------------------------");
                                System.out.println("Produto Limpeza Atualizado");
                                System.out.println("--------------------------------");
                        }
                    } else System.out.println("\nNenhum prooduto no estoque");  
                    break;
                
                case 4:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nBuscando um produto...");
                        System.out.println("Escolha o produto que deseja visualizar no estoque.");
                        System.out.println("Produtos: \n" + estoque.listarTodosProdutos());

                        System.out.print("Informe o codigo do produto que deseja visualizar: ");
                        int codigoProdutoVisualizar = Integer.parseInt(scanner.nextLine());

                        System.out.println("\nProduto: " + estoque.buscarProdutoPorCodigo(codigoProdutoVisualizar));
                    } else System.out.println("\nNenhum prooduto no estoque");  
                    break;
                
                case 5:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nProdutos do estoque: \n" + estoque.listarTodosProdutos());
                    } else System.out.println("\nNenhum prooduto no estoque");  
                    break;
                
                case 6:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nQuantidade de produtos cadastrados no estoque: " 
                                + estoque.recuperarQuantidadeProdutosCadastrados());
                    } else System.out.println("\nNenhum prooduto no estoque");
                    break;
                
                case 7:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nValor total das mercadorias cadastradas no estoque: " 
                                + estoque.valorTotalProdutos());
                    } else System.out.println("\nNenhum prooduto no estoque");
                    break;
                
                case 8:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nProduto mais antigo no estoque: " 
                                + estoque.recuperarProdutoMaisAntigo());
                    } else System.out.println("\nNenhum prooduto no estoque");
                    break;
                
                case 9:
                    if (estoque.recuperarQuantidadeProdutosCadastrados() > 0) {
                        System.out.println("\nOs produtos vencidos do estoque com base na data atual: " +
                                estoque.recuperarProdutosVencidos());
                    } else System.out.println("\nNenhum prooduto no estoque");
                    break;
                
                case 0:
                    exibirMensagemSaidaSistema();
                    System.exit(opcaoMenuEstoque);
                default:
                    System.out.println("\nA opção escolhida não corresponde a nenhuma ação!");
            }
        }
    }
    
    private void entradasCadastroAtualizacaoAlimento(){
        
    }
    
    private void exibirMenuEstoque(){
        System.out.println("\n--------------------------------");
        System.out.println("MENU");
        System.out.println("--------------------------------"); 
        System.out.println("Escolha uma opção para a ação desejada.");
        System.out.println(" 1 - Cadastrar um novo produto no estoque");
        if (estoque.recuperarQuantidadeProdutosCadastrados() > 0){
            System.out.println(" 2 - Excluir um produto no estoque");
            System.out.println(" 3 - Atualizar um produto no estoque");
            System.out.println(" 4 - Buscar um produto do estoque");
            System.out.println(" 5 - Listar todos produtos do estoque");
            System.out.println(" 6 - Obter a quantidade de produtos cadastrados no estoque");
            System.out.println(" 7 - Obter o valor total das mercadorias cadastradas no estoque");
            System.out.println(" 8 - Obter o produto mais antigo no estoque");
            System.out.println(" 9 - Obter os produtos vencidos do estoque com base na data atual");        
        }
        System.out.println(" 0 - => Sair");        
    }

    private void exibirOpcaoCadastroMercadinho() {
        System.out.println("\n# Agora vamos cadastrar o mercadinho.");

        System.out.println("\n--------------------------------");
        System.out.println("CADASTRO DO MERCADINHO");
        System.out.println("--------------------------------"); 
        System.out.print("Informe o nome fantasia do mercadinho: ");
        String nomeMercadinho = scanner.nextLine();

        this.mercadinho.setNome(nomeMercadinho);
        this.mercadinho.setProprietario(proprietario);

        System.out.println("--------------------------------");
        System.out.println("Mercadinho Cadastrado");
        System.out.println("--------------------------------");        
    }

    private void exibirOpcaCadastroProprietario() {
        System.out.println("\n--------------------------------");
        System.out.println("CADASTRO DE PROPRIETÁRIO");
        System.out.println("--------------------------------"); 
        System.out.print("Informe o nome completo do proprietário: ");
        String nomeProprietario = scanner.nextLine();

        System.out.print("Informe a data de nascimento no formato (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimentoProprietario = LocalDate.parse(data, formatter);

        System.out.println("\nInforme o sexo do proprietário");
        System.out.println("M - MASCULINO / F - FEMININO");
        System.out.print("Opção: ");
        String sexoProprietario = scanner.nextLine();
        if (sexoProprietario.toUpperCase().trim().equalsIgnoreCase("M")) {
            this.proprietario.setSexo(Sexo.MASCULINO);
        } else if (sexoProprietario.toUpperCase().trim().equalsIgnoreCase("F")){
            this.proprietario.setSexo(Sexo.FEMININO);
        }

        System.out.println("--------------------------------");
        System.out.println("Proprietário Cadastrado");
        System.out.println("--------------------------------");

        this.proprietario.setNome(nomeProprietario);
        this.proprietario.setNascimento(nascimentoProprietario);
    }

    private void exibirMensagensBoasVindasSistema() {
        System.out.println("------------------------------------------");
        System.out.println("Sistema de Gerenciamento de Mercadinhos");
        System.out.println("------------------------------------------");
        System.out.println("# Olá, bem vindo!");
        System.out.println("# Vamos dar inicio ao cadastro no sistema?");
        System.out.println("# Vamos começar pelo Proprietário!");
    }

    private void exibirMensagemSaidaSistema() {
        System.out.println("\n--------------------------------");
        System.out.println("# Você saiu do Sistema!");
        System.out.println("# Obrigado pela atenção");
        System.out.println("--------------------------------\n");
    }

    public void exibirDetalhesMercadinho(Mercadinho mercadinho) {
        System.out.println("\n--------------------------------");
        System.out.println("INFORMAÇÕES DO MERCADINHO");
        System.out.println("--------------------------------"); 
        System.out.println("- Mercadinho: " + mercadinho.getNome());
        System.out.println("- Detalhes do Proprietário");
        System.out.println("  -Nome: " + mercadinho.getProprietario().getNome());
        System.out.println("  -Sexo: " + mercadinho.getProprietario().getSexo());
        System.out.println("  -Nascimento: " + mercadinho.getProprietario().getNascimento() + "\n");
    }
    
}
