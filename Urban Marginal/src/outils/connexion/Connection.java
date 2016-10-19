package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;


public class Connection extends Thread {
	private Object leRecepteur;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	/**
	 *  Constructeur de la classe Connection
	 */
	Connection(Socket socket, Object leRecepteur) { 
		this.leRecepteur = leRecepteur; // Valorisation de la propri�t� leRecepteur
		try {
			out = new ObjectOutputStream(socket.getOutputStream()); // Cr�ation du canal de sortie
		} catch (IOException e) {
			System.out.println("Erreur cr�ation canal de sortie :" +e); // En cas d'�chec de la cr�ation du canal
			System.exit(0); // Un message d'erreur s'affiche et la fen�tre se ferme
		}
		
		try {
			in = new ObjectInputStream(socket.getInputStream()); // cr�ation du canal d'entr�e
		} catch (IOException e) {
			System.out.println("Erreur cr�ation canal d'entr�e :" +e);
			System.exit(0);
		}
	    
		start();
	}
	
	/**
	 * M�thode run
	 */
	public void run() {
		boolean inOk = true ;
		Object reception ;
		while (inOk == true) {
			try {
				reception = in.readObject() ;
				// 2 catch car 2 erreurs possibles
			} catch (ClassNotFoundException e) { // Type de classe non trouv�
				System.out.println("Erreur de classe: " +e);
				System.exit(0);
			} catch (IOException e) { // Erreur d'entr�e/sortie
				inOk = false ;
				JOptionPane.showMessageDialog(null, "L'ordinateur distant s'est d�connect�"); // messageBox
				
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("Erreur fermeture canal :" +e1);
				}
			}
				
		}
		
	}
	
	public void envoi(Object unObjet){
		try {
			out.writeObject(unObjet);
			out.flush();
		} catch (IOException e) {
			System.out.println("Erreur canal de sortie: " +e);
		}
	}
		
}