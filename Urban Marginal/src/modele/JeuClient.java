package modele;

import controleur.Controle;
import outils.connexion.Connection;



public class JeuClient extends Jeu {
	
	public void envoi(Object info) {
		super.envoi(connection, info);
	}
	
	public JeuClient(Controle controle) {
		this.controle = super.controle ;
	}
	
private Connection connection ;

	@Override // Rep�rage des m�thodes abstraites 
	public void setConnection(Connection connection) {
		this.connection = connection ;
	}

	@Override
	public void reception(Connection connection, Object info) {
		
	}

	@Override
	public void deconnection(Connection connection) {
		
	}

}