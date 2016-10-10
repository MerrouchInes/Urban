package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	
	private void lblSuivant_clic(){
		
	}
	
	private void lblPrecedent_clic() {
		
	}
	
	private void lblGo_clic() {
		
	}
	
	
	private void souris_normale(){
		contentPane.setCursor(); // A CONTINUER
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
		
				
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic() ;
			}
		});

		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
		});
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
		});
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(146, 244, 114, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		
		lblGo.setBounds(292, 191, 98, 73);
		contentPane.add(lblGo);

		
		lblSuivant.setBounds(281, 130, 53, 75);
		contentPane.add(lblSuivant);
		
		lblPrecedent.setBounds(53, 130, 53, 75);
		contentPane.add(lblPrecedent);
		
		lblFond.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Versions Urban\\sources TP\\media\\fonds\\fondchoix.jpg"));
		contentPane.add(lblFond);
		
		JLabel lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(111, 99, 181, 142);
		contentPane.add(lblPersonnage);
	}
} 
