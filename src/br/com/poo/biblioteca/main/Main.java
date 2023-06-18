package br.com.poo.biblioteca.main;


import br.com.poo.biblioteca.biblioteca.Biblioteca;
import br.com.poo.biblioteca.emprestimo.Emprestimo;
import br.com.poo.biblioteca.interfaceusuario.InterfaceUsuario;
import br.com.poo.biblioteca.itens.CD;
import br.com.poo.biblioteca.itens.Livro;
import br.com.poo.biblioteca.itens.Revista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InterfaceUsuario ui = new InterfaceUsuario();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Biblioteca biblioteca = new Biblioteca();


        int opcao = -1;
        do {
            ui.mostrarNaTela("" +
                    "\nControle da biblioteca" +
                    "\n=== Opções ===" +
                    "\n1- Cadastrar Livros" +
                    "\n2- Cadastrar Revistas" +
                    "\n3- Cadastrar CDs" +
                    "\n4- Emprestar" +
                    "\n5- Devolver" +
                    "\n6- Listar Itens"+
                    "\n0- Sair do Sistema");
            opcao = ui.lerDados().nextInt();

 //           Livro livro1 = new Livro("Alice no país das marabilhas", "Lewis Carroll", 1895, 3, "Fantasia");
            switch (opcao) {
                case 1:
                    ui.mostrarNaTela("Título da obra: ");
                    String tituloObra = reader.readLine();
                    ui.mostrarNaTela("Autor da obra: ");
                    String autorObra = reader.readLine();

                    ui.mostrarNaTela("Ano de publicação: ");
                    int anoPublicacao = ui.lerDados().nextInt();
                    ui.mostrarNaTela("Número de cópias: ");
                    int numeroCopias = ui.lerDados().nextInt();

                    ui.mostrarNaTela("Gênero da obra: ");
                    String generoObra = reader.readLine();

                    Livro livro = new Livro(tituloObra, autorObra, anoPublicacao, numeroCopias, generoObra);
                    biblioteca.cadastrarItem(livro);
                    break;
                case 2:
                    ui.mostrarNaTela("Título da revista: ");
                    String tituloRevista = reader.readLine();
                    ui.mostrarNaTela("Autor da revista: ");
                    String autorRevista = reader.readLine();

                    ui.mostrarNaTela("Ano de publicação: ");
                    int anoPublicacaoRevista = ui.lerDados().nextInt();
                    ui.mostrarNaTela("Número de cópias: ");
                    int numeroCopiasRevista = ui.lerDados().nextInt();

                    ui.mostrarNaTela("Número da edição: ");
                    int numeroEdicao = ui.lerDados().nextInt();

                    Revista revista = new Revista(tituloRevista,autorRevista, anoPublicacaoRevista, numeroCopiasRevista, numeroEdicao );
                    biblioteca.cadastrarItem(revista);
                    break;
                case 3:
                    ui.mostrarNaTela("Título do CD: ");
                    String tituloCD = reader.readLine();
                    ui.mostrarNaTela("Autor do CD: ");
                    String autorCD = reader.readLine();

                    ui.mostrarNaTela("Ano de publicação: ");
                    int anoPublicacaoCD = ui.lerDados().nextInt();
                    ui.mostrarNaTela("Número de cópias: ");
                    int numeroCopiasCD = ui.lerDados().nextInt();

                    ui.mostrarNaTela("Tempo de duração: ");
                    int tempoDuracao = ui.lerDados().nextInt();

                    CD cd = new CD(tituloCD, autorCD, anoPublicacaoCD, numeroCopiasCD, tempoDuracao);
                    biblioteca.cadastrarItem(cd);
                    break;
                case 4:
                    ui.mostrarNaTela("Digite o título da obra que deseja retirar: ");
                    String tituloObraASerEmprestada = reader.readLine();

                    Emprestimo BookOrCd = (Emprestimo) biblioteca.verificarItemParaEmprestar(tituloObraASerEmprestada);
                    if (BookOrCd != null)
                        biblioteca.emprestarItem(BookOrCd);
                    break;
                case 5:
                    ui.mostrarNaTela("Digite o título da obra que deseja devolver: ");
                    String tituloObraASerDevolvida = reader.readLine();

                    Emprestimo BookOrCdDevolvido = (Emprestimo) biblioteca.verificarItemParaEmprestar(tituloObraASerDevolvida);
                    if (BookOrCdDevolvido != null)
                        biblioteca.devolverItem(BookOrCdDevolvido);
                    break;
                case 6:
                    biblioteca.listarItens();
                    break;
                case 0:
                    ui.mostrarNaTela("Saindo ..");
                    break;
                default:
                    ui.mostrarNaTela("Opção Inválida");
            }
        } while (opcao != 0);
    }
}
