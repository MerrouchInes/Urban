package outils.connexion;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientSocket {
	private boolean connexionOk = false ;
	public ClientSocket(String ip, int port, Object leRecepteur){ // constructeur de la classe ClientSocket
		Socket socket ;
		
		try {
			socket = new Socket(ip, port) ;
			System.out.println("La connexion au serveur a réussi") ;
			connexionOk = true ;
			Connection connect = new Connection(socket, leRecepteur);
		} catch (UnknownHostException e) { // serveur indisponible
			JOptionPane.showMessageDialog(null, "ERREUR - Le serveur est indisponible " +e);
		} catch (IOException e) { // erreur entrée/sortie EX: IP incorrecte
			JOptionPane.showMessageDialog(null, "ERREUR - Problème d'entrée/sortie " +e);
		}
	}
	/**
	 * @return the connexionOk
	 */
	public boolean isConnexionOk() { // is... et pas get... car connexionOk est un booléen
		return connexionOk;
	}
	

}