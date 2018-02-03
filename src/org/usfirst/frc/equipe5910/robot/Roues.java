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
		
		selecteurVitesse = new DoubleSolenoid(RobotMap.VITESSE_BASSE, RobotMap.VITESSE_ELEVEE);
		

	}
	
	public void avancer(double vitesse){
		roueGauche.set(vitesse);
		roueDroite.set(-vitesse);
	}
	
	public void reculer(double vitesse){
		roueGauche.set(-vitesse);
		roueDroite.set(vitesse);
	}
	public void arreter(){
		roueGauche.set(0);
		roueDroite.set(0);
	}
	
	public void tournerSurPlace(double vitesse){
		roueGauche.set(vitesse);
		roueDroite.set(vitesse);
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
