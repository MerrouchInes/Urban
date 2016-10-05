package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("New label");
	private JTextField txtIp;
	
	private void btnStart_clic(){
		controle.evenementVue(this, "serveur");
	}
	private void btnConnect_clic() {
		controle.evenementVue(this, txtIp.getText()) ;
	}
	private Controle controle;

	/**
	 * Create the frame.
	 */
	public EntreeJeu(Controle controle) {
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Creation du bouton "Start"	
		 */
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() { //Clic souris -> action
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnStart_clic();
			}
			
			
		});
		btnStart.setBounds(323, 39, 89, 23);
		contentPane.add(btnStart);
		
	
		/**
		 * Création du bouton "Connect"
		 */
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(323, 151, 89, 23);
		contentPane.add(btnConnect);
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnConnect_clic();
			}
			
		});

		
		/**
		 * Création du bouton "Exit"
		 */
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(323, 197, 89, 23);
		contentPane.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnExit_clic();
			}
			private void btnExit_clic(){
				System.exit(0);
			}
		});
		
		//Nouveau serveur
		JLabel lblStartAServer = new JLabel("Start a server :");
		lblStartAServer.setBounds(86, 43, 163, 14);
		contentPane.add(lblStartAServer);
		
		//Serveur existant
		JLabel lblConnectAnExisting = new JLabel("Connect an existing server :");
		lblConnectAnExisting.setBounds(86, 108, 163, 14);
		contentPane.add(lblConnectAnExisting);
		
		//Entrer IP du serveur
		JLabel lblIpServer = new JLabel("IP Server");
		lblIpServer.setBounds(86, 155, 63, 14);
		contentPane.add(lblIpServer);
		label.setBounds(28, -31, 98, 31);
		contentPane.add(label);
		
		//127.0.0.1
		txtIp = new JTextField();
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(163, 152, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		this.controle = controle ;
	}
}