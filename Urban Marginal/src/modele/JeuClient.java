package modele;

import controleur.Controle;
import outils.connexion.Connection;



public class JeuClient extends Jeu {
	
	public void envoi(Object info) {
		super.envoi(this.connection, info);
	}
	
	public JeuClient(Controle controle) {		
		super.controle = controle ;
	}
	
	private Connection connection ;



	@Override // Repérage des méthodes abstraites 
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