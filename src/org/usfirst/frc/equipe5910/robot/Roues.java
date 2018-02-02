package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Roues extends Subsystem {
	
	VictorSP roueGauche;
	VictorSP roueDroite;
	
	DoubleSolenoid selecteurVitesse;
	
	public Roues(){
		roueGauche = new VictorSP(RobotMap.ROUE_GAUCHE);
		roueDroite = new VictorSP(RobotMap.ROUE_DROITE);
		
		selecteurVitesse = new DoubleSolenoid(0, 1);
		

	}
	
	public void avancer(double vitesse){
		roueGauche.set(vitesse);
		roueDroite.set(-vitesse);
	}
	
	public void deplacer(double vitesseGauche, double vitesseDroite){
		roueGauche.set(-vitesseGauche);
		roueDroite.set(-vitesseDroite);
	}
	
	public void activerVitesseElevee(){
		selecteurVitesse.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void activerVitesseBasse(){
		selecteurVitesse.set(DoubleSolenoid.Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}
