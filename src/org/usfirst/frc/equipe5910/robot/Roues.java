package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Roues extends Subsystem implements RobotMap.Roues{
	
	VictorSP roueGauche;
	VictorSP roueDroite;
	
	DoubleSolenoid selecteurVitesse;
	
	Encoder encodeurConduiteDroite;
	Encoder encodeurConduiteGauche;
	
	public Roues(){
		roueGauche = new VictorSP(ROUE_GAUCHE);
		roueDroite = new VictorSP(ROUE_DROITE);
		
		selecteurVitesse = new DoubleSolenoid(VITESSE_BASSE, VITESSE_ELEVEE);
		
		encodeurConduiteGauche = new Encoder(ENCODEUR_CONDUITE_GAUCHE_A, ENCODEUR_CONDUITE_GAUCHE_B,  false, Encoder.EncodingType.k4X);
		encodeurConduiteDroite = new Encoder(ENCODEUR_CONDUITE_DROITE_A, ENCODEUR_CONDUITE_DROITE_B,  false, Encoder.EncodingType.k4X);
	
		encodeurConduiteGauche.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE);		
		encodeurConduiteGauche.setReverseDirection(false);
		encodeurConduiteGauche.setMaxPeriod(100);
		encodeurConduiteGauche.setMinRate(10);
		encodeurConduiteDroite.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE);		
		encodeurConduiteDroite.setReverseDirection(false);
		encodeurConduiteDroite.setMaxPeriod(1);
		encodeurConduiteDroite.setMinRate(30);
		
	}
	
	
	public double getDistanceGaucheSelonEncodeur() {
		return encodeurConduiteGauche.getDistance();
	}

	public double getDistanceDroiteSelonEncodeur() {
		return encodeurConduiteDroite.getDistance();
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
