package br.com.poo.biblioteca.itens;

public class Revista extends Item{
    private int numeroDaEdicao;
    public Revista(String titulo, String autor, int anoDePublicacao, int numeroDeCopias,int numeroDaEdicao) {
        super(titulo, autor, anoDePublicacao, numeroDeCopias);
        this.numeroDaEdicao = numeroDaEdicao;
    }

    @Override
    public String obterDados() {
        return "Título: " + super.titulo +
                " / Autor: " + super.autor +
                " / Ano de publicação: " + super.anoDePublicacao +
                " / Número de cópias disponíveis: " + super.numeroDeCopias +
                " / Número da edição: " + this.numeroDaEdicao +
                " / Tipo: " + this.obterTipo();
    }

    @Override
    public String obterTipo() {
        return "Revista";
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }
}
