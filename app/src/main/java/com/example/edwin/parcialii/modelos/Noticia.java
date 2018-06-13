package com.example.edwin.parcialii.modelos;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Noticia implements Comparable<Noticia>, Serializable{
    private String ID;
    private String noticia;
    private String titulo;
    private int foto;
    private String juego;
    private String subtitulo;
    private Date fechaInit;
    private String autor;
    private String imgPortada;
    private String fechaInicial;

    public Noticia() {
    }

    public Noticia(String ID, String noticia, String titulo, int foto) {
        this.ID = ID;
        this.noticia = noticia;
        this.titulo = titulo;
        this.foto = foto;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getImgPortada() {
        return imgPortada;
    }

    public void setImgPortada(String imgPortada) {
        this.imgPortada = imgPortada;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public Date getFechaInit() {
        return fechaInit;
    }

    public void setFechaInit(Date fechaInit) {
        this.fechaInit = fechaInit;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int compareTo(@NonNull Noticia o) {
        return 0;
    }
}
