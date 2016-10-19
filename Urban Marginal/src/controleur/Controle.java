package controleur;

import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu; //importation de la classe -> package différent
import javax.swing.JFrame; //cf. Evenements provenant de la vue

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;

public class Controle implements Global {
	
	private int res ;
	
	private Jeu leJeu ;
	
	private Arene frmArene ;
	
	private ChoixJoueur frmChoixJoueur ;
	
	private Connection connection ;
	
	private EntreeJeu frmEntreeJeu;
	
	public static void main(String[] args) {
		new Controle();
	}	
	
	
	/**
	 * Constructeur de la classe Controle
	 */
	
	public Controle(){ 
			
		this.frmEntreeJeu = new EntreeJeu(this); //Cree la frame
		frmEntreeJeu.setVisible(true); //Rend visible la frame

	}
		
	public void setConnection(Connection connexion) {
		this.connection = connexion ;
	}
	
	public void receptionInfo(Connection connection, Object info) {
		leJeu.reception(connection, info);
	}
		
	/**
	 *  ---------------- Evenements provenant de la vue ----------------
	 */
	

	public void evenementVue(Object uneFrame, Object info) {
		// --------- evenementEntreeJeu ---------
		if (uneFrame instanceof EntreeJeu) {
			evenementEntreeJeu(info);
		}
		// --------- evenementChoixJoueur ---------
		if (uneFrame instanceof ChoixJoueur) {
			evenementChoixJoueur(info);
		}
			
	}
	
	/**
	 * Méthode evenementChoixJoueur
	 */
	private void evenementChoixJoueur (Object info) {
		((JeuClient)leJeu).envoi(info) ; // Transtypage de l'objet "leJeu" (Jeu -> JeuClient)
		frmChoixJoueur.dispose() ;
		frmArene.setVisible(true) ;
	}
	
	
	/**
	 * Méthode evenementEntreeJeu
	 */
	private void evenementEntreeJeu(Object info) {
		if ((String) info == "serveur") {
			new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this) ;
			frmEntreeJeu.dispose();
			frmArene = new Arene();
			frmArene.setVisible(true);
		} else { 
			(new ClientSocket ((String) info, PORT, this)).getConnexionOk();
			
				leJeu = new JeuClient(this) ; // Instanciation de ChoixJoueur
				leJeu.setConnection(connection);
				
				frmArene = new Arene();
				frmEntreeJeu.dispose();								
				frmChoixJoueur = new ChoixJoueur(this) ; // Instanciation de ChoixJoueur			
				frmChoixJoueur.setVisible(true) ;
			}
			
	}
}