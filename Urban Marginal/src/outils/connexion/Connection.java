package outils.connexion;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Connection extends Thread {
	private Object leRecepteur;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Connection(Socket socket, Object leRecepteur) {
		this.leRecepteur=leRecepteur;
	//	out = socket.getOutputStream();
	}
}
//dwfhwd///