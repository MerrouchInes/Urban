package modele;

import controleur.Controle;
import outils.connexion.Connection;

public abstract class Jeu {
	protected Controle controle ;
	abstract public setConnection (Connection connection) ;
	abstract public reception(Connection connection, Object info) ;
	
	public void envoi(Connection connection, Object info) {
		connection.envoi(info);
	}
}
	


