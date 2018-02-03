package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

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
		
		// Todo : peut-être faire une classe dérivée de Encoder pour l'initialisation
		encodeurConduiteGauche = new Encoder(ENCODEUR_CONDUITE_GAUCHE_A, ENCODEUR_CONDUITE_GAUCHE_B,  ENCODEUR_CONDUITE_GAUCHE_INVERSION, Encoder.EncodingType.k4X);
		encodeurConduiteGauche.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE/ROUE_FRICTION);		
		encodeurConduiteGauche.setMaxPeriod(ENCODEUR_PERIODE_MAX_AVANT_ARRET);
		encodeurConduiteGauche.setMinRate(ENCODEUR_ROTATION_ARRET);
		encodeurConduiteGauche.setSamplesToAverage(ENCODEUR_NOMBRE_ECHANTILLONS);
		encodeurConduiteDroite = new Encoder(ENCODEUR_CONDUITE_DROITE_A, ENCODEUR_CONDUITE_DROITE_B,  ENCODEUR_CONDUITE_DROITE_INVERSION, Encoder.EncodingType.k4X);
		encodeurConduiteDroite.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE/ROUE_FRICTION);
		encodeurConduiteDroite.setMaxPeriod(ENCODEUR_PERIODE_MAX_AVANT_ARRET);
		encodeurConduiteDroite.setMinRate(ENCODEUR_ROTATION_ARRET);
		encodeurConduiteDroite.setSamplesToAverage(ENCODEUR_NOMBRE_ECHANTILLONS);
	}
	
	
	public double getDistanceGaucheSelonEncodeur() {
		System.out.println("raw gauche " + encodeurConduiteGauche.getRaw());
		return encodeurConduiteGauche.getDistance();
	}

	public double getDistanceDroiteSelonEncodeur() {
		System.out.println("raw droite " + encodeurConduiteGauche.getRaw());
		return encodeurConduiteDroite.getDistance();
	}
	
	public void avancer(double demandeVitesse, double direction){
		if(direction >= -0.2 && direction <= 0.2){
			roueGauche.set(demandeVitesse);
			roueDroite.set(-demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			roueGauche.set(demandeVitesse * (1 - Math.abs(direction)));
			roueDroite.set(-demandeVitesse);
			//System.out.println("gauche"+Math.abs(direction));
		}
		else{
			roueGauche.set(demandeVitesse );
			roueDroite.set(-demandeVitesse  * (1 - Math.abs(direction)));
			//System.out.println("droite"+Math.abs(direction));
		}

	}
	
	public void reculer(double demandeVitesse){
		roueGauche.set(-demandeVitesse);
		roueDroite.set(demandeVitesse);
	}

	public void avancer(double demandeVitesse){
		roueGauche.set(demandeVitesse);
		roueDroite.set(-demandeVitesse);
	}
	
	
	public void arreter(){
		roueGauche.set(0);
		roueDroite.set(0);
	}
	
	public void tournerSurPlace(double demandeVitesse){
		if(demandeVitesse >= -0.2 && demandeVitesse <= 0.2){
			roueGauche.set(0);
			roueDroite.set(0);
		}
		else{
			roueGauche.set(demandeVitesse);
			roueDroite.set(demandeVitesse);
		}
		
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
