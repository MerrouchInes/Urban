package modele;

import java.io.Serializable;

import javax.swing.JLabel;

public class Label implements Serializable {
	
	private static int nbLabel ;
	
	private int numLabel ;
	private JLabel jLabel ;
	
	/**
	 * Constructeur de la classe Label
	 */
	private Label(int numLabel, JLabel jLabel) {
		this.numLabel = nbLabel ;
		this.jLabel = jLabel ;
	}
	
	
	/**
	 * Getter numLabel
	 */
	public int getNumLabel() {
		return numLabel;
	}
	
	
	/**
	 * Getter jLabel
	 */
	public JLabel getjLabel() {
		return jLabel;
	}


	/**
	 * Getter et Setter de nbLabel
	 */
	
	// ------- Getter -------
	public static int getNbLabel() {
		return nbLabel;
	}
	
	// ------- Setter -------
	public static void setNbLabel(int nbLabel) {
		Label.nbLabel = nbLabel;
	}
	
	
	
	
}