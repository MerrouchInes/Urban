package controleur;

public interface Global {
	public static final Integer PORT = 6666 ; 
	public static final String SEPARATOR = "//" ;
	public static final String CHEMIN = "media" + SEPARATOR ;
	public static final String CHEMINFONDS = CHEMIN + "fonds" + SEPARATOR ;
	public static final String FONDCHOIX = CHEMINFONDS + "fondchoix.jpg" ;
	
	/**
	 * PERSONNAGES
	 */
	
	public static final Integer GAUCHE = 0 ;
	public static final Integer DROITE = 1 ;
	public static final String CHEMINPERSOS = CHEMIN + "personnages" + SEPARATOR ;
	public static final String PERSO = CHEMINPERSOS + "perso" ;
	public static final String EXTIMAGE = ".gif" ;
	public static final String MARCHE = "marche" ;
	public static final String BLESSE = "touche" ;
	public static final String MORT = "mort" ;
	public static final Integer NBPERSOS = 3 ; // Nombre de personnages
	public static final int H_PERSO = 44 ; // Taille image perso (hauteur)
	public static final int L_PERSO = 39 ; // Taille image perso (largeur)
	
	public static final String SEPARE = "~" ;
	public static final int PSEUDO = 0 ;
	
	/**
	 * ARENE
	 */
	
	public static final int H_ARENE = 600 ;
	public static final int L_ARENE = 800 ;
	public static final int H_CHAT = 200 ;
	public static final int H_SAISIE = 20 ;
	public static final int MARGE = 5 ; // Elle va servir pour les écarts entre différents objets
	public static final String FONDARENE = CHEMINFONDS + "fondarene.jpg" ;
	
	/**
	 * MURS
	 */
	
	public static final int NBMURS = 20 ;
	public static final String CHEMINMURS = CHEMIN + "murs" + SEPARATOR ;
	public static final String MUR = CHEMINMURS + "mur.gif" ; // Image du mur
	public static final int H_MUR = 35 ; // Hauteur de l'image
	public static final int L_MUR = 34 ; // Largeur de l'image
}
//
