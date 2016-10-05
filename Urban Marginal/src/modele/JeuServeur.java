package modele;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuServeur extends Jeu{
	
	public JeuServeur(Controle controle) {
		this.controle = super.controle ;
	}

	@Override
	public void setConnection(Connection connection) {
		
	}

	@Override
	public void reception(Connection connection, Object info) {
		
	}

	@Override
	public void deconnection(Connection connection) {
		
	}

}