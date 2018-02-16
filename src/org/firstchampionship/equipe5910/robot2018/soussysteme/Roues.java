package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Roues extends Subsystem implements RobotMap.Roues{
	
	protected VictorSP roueGauche;
	protected VictorSP roueDroite;
	protected DoubleSolenoid selecteurVitesse;
	protected Encoder encodeurConduiteDroite;
	protected Encoder encodeurConduiteGauche;
	protected PIDController pidControleurDistance;
	protected CustomPIDOutput pidSortieDistance;
	
	public Roues()
	{
		roueGauche = new VictorSP(ROUE_GAUCHE);
		roueDroite = new VictorSP(ROUE_DROITE);
		
		selecteurVitesse = new DoubleSolenoid(VITESSE_BASSE, VITESSE_ELEVEE);
		
		encodeurConduiteGauche = new Encoder(ENCODEUR_CONDUITE_GAUCHE_A, ENCODEUR_CONDUITE_GAUCHE_B,  ENCODEUR_CONDUITE_GAUCHE_INVERSION, Encoder.EncodingType.k4X);
		encodeurConduiteGauche.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE/ENCODEUR_GLISSEMENT);
		encodeurConduiteGauche.setSamplesToAverage(ENCODEUR_NOMBRE_ECHANTILLONS);
		encodeurConduiteDroite = new Encoder(ENCODEUR_CONDUITE_DROITE_A, ENCODEUR_CONDUITE_DROITE_B,  ENCODEUR_CONDUITE_DROITE_INVERSION, Encoder.EncodingType.k4X);
		encodeurConduiteDroite.setDistancePerPulse(ENCODEUR_DISTANCE_PAR_PULSE/ENCODEUR_GLISSEMENT);
		encodeurConduiteDroite.setSamplesToAverage(ENCODEUR_NOMBRE_ECHANTILLONS);		
		
		pidSortieDistance = new CustomPIDOutput();
		pidControleurDistance = new PIDController(DISTANCE_KP, DISTANCE_KI, DISTANCE_KD, encodeurConduiteGauche, pidSortieDistance);
		pidControleurDistance.setSetpoint(0);
		pidControleurDistance.setOutputRange(-0.35, 0.35);
		pidControleurDistance.setAbsoluteTolerance(DISTANCE_TOLERANCE);
		pidControleurDistance.enable();			
	}
	// Todo : peut-etre faire une classe derivee de Encoder pour l'initialisation
	// Todo : peut-etre faire une classe derivee de Encoder pour l'initialisation
	//encodeurConduiteGauche.setMaxPeriod(ENCODEUR_PERIODE_MAX_AVANT_ARRET);
	//encodeurConduiteGauche.setMinRate(ENCODEUR_ROTATION_ARRET);

	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////  VITESSE  /////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////	
	
	public void activerVitesseElevee(){
		selecteurVitesse.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void activerVitesseBasse(){
		selecteurVitesse.set(DoubleSolenoid.Value.kForward);
	}
	
	public void changerVitesse()
	{
	/*	if (driveTrainSolenoid.get() == DoubleSolenoid.Value.kReverse)
			driveTrainSolenoid.set(DoubleSolenoid.Value.kForward);
		else
			driveTrainSolenoid.set(DoubleSolenoid.Value.kReverse);*/
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////// DISTANCE ///////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////	
	
	public void setDistanceSenseursZero() 
	{
		encodeurConduiteGauche.reset();
		encodeurConduiteDroite.reset();
		amorcerPid();
	}
	public void amorcerPid() {
		pidControleurDistance.reset();
		pidControleurDistance.enable();
	}
	public void setDistancePid(double p, double i)
	{
		pidControleurDistance.setPID(p, i, 0);
	}
	public void setDistancePid(double p, double i, double d)
	{
		pidControleurDistance.setPID(p, i, d);
	}
	public void setDistanceConsigne(int cible)
	{
		pidControleurDistance.setSetpoint(cible);	
		//this.pidControleurDistanceDroit.enable();
	}
	public void setDistanceFeedForward(double f)
	{
		pidControleurDistance.setF(f);
	}
	
	//////////////////////////////////////////////////////////////////////////////////
		
	public double getDistanceGauche() {
		//System.out.println("raw gauche " + encodeurConduiteGauche.getRaw());
		return encodeurConduiteGauche.getDistance();
	}

	public double getDistanceDroite() {
		//System.out.println("raw droite " + encodeurConduiteGauche.getRaw());
		return encodeurConduiteDroite.getDistance();
	}
	
	public double getDistanceCommande() {
		System.out.println("pid commande " + pidSortieDistance.getPIDOut());
		return pidSortieDistance.getPIDOut();	
	}	
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	// Pour Encodeur et Gyro
	protected class CustomPIDOutput implements PIDOutput {

		double distanceSortiePID;
		
		@Override
		public void pidWrite(double sortie) {
			distanceSortiePID = sortie;
		}
		
		public double getPIDOut() {
			return distanceSortiePID;
		}
	}		

}
