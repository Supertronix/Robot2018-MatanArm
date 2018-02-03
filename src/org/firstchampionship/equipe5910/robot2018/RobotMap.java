package org.firstchampionship.equipe5910.robot2018;

public interface RobotMap {

	
	public interface Roues
	{
		public static final int ROUE_GAUCHE = 17;
		public static final int ROUE_DROITE = 18;
		
		public static final int VITESSE_BASSE = 0;
		public static final int VITESSE_ELEVEE = 1;
	
		public static final int ENCODEUR_CONDUITE_GAUCHE_A = 10;
		public static final int ENCODEUR_CONDUITE_GAUCHE_B = 11; 
		public static final boolean ENCODEUR_CONDUITE_GAUCHE_INVERSION = false;
		public static final int ENCODEUR_CONDUITE_DROITE_A = 12;
		public static final int ENCODEUR_CONDUITE_DROITE_B = 13;
		public static final boolean ENCODEUR_CONDUITE_DROITE_INVERSION = true;
		
		// https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599717-encoders-measuring-rotation-of-a-wheel-or-other-shaft
		public static final int ENCODEUR_COMPTE_PAR_TOUR = 1024; // https://www.vexrobotics.com/217-5049.html
		public static final float ROUE_CIRCONFERENCE = (float) ((4*Math.PI)/ 25.4) ; // pouces / 25.4 = millimetres
		public static final float ENCODEUR_DISTANCE_PAR_PULSE = ROUE_CIRCONFERENCE / ENCODEUR_COMPTE_PAR_TOUR;
		public static final float ROUE_FRICTION = 1; // valeur a tuner
		public static final int ENCODEUR_NOMBRE_ECHANTILLONS = 7; // max 127
		public static final int ENCODEUR_PERIODE_MAX_AVANT_ARRET = 1;
		public static final int ENCODEUR_ROTATION_ARRET = 1;
	}
	
	public interface Manette
	{
		public static final int MANETTE_PRINCIPALE = 0;
		public static final int BOUTON_A = 1;
		public static final int BOUTON_X = 3;
		public static final int GACHETTE_DROITE = 3;
		public static final int GACHETTE_GAUCHE = 2;
		// 2 = B
	}



}
