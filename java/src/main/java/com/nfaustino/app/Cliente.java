package com.nfaustino.app;

/*
 * Cliente.java
 */

import java.net.*;
import java.util.Date;
import java.io.*;

/**
 * 
 * @author rodrigo
 */
public class Cliente {

    public static void main(String args[]) {
        Musica a, b;
        Socket s;

        ObjectOutputStream objOut;

        try {
            System.out.println("Criando instancias da classe Musica ...\n");
            a = new Musica("rock1", "so rock", 10, true);
            b = new Musica("rock2", "so rock 2", 9, false);

            System.out.println("Conectando ao servidor ...\n");
            s = new Socket("localhost", 6666);

            System.out.println("Criando objetos de leitura/escrita ...\n");
            objOut = new ObjectOutputStream(s.getOutputStream());

            System.out.println("Enviando objetos serializados ...\n");
            objOut.writeObject(a);
            objOut.writeObject(b);
            objOut.flush();

            System.out.println("Finalizado.");

        } catch (Exception e) {
            System.out.println(e);
        } // catch
    } // main

}
