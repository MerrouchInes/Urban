package controleur;

import vue.EntreeJeu; //importation de la classe -> package différent
import javax.swing.JFrame; //cf. Evenements provenant de la vue

import outils.connexion.ServeurSocket;

public class Controle {
	
	private int res ;

	public static void main(String[] args) {
		new Controle();
	}
	
	private EntreeJeu frmEntreeJeu;
		
		public Controle(){ //Constructeur
			
		frmEntreeJeu = new EntreeJeu(); //Cree la frame
		frmEntreeJeu.setVisible(true); //Rend visible la frame

		}
		
	/* ------------ Evenements provenant de la vue ------------ */
	public void evenementVue(JFrame uneFrame, Object info) {
		if (uneFrame instanceof EntreeJeu) {
			evenementEntreeJeu(info);
		}
			
	}

	private void evenementEntreeJeu(Object info) {
		if ((String) info == "serveur") {
			new ServeurSocket(this,6666);
		}
	}
	
	
	/* ------------ Evenements provenant du modele ------------ */
	
	
}


