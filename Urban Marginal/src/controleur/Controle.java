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

public class Controle {
	
	private int res ;
	
	private Jeu leJeu ;
	
	private Arene frmArene ;
	
	private ChoixJoueur frmChoixJoueur ;
	
	private Connection connection ;

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
			new ServeurSocket(this, 6666);
			leJeu = new JeuServeur(this) ;
			frmEntreeJeu.dispose();
			frmArene = new Arene();
			frmArene.setVisible(true);
		}
		else { 
			(new ClientSocket ((String) info, 6666, this)).getConnexionOk();
			
				leJeu = new JeuClient(this) ;
				
				frmArene = new Arene();
				frmEntreeJeu.dispose();								
				frmChoixJoueur = new ChoixJoueur(this) ;				
				frmChoixJoueur.setVisible(true) ;
			}
			
		}
	}

//
