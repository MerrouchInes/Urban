package vue;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame implements Global {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private Cursor cursorDefault = new Cursor(DEFAULT_CURSOR) ; //Instantiation de la classe "Cursor" : Curseur par défaut
	private Cursor cursorHand = new Cursor(HAND_CURSOR) ; //Curseur "main"
	private int numPerso ;
	private JLabel lblPersonnage ;
	
	/**
	 * Défilement des personnages
	 */
	
	// ------------- Défilement vers l'arrière
	private void lblPrecedent_clic() {
		this.numPerso = (this.numPerso + NBPERSOS + 1) % NBPERSOS + 1 ;
		affichePerso() ;		
	}
	
	// ------------- Défilement vers l'avant
	private void lblSuivant_clic(){
		this.numPerso = this.numPerso % NBPERSOS + 1 ;
		affichePerso() ;
	}
	
	/**
	 * Event "clic" Bouton GO
	 */
	
	private void lblGo_clic() {
		if (txtPseudo.getText().equals("")) { // Test sur le contenu de txtPseudo	
			JOptionPane.showMessageDialog(null, "Le pseudo est obligatoire "); // Si pas de pseudo
		}
		else { // Si pseudo renseigné
			
		}
		
	}
	
	
	/**
	 * Affichage des personnages dans le menu "Choice"
	 */
	
	private void affichePerso() {
		
		lblPersonnage.setIcon(new ImageIcon(PERSO + numPerso + MARCHE + "1d" + DROITE + EXTIMAGE));
	}
	
	
	/**
	 * Création des méthodes qui seront utilisées pour changer la forme des curseurs dans la fenêtre Choice
	 */
	
	
	// ------------- Souris normale
	
	private void souris_normale(){
		contentPane.setCursor(cursorDefault);
		
	}
	
	
	// ------------- Souris "doigt"
	
	private void souris_doigt(){
		contentPane.setCursor(cursorHand);
	}
	
	/**
	 * Create the frame.
	 * @param controle 
	 */
	
	public ChoixJoueur(Controle controle) {
		setTitle("Choice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon image;
		
		/**
		 * Flèche "Précédent"
		 */
				
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic() ;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt() ;
			}
			public void mouseExited(MouseEvent e) {
				souris_normale() ;
			}
		});

		/**
		 * Flèche "Suivant"
		 */
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt() ;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale() ;
			}
		});
		
		
		/**
		 * Events Bouton "GO"
		 */
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			
			/**
			 * Création de l'événement ─ le curseur passe en "doigt" lorqu'on survole le bouton
			 */
			
			@Override
			public void mouseEntered(MouseEvent arg0) { 
				souris_doigt() ;
			}
			
			/**
			 * Création de l'événement ─ le curseur est normal en-dehors du bouton
			 */
			
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale() ;
			}
		});
		
		
		/**
		 * Zone de texte Pseudo
		 */
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(146, 244, 114, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		
		lblGo.setBounds(292, 191, 98, 73);
		contentPane.add(lblGo);

		
		lblSuivant.setBounds(281, 130, 53, 50);
		contentPane.add(lblSuivant);
		
		lblPrecedent.setBounds(53, 130, 53, 50);
		contentPane.add(lblPrecedent);
		
		/**
		 * Zone "Personnage"
		 */
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(111, 99, 181, 142);
		contentPane.add(lblPersonnage);
		
		/**
		 * Image de fond de la fenêtre
		 */
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		
		lblFond.setIcon(new ImageIcon(FONDCHOIX));
		contentPane.add(lblFond);
		
		txtPseudo.requestFocus(); // Curseur dirigé vers txtPseudo
		numPerso = 1 ;
		
		affichePerso() ;
		
	}
} 
