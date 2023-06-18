package br.com.poo.biblioteca.biblioteca;

import br.com.poo.biblioteca.emprestimo.Emprestimo;
import br.com.poo.biblioteca.interfaceusuario.InterfaceUsuario;
import br.com.poo.biblioteca.itens.Item;

import java.util.ArrayList;

public class Biblioteca {
    public static int quantidadeItens = 0;
    private ArrayList<Item> itens;
    public Biblioteca(){
        this.itens = new ArrayList();
    }
    public void cadastrarItem(Item item){
        itens.add(item);
        quantidadeItens += 1;
    }
    public void listarItens(){
        InterfaceUsuario ui = new InterfaceUsuario();
        for(Item item : this.itens){
            ui.mostrarNaTela(item.obterDados());
        }
    }
    public Item verificarItemParaEmprestar(String tituloDaObraASerEmprestada){
        InterfaceUsuario ui = new InterfaceUsuario();
        if (quantidadeItens > 0){
            for(Item item : this.itens) {
                if(item.getTitulo().equals(tituloDaObraASerEmprestada)) {
                    if(item.obterTipo().equals("Revista")) {
                        ui.mostrarNaTela("Não é possível emprestar revista");
                        return null;
                    } else {
                        return item;
                    }
                }
            }
            ui.mostrarNaTela("Titulo não encontrado!");
        } else{
        ui.mostrarNaTela("Biblioteca vazia!");
        }
        return null;
    }

    public Item verificarItemParaDevolver(String tituloDaObraASerDevolvido){
        InterfaceUsuario ui = new InterfaceUsuario();
            for(Item item : this.itens) {
                if(item.getTitulo().equals(tituloDaObraASerDevolvido)) {
                    if(item.obterTipo().equals("Revista")) {
                        ui.mostrarNaTela("Não é possível devolver revista");
                        return null;
                    } else {
                        return item;
                    }
                }
            }
            ui.mostrarNaTela("Titulo não encontrado!");
        return null;
    }
    public void emprestarItem(Emprestimo item){
        InterfaceUsuario ui = new InterfaceUsuario();
        if (item != null)
           // item.emprestar();
            if (item.emprestar()) {
                ui.mostrarNaTela("Empréstimo realizado!");
            } else {
                ui.mostrarNaTela("Cópia indisponível!");
            }
    }
    public void devolverItem(Emprestimo item){
        InterfaceUsuario ui = new InterfaceUsuario();
        if (item != null) {
            item.devolver();
            ui.mostrarNaTela("Item devolvido!");
        }
    }
}
