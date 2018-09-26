package com.nfaustino.app;

import java.net.*;

import com.nfaustino.app.proto.MusicProto;

import java.io.*;

/**
 * Servidor TCP que recebe dois objetos serializados
 */
public class Servidor {
	Musica m1;
	ServerSocket serverSocket;
	Socket clientSocket;
	String hostname;
	String port;

	ObjectInputStream objIn;
	DataOutputStream out;

	private void sendToPython() {
		MusicProto.Music mProto = MusicProto.Music.newBuilder()
			.setNome(m1.getNome())
			.setAlbum(m1.getAlbum())
			.setTrackNro(m1.getTrack())
			.setOnTheRadio(m1.isOnTheRadio())
			.build();
		
		System.out.println("Codificando objeto....\n\n");

		try {
			Socket pythonSocket = new Socket("127.0.0.1", 5555);
			out = new DataOutputStream(pythonSocket.getOutputStream());

			System.out.println(mProto.toByteArray().length);
			out.write(mProto.toByteArray().length);
			out.write(mProto.toByteArray());
			
		} catch (Exception e) {
			//TODO: handle exception
		}
	}

	private void execute() {

		try {
			System.out.println("Mapeando porta ...");
			serverSocket = new ServerSocket(6666);

			System.out.println("Servidor aguardando conexoes ...");
			clientSocket = serverSocket.accept();

			System.out.println("Criando objetos de leitura/escrita ...");
			objIn = new ObjectInputStream(clientSocket.getInputStream());

			System.out.println("Aguardando objetos serializados ...");
			m1 = (Musica) objIn.readObject();

			System.out.println("\nObjetos Recebidos\n");
			System.out.println("\nMusica 1: " + "\n nome: " + m1.getNome() + "\n album: " + m1.getAlbum() + "\n faixa: "
					+ m1.getTrack() + "\n data: " + m1.isOnTheRadio());

			sendToPython();
			System.out.println("\nSistema finalizado!");

		} catch (Exception e) {
			System.out.println(e);
		} // catch
	}

	public static void main(String args[]) {
		Servidor s = new Servidor();
		s.execute();
	} // main

}
