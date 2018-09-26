package com.nfaustino.app;

/*
 * Pessoa.java
 *
 */

import java.io.Serializable;

public class Musica implements Serializable {

    private String nome;
    private String album;
    private int trackNro;
    private Boolean onTheRadio;

    /** Construtor */
    public Musica(String n, String a, int t, Boolean o) {
        nome = n;
        album = a;
        trackNro = t;
        onTheRadio = o;
    }

    public String getNome() {
        return this.nome;
    }

    public String getAlbum() {
        return this.album;
    }

    public Boolean isOnTheRadio() {
        return this.onTheRadio;
    }

    public int getTrack() {
        return this.trackNro;
    }

} // class
