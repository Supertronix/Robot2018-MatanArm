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
		public static final int ENCODEUR_CONDUITE_DROITE_A = 12;
		public static final int ENCODEUR_CONDUITE_DROITE_B = 13;
		
		public static final int ENCODEUR_COMPTE_PAR_TOUR = 1024; // https://www.vexrobotics.com/217-5049.html
		public static final float ENCODEUR_DISTANCE_PAR_PULSE = 0.5f;
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
