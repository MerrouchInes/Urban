package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket extends Thread {
	private Object leRecepteur;
	private ServerSocket serverSocket;
	
	public ServeurSocket(Object leRecepteur, int port) { // constructeur
		this.leRecepteur = leRecepteur; // valorisation de la propri�t� leRecepteur
		try {
			serverSocket = new ServerSocket(port); // 40=new Int
		} catch (IOException e) { // si le try �choue
			System.out.println("Erreur grave cr�ation socket serveur :" +e);
			System.exit(0);
		}
		start();
	}
	
	/**
	 * M�thode run
	 */
	
	public void run(){
		Socket socket;
		while (true){
			try {
				System.out.println("Le serveur attend...");
				socket = serverSocket.accept();				
				System.out.println("Un client s'est connect�");
				Connection connection ;
				connection = new Connection(socket, leRecepteur);
			} catch (IOException e) {
				System.out.println("Erreur :" +e);
				System.exit(0);
			}
		}
	}
	
	
}