package br.com.poo.biblioteca.itens;

import br.com.poo.biblioteca.emprestimo.Emprestimo;

public class Livro extends Item implements Emprestimo {

    private String genero;
    public Livro(String titulo, String autor, int anoDePublicacao, int numeroDeCopias, String genero) {
        super(titulo, autor, anoDePublicacao, numeroDeCopias);
        this.genero = genero;
    }
    @Override
    public String obterDados() {
        return "Título: " + super.titulo +
                " / Autor: " + super.autor +
                " / Ano de publicação: " + super.anoDePublicacao +
                " / Número de cópias disponíveis: " + super.numeroDeCopias +
                " / Gênero: " + this.genero +
                " / Tipo: " + this.obterTipo();
    }

    @Override
    public String obterTipo() {
        return "Livro";
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public boolean emprestar() {
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
