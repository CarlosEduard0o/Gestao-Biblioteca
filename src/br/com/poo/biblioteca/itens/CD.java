package br.com.poo.biblioteca.itens;

import br.com.poo.biblioteca.emprestimo.Emprestimo;
import br.com.poo.biblioteca.interfaceusuario.InterfaceUsuario;

public class CD extends Item implements Emprestimo {
    private int tempoDuracao;
    public CD(String titulo, String autor, int anoDePublicacao, int numeroDeCopias, int tempoDuracao) {
        super(titulo, autor, anoDePublicacao, numeroDeCopias);
        this.tempoDuracao = tempoDuracao;
    }

    @Override
    public String obterDados() {
        return "Título: " + super.titulo +
                " / Autor: " + super.autor +
                " / Ano de publicação: " + super.anoDePublicacao +
                " / Número de cópias disponíveis: " + super.numeroDeCopias +
                " / Tempo de duração: " + this.tempoDuracao +
                " / Tipo: " + this.obterTipo();
    }

    @Override
    public String obterTipo() {
        return "CD";
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public boolean emprestar() {
        InterfaceUsuario ui = new InterfaceUsuario();
        if (this.numeroDeCopias > 0){
            this.numeroDeCopias -= 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void devolver() {
        this.numeroDeCopias += 1;
    }
}
