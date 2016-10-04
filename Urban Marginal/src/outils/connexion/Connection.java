package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Connection extends Thread {
	private Object leRecepteur;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Connection(Socket socket, Object leRecepteur) {
		this.leRecepteur=leRecepteur;
		try {
			out=new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("erreur création canal de sortie :" +e);
			System.exit(0);
		}
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("erreur création canal d'entrée :" +e);
			System.exit(0);
		}
	    
		start();
	}
}
//dwfhwd///wdrgwdgr