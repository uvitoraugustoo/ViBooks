

package com.vitoraugusto.vibooks.model;

public class Livro {
    private String titulo;
    private String autor;
    private String resumo;
    private String imagemUri;

    public Livro(String titulo, String autor, String resumo, String imagemUri) {
        this.titulo = titulo;
        this.autor = autor;
        this.resumo = resumo;
        this.imagemUri = imagemUri;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getResumo() { return resumo; }
    public String getImagemUri() { return imagemUri; }
}
