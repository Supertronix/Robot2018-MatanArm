package org.firstchampionship.equipe5910.robot2018;

public interface RobotMap 
{
	public interface Constants
	{
		public static final int kTimeoutMs = 10;
	}
	public interface Chariot
	{
		public static final int CHARIOT_MOTEUR_PRINCIPAL = 3;
		public static final boolean CHARIOT_MOTEUR_PRINCIPAL_INVERSION = true;
		public static final int CHARIOT_MOTEUR_ESCLAVE = 4;
		public static final boolean CHARIOT_MOTEUR_ESCLAVE_INVERSION = false;
		public static final boolean CHARIOT_SENSOR_ENCODEUR_INVERSION = true;
		
		public static final double CHARIOT_PID_KP = 1;
		public static final int CHARIOT_POSITION_BAS= 1000;
		public static final int CHARIOT_POSITION_MILIEU = 21000; //18000 = milieu
		public static final int CHARIOT_POSITION_HAUT = 36000;
		
		public enum POSITION {
	        BAS,
			MILIEU,
	        HAUT, 
	    }
		
	}
	
	public interface Pince
	{
		public static final int PINCE_OUVERTE = 2;
		public static final int PINCE_FERMEE = 3;
	}
	
	public interface Bras
	{
		public static final int BRAS_ALLONGE = 4;
		public static final int BRAS_RETRECI = 5;
		public static final int BRAS_MOTEUR_PRINCIPAL = 2;
		public static final boolean BRAS_MOTEUR_PRINCIPAL_INVERSION = false;
		public static final int BRAS_MOTEUR_ESCLAVE = 5;
		public static final boolean BRAS_MOTEUR_ESCLAVE_INVERSION = true;
		public static final boolean BRAS_SENSOR_POTENTIOMETRE_INVERSION = false;
		
		public static final int BRAS_LIMITE_AVANT = 873;
		public static final int BRAS_LIMITE_ARRIERE = 222;
		
		public static final double BRAS_PID_KP = 8;
		public static final double BRAS_PID_KI = 0.00015;
		
		public static final int BRAS_POSITION_ARRIERE = 222;
		public static final int BRAS_POSITION_MILIEU = 527;
		public static final int BRAS_POSITION_AVANT = 873;
		public static final int BRAS_POSITION_AVANT_ANGLE = 647;
		public static final int BRAS_POSITION_ARRIERE_ANGLE = 407;
		
		public enum POSITION {
	        ARRIERE,
			MILIEU,
	        AVANT,
	        AVANT_ANGLE,
	        ARRIERE_ANGLE,
	    }

	}
	
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
		public static final float ENCODEUR_GLISSEMENT = 0.99f; // valeur a tuner
		public static final int ENCODEUR_PERIODE_MAX_AVANT_ARRET = 1;
		public static final int ENCODEUR_ROTATION_ARRET = 1;
		public static final float ROUE_FRICTION = 1;
		
		public static final double DISTANCE_KP = 0.0015;
		public static final double DISTANCE_KI = 0.00001; 
		public static final double DISTANCE_KD = 0;
		public static final float DISTANCE_TOLERANCE = 0f;
		// Kp = Proportional gain // Ki = Integral gain // Kd = Derivative gain
		
		// DRIVE AUTO PID
		public static final double GYRO_KP_AVANCER_ANGLE = 0.005; //0.03
		public static final double GYRO_KP_AVANCER = 0.005; //0.03
		public static final double GYRO_KI = 0.0;
		public static final double GYRO_KI_AVANCER = 0.0;
		public static final double GYRO_KI_AVANCER_ANGLE = 0.0;
		
		public static final double GYRO_KP_ROTATEONLY = 0.02; // + haut = plus aggressif
		public static final double GYRO_KI_ROTATEONLY = 0.02; // + bas = plus aggressif //0.0015
		public static final double GYRO_KI_ROTATEONLY_ANGLE_ELEVE = 0.01;
	}
	
	public interface ManetteConducteur
	{
		public static final int MANETTE_CONDUCTEUR = 0;
		public static final int BOUTON_A = 1;
		public static final int BOUTON_B = 2;
		public static final int BOUTON_X = 3;		
		public static final int BOUTON_Y = 4;
		public static final int BOUTON_GAUCHE = 5;
		public static final int BOUTON_DROIT = 6;
		public static final int BOUTON_RETOUR = 7;
		public static final int BOUTON_DEMARRER = 8;
		
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
	
	public interface SelecteurModeAutonome
	{
		public static final int INTERRUPTEUR_DIGITAL_0 = 2;
		public static final int INTERRUPTEUR_DIGITAL_1 = 3;
		public static final int INTERRUPTEUR_DIGITAL_2 = 4;
		public static final int INTERRUPTEUR_DIGITAL_3 = 5;
	}
}
