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
	Connection(Socket socket, Object leRecepteur) { // constructeur de la classe Connection
		this.leRecepteur = leRecepteur; // valorisation de la propriété leRecepteur
		try {
			out = new ObjectOutputStream(socket.getOutputStream()); // création du canal de sortie
		} catch (IOException e) {
			System.out.println("erreur création canal de sortie :" +e); //en cas d'échec de la création du canal
			System.exit(0); // un message d'erreur s'affiche et la fenêtre se ferme
		}
		
		try {
			in = new ObjectInputStream(socket.getInputStream()); // création du canal d'entrée
		} catch (IOException e) {
			System.out.println("erreur création canal d'entrée :" +e);
			System.exit(0);
		}
	    
		start();
	}
	
	/**
	 * Méthode run
	 */
	public void run() {
		boolean inOk = true ;
		Object reception ;
		while (inOk == true) {
			try {
				reception = in.readObject() ;
				// 2 catch car 2 erreurs possibles
			} catch (ClassNotFoundException e) { // type de classe non trouvé
				System.out.println("Erreur de classe: " +e);
				System.exit(0);
			} catch (IOException e) { // erreur d'entrée/sortie
				inOk = false ;
				JOptionPane.showMessageDialog(null, "L'ordinateur distant s'est déconnecté"); // messageBox
				
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