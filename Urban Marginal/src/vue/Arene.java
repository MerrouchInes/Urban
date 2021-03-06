package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import controleur.Global; ;

public class Arene extends JFrame implements Global {

	private JPanel contentPane;
	private JTextField txtSaisie;

	/**
	 * Create the frame.
	 */
	
	public Arene() {
		setTitle("Arena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, L_ARENE + 3*MARGE, H_ARENE + H_CHAT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/**
		 * jpnJeu
		 */
		JPanel jpnJeu = new JPanel();
		jpnJeu.setBounds(0, 0, L_ARENE, H_ARENE);
		contentPane.add(jpnJeu);
		jpnJeu.setLayout(null);
		jpnJeu.setOpaque(false);
		
		/**
		 * jpnMurs
		 */		
		JPanel jpnMurs = new JPanel();
		jpnMurs.setBounds(0, 0, L_ARENE, H_ARENE);
		contentPane.add(jpnMurs);
		jpnMurs.setLayout(null);
		jpnMurs.setOpaque(false);
		
		/**
		 * lblFond
		 */
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, L_ARENE, H_ARENE);
		contentPane.add(lblFond);
		
		lblFond.setIcon(new ImageIcon(FONDARENE));
		
		/**
		 * txtSaisie
		 */
		txtSaisie = new JTextField();
		txtSaisie.setBounds(0, H_ARENE, L_ARENE, H_SAISIE);
		contentPane.add(txtSaisie);
		txtSaisie.setColumns(10);
		
		/**
		 * jspChat
		 */
		JScrollPane jspChat = new JScrollPane();
		jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) ;
		jspChat.setBounds(0, H_ARENE + H_SAISIE, L_ARENE, H_CHAT - H_SAISIE - 7*MARGE);
		contentPane.add(jspChat);
		
		
		/**
		 * txtChat
		 */
		JTextArea txtChat = new JTextArea();
		jspChat.setViewportView(txtChat);
	}
	
}