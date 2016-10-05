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
	public void run() {
		boolean inOk = true ;
		Object reception ;
		while (inOk = true) {
			try {
				reception = in.readObject() ;
				// 2 catch car 2 erreurs possibles
			} catch (ClassNotFoundException e) { // type de classe non trouvé
				System.out.println("erreur de classe: " +e);
				System.exit(0);
			} catch (IOException e) { // erreur d'entrée/sortie
				JOptionPane.showMessageDialog(null, "l'ordinateur distant s'est déconnecté"); // messageBox
				inOk = false ;
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("erreur fermeture canal :" +e1);
				}
			}
				
		}
		
	}
	
}