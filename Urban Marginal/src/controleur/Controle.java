package controleur;

import vue.EntreeJeu; //importation de la classe -> package différent
import javax.swing.JFrame; //cf. Evenements provenant de la vue

import outils.connexion.ClientSocket;
import outils.connexion.ServeurSocket;

public class Controle {
	
	private int res ;

	public static void main(String[] args) {
		new Controle();
	}
	
	private EntreeJeu frmEntreeJeu;
		
		public Controle(){ //Constructeur
			
		this.frmEntreeJeu = new EntreeJeu(this); //Cree la frame
		frmEntreeJeu.setVisible(true); //Rend visible la frame

		}
		
	/* ------------ Evenements provenant de la vue ------------ */
	public void evenementVue(Object uneFrame, Object info) {
		if (uneFrame instanceof EntreeJeu) {
			evenementEntreeJeu(info);
		}
			
	}

	private void evenementEntreeJeu(Object info) {
		if ((String) info == "serveur") {
			new ServeurSocket(this,6666);
		}
		else { 
			ClientSocket clientSocket ;
			clientSocket = new ClientSocket ((String) info, 6666, this);
			clientSocket.isConnexionOk();
	}
	}


}