package modele;

import controleur.Controle;
import outils.connexion.Connection;

//private Connection connection ;
public class JeuClient extends Jeu {
	
	public JeuClient(Controle controle) {
		this.controle = super.controle ;
	}

	@Override // rep�rage des m�thodes abstraites 
	public void setConnection(Connection connection) {
		
	}

	@Override
	public void reception(Connection connection, Object info) {
		
	}

	@Override
	public void deconnection(Connection connection) {
		
	}

}