import java.net.*;
import java.io.*;

/**
 * Servidor TCP que recebe dois objetos serializados
 */
public class Servidor {

    public static void main(String args[]) {
        Musica m1, m2;
        ServerSocket serverSocket;
        Socket clientSocket;

        ObjectInputStream objIn;

        try {
            System.out.println("Mapeando porta ...");
            serverSocket = new ServerSocket(6666);

            System.out.println("Servidor aguardando conexoes ...");
            clientSocket = serverSocket.accept();

            System.out.println("Criando objetos de leitura/escrita ...");
            objIn = new ObjectInputStream(clientSocket.getInputStream());

            System.out.println("Aguardando objetos serializados ...");
            m1 = (Musica) objIn.readObject();
            m2 = (Musica) objIn.readObject();

            System.out.println("\nObjetos Recebidos\n");
            System.out.println("\nMusica 1: " + "\n nome: " + m1.getNome() + "\n album: " + m1.getAlbum() + "\n faixa: "
                    + m1.getTrack() + "\n data: " + m1.getData());

            System.out.println("\nMusica 2: " + "\n nome: " + m2.getNome() + "\n album: " + m2.getAlbum() + "\n faixa: "
                    + m2.getTrack() + "\n data: " + m2.getData());

            System.out.println("\nSistema finalizado!");

        } catch (Exception e) {
            System.out.println(e);
        } // catch
    } // main

}
