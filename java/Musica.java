
/*
 * Pessoa.java
 *
 */

import java.io.Serializable;
import java.util.Date;

public class Musica implements Serializable {

    private String nome;
    private String album;
    private int trackNro;
    private Date data;

    /** Construtor */
    public Musica(String n, String a, int t, Date d) {
        nome = n;
        album = a;
        trackNro = t;
        data = d;
    }

    public String getNome() {
        return this.nome;
    }

    public String getAlbum() {
        return this.album;
    }

    public Date getData() {
        return this.data;
    }

    public int getTrack() {
        return this.trackNro;
    }

} // class
