package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import javax.swing.JLabel;

public class ChoixJoueur extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblFond = new JLabel("lblFond");
		lblFond.setBounds(0, 0, 400, 275);
		
		ImageIcon image;
		lblFond.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Versions Urban\\sources TP\\media\\fonds\\fondchoix.jpg"));
		contentPane.add(lblFond);
		
		JLabel lblPrecedent = new JLabel("lblPrecedent");
		lblPrecedent.setBounds(53, 130, 53, 75);
		contentPane.add(lblPrecedent);
	}
} 
