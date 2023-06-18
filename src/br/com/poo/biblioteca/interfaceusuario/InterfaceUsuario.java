package br.com.poo.biblioteca.interfaceusuario;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner ler;

    public InterfaceUsuario() {
        this.ler = new Scanner(System.in);
    }

    public Scanner lerDados() {
        return this.ler;
    }

    public void mostrarNaTela(String mensagem) {
        System.out.println(mensagem);
    }
}
