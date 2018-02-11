package org.firstchampionship.equipe5910.robot2018;

public interface RobotMap 
{
	
	public interface Pince
	{
		public static final int PINCE_OUVERTE = 2;
		public static final int PINCE_FERMEE = 3;
	}
	
	public static final int BRAS_EXTENSION_MIN = 4;
	public static final int BRAS_EXTENSION_MAX  = 5;	
	
	public interface Roues
	{	
		public static final int ROUE_GAUCHE = 17;
		public static final int ROUE_DROITE = 18;
		public static final boolean INVERSION_ROUE_GAUCHE = false;
		public static final boolean INVERSION_ROUE_DROITE = true;		
		
		public static final int VITESSE_BASSE = 0;
		public static final int VITESSE_ELEVEE = 1;
	
		public static final int ENCODEUR_CONDUITE_GAUCHE_A = 10;
		public static final int ENCODEUR_CONDUITE_GAUCHE_B = 11; 
		public static final boolean ENCODEUR_CONDUITE_GAUCHE_INVERSION = true;
		public static final int ENCODEUR_CONDUITE_DROITE_A = 12;
		public static final int ENCODEUR_CONDUITE_DROITE_B = 13;
		public static final boolean ENCODEUR_CONDUITE_DROITE_INVERSION = false;
		
		// https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599717-encoders-measuring-rotation-of-a-wheel-or-other-shaft
		public static final int ENCODEUR_NOMBRE_ECHANTILLONS = 5; // max 127
		public static final int ENCODEUR_COMPTE_PAR_TOUR = 1024; // https://www.vexrobotics.com/217-5049.html
		public static final float ROUE_CIRCONFERENCE = (float) (100*Math.PI) ;
		public static final float ENCODEUR_DISTANCE_PAR_PULSE = ROUE_CIRCONFERENCE / ENCODEUR_COMPTE_PAR_TOUR; // echantillonage quadruple car k4x
		public static final float ENCODEUR_GLISSEMENT = 0.945f; // valeur a tuner
		public static final int ENCODEUR_PERIODE_MAX_AVANT_ARRET = 1;
		public static final int ENCODEUR_ROTATION_ARRET = 1;
		public static final float ROUE_FRICTION = 1;
		
		public static final double DISTANCE_KP = 0.0012;
		public static final double DISTANCE_KI = 0.00001; 
		public static final double DISTANCE_KD = 0;
		public static final float DISTANCE_TOLERANCE = 0f;
		// Kp = Proportional gain // Ki = Integral gain // Kd = Derivative gain
	}
	
	public interface ManetteConducteur
	{
		public static final int MANETTE_CONDUCTEUR = 0;
		public static final int BOUTON_A = 1;
		public static final int BOUTON_B = 2;
		public static final int BOUTON_X = 3;
		public static final int GACHETTE_DROITE = 3;
		public static final int GACHETTE_GAUCHE = 2;
		
		public static final int BOUTON_BASSE_VITESSE = 5;
		public static final int BOUTON_HAUTE_VITESSE = 6;
		
		public static final int CONDUITE_Y_GAUCHE = 1;
		public static final int CONDUITE_Y_DROITE = 5;			
		public static final boolean INVERSION_CONDUITE_Y_GAUCHE = true;
		public static final boolean INVERSION_CONDUITE_Y_DROITE = true;		
	}
	
	public interface ManetteOperateur
	{
		public static final int MANETTE_OPERATEUR = 1;
		public static final int BOUTON_HAUT_AVANT = 1; 
		public static final int BOUTON_HAUT_ARRIERE = 5;
		public static final int BOUTON_MILIEU_AVANT = 4;
		public static final int BOUTON_MILIEU_ARRIERE = 8;
		public static final int BOUTON_BAS_AVANT= 3;
		public static final int BOUTON_BAS_ARRIERE= 6;
		public static final int BOUTON_CENTRE= 7;
		public static final int BOUTON_OUVRIR= 2;
	}
}
