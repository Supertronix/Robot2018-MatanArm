package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.VictorSP;

public class Roue {
	
	VictorSP roueGauche;
	VictorSP roueDroite;
	
	public Roue(){
		roueGauche = new VictorSP(RobotMap.ROUE_GAUCHE);
		roueDroite = new VictorSP(RobotMap.ROUE_DROITE);

	}
	
	public void avancer(double vitesse){
		roueGauche.set(vitesse);
		roueDroite.set(-vitesse);
	}
	
	public void deplacer(double vitesseGauche, double vitesseDroite){
		roueGauche.set(-vitesseGauche);
		roueDroite.set(-vitesseDroite);
	}
}
