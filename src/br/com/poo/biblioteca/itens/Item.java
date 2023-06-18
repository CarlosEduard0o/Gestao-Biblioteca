package br.com.poo.biblioteca.itens;

public abstract class Item {
    protected String titulo;
    protected String autor;
    protected int anoDePublicacao;
    protected int numeroDeCopias;

    public Item(String titulo, String autor, int anoDePublicacao, int numeroDeCopias){
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDeCopias += numeroDeCopias;
    }
    public abstract String obterDados();
    public abstract String obterTipo();
    public abstract String getTitulo();
}
