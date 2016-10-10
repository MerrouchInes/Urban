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
		
		JLabel lblLblfond = new JLabel("lblFond");
		lblLblfond.setBounds(0, 0, 400, 275);
		
		ImageIcon image;
		lblLblfond.setIcon(image = new ImageIcon("media/fonds/fondchoix.jpg"));
		contentPane.add(lblLblfond);
	}
} //
