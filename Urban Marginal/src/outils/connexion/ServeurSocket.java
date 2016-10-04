package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket extends Thread {
	private Object leRecepteur;
	private ServerSocket serverSocket;
	
	private ServeurSocket(Object leRecepteur, int port) { //constructeur
		this.leRecepteur=leRecepteur; //valorisation de la propri�t� leRecepteur
		try {
			serverSocket=new ServerSocket(port); //40=new Int
		} catch (IOException e) { // si le try �choue
			System.out.println("erreur grave cr�ation socket serveur :" +e);
			System.exit(0);
		}
		start();
	}
	public void run(){
		Socket socket;
		while (true){
			try {
				System.out.println("le serveur attend...");
				socket=serverSocket.accept();
				System.out.println("un client s'est connect�");
			} catch (IOException e) {
				System.out.println("erreur :" +e);
				System.exit(0);
			}
		}
	}
	
	
}
//dfhth///wdrgwdgr