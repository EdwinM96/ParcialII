package com.example.edwin.parcialii.modelo;

public class Noticia {
    private String noticia;
    private String titulo;
    private int foto;
    private String autor;

    public Noticia(String noticia, String titulo, int foto, String autor) {
        this.noticia = noticia;
        this.titulo = titulo;
        this.foto = foto;
        this.autor = autor;
    }

    public Noticia(String noticia, String titulo, int foto) {
        this.noticia = noticia;
        this.titulo = titulo;
        this.foto = foto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
}
