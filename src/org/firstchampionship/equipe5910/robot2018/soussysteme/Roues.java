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
		
		// Todo : peut-etre faire une classe derivee de Encoder pour l'initialisation
		encodeurConduiteGauche = new Encoder(ENCODEUR_CONDUITE_GAUCHE_A, ENCODEUR_CONDUITE_GAUCHE_B,  ENCODEUR_CONDUITE_GAUCHE_INVERSION, Encoder.EncodingType.k4X);
		encodeurConduiteGauche.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE/ENCODEUR_GLISSEMENT);
		//encodeurConduiteGauche.setMaxPeriod(ENCODEUR_PERIODE_MAX_AVANT_ARRET);
		//encodeurConduiteGauche.setMinRate(ENCODEUR_ROTATION_ARRET);
		encodeurConduiteGauche.setSamplesToAverage(ENCODEUR_NOMBRE_ECHANTILLONS);
		encodeurConduiteDroite = new Encoder(ENCODEUR_CONDUITE_DROITE_A, ENCODEUR_CONDUITE_DROITE_B,  ENCODEUR_CONDUITE_DROITE_INVERSION, Encoder.EncodingType.k4X);
		encodeurConduiteDroite.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE/ENCODEUR_GLISSEMENT);
		//encodeurConduiteDroite.setMaxPeriod(ENCODEUR_PERIODE_MAX_AVANT_ARRET);
		//encodeurConduiteDroite.setMinRate(ENCODEUR_ROTATION_ARRET);
		encodeurConduiteDroite.setSamplesToAverage(ENCODEUR_NOMBRE_ECHANTILLONS);
	}
	
	
	public double getDistanceGaucheSelonEncodeur() {
		//System.out.println("raw gauche " + encodeurConduiteGauche.getRaw());
		return encodeurConduiteGauche.getDistance();
	}

	public double getDistanceDroiteSelonEncodeur() {
		//System.out.println("raw droite " + encodeurConduiteGauche.getRaw());
		return encodeurConduiteDroite.getDistance();
	}
	
	public void avancer(double demandeVitesse, double direction){
		String etatVitesse = "";
		if(Math.abs(demandeVitesse) > 0.5){
			tournerHauteVitesse(demandeVitesse, direction);
			etatVitesse = "haute";
		}
		else if(Math.abs(demandeVitesse) < 0.3){
			tournerBasseVitesse(demandeVitesse, direction);
			etatVitesse = "basse";
		}
		else{
			tournerMoyenneVitesse(demandeVitesse, direction);
			etatVitesse = "moyenne";
		}
		
		System.out.println(etatVitesse + " vitesse roue gauche " + roueGauche.get());
	}
	
	public void tournerHauteVitesse(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(demandeVitesse);
			roueDroite.set(-demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(demandeVitesse * coefficientDirection);
			roueDroite.set(-demandeVitesse);
			//System.out.println("gauche"+Math.abs(direction));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			
			roueGauche.set(demandeVitesse );
			roueDroite.set(-demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerMoyenneVitesse(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(demandeVitesse);
			roueDroite.set(-demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(demandeVitesse * coefficientDirection);
			roueDroite.set(-demandeVitesse * 2);
			//System.out.println("gauche"+ demandeVitesse * (1 - Math.abs(direction)));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			roueGauche.set(demandeVitesse * 2);
			roueDroite.set(-demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerBasseVitesse(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(demandeVitesse);
			roueDroite.set(-demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(demandeVitesse * coefficientDirection);
			roueDroite.set(-demandeVitesse * 3);
			//System.out.println("gauche"+Math.abs(direction));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			roueGauche.set(demandeVitesse * 3);
			roueDroite.set(-demandeVitesse  * coefficientDirection);
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
		if(demandeVitesse >= -0.15 && demandeVitesse <= 0.15){
			roueGauche.set(0);
			roueDroite.set(0);
			//System.out.println("arret"+Math.abs(demandeVitesse));

		}
		else{
			roueGauche.set(demandeVitesse);
			roueDroite.set(demandeVitesse);
			//System.out.println("tourne"+Math.abs(demandeVitesse));

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
