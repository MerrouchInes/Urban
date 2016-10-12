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
	
	private void lblSuivant_clic(){
		
	}
	
	private void lblPrecedent_clic() {
		
	}
	
	private void lblGo_clic() {
		
	}
	
	private void affichePerso() {
		lblPersonnage.setIcon(new ImageIcon(PERSO)); // pê à modifier
		contentPane.add(lblPersonnage);
	}
	
	
	/**
	 * Création des méthodes qui seront utilisées pour changer la forme des curseurs dans la fenêtre Choice
	 */
	
	private void souris_normale(){
		contentPane.setCursor(cursorDefault);
		
	}
	
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
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		
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
		 * Bouton "GO"
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
		
		lblFond.setIcon(new ImageIcon(FONDCHOIX));
		contentPane.add(lblFond);
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(111, 99, 181, 142);
		contentPane.add(lblPersonnage);
		
		txtPseudo.requestFocus();
		numPerso = 1 ;
	}
} 
