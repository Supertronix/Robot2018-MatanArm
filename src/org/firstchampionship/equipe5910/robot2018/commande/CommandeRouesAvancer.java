package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesAvancer extends Command{

	protected int distanceVoulue;
	protected double positionInitiale = 0;
	protected double vitesse = 0.1; // test primitif
	
	public CommandeRouesAvancer(int distanceVoulue)
	{
		requires(Robot.roues);		
		this.distanceVoulue = distanceVoulue;
	}

	@Override
	protected void initialize() {
		System.out.println("CommandeRouesAvancer.initialize()");
		this.positionInitiale = Robot.roues.getDistanceDroite();
		System.out.println("Position initiale " + positionInitiale);
		Robot.roues.avancer(vitesse); 
		// Robot.roues.informerEncodeurDroitDeLaCible(distanceVoulue);
	}

	@Override
	protected void execute() {
		//System.out.println("CommandeRouesAvancer.execute()");
		Robot.roues.avancer(vitesse); 
		//Robot.roues.avancer(Robot.roues.getVitesseSelonEncodeurDroitStabilise()); 
		// System.out.println("selon pid vitesse = "  + Robot.roues.getVitesseSelonEncodeurDroitStabilise());
	}
	
	@Override
	protected boolean isFinished() {
		boolean estFini = Robot.roues.getDistanceDroite() > (this.positionInitiale + this.distanceVoulue);
		System.out.println("Distance parcourue " + (Robot.roues.getDistanceDroite() - this.positionInitiale));
		System.out.println("isFinished() " + estFini);
		return estFini;
	}
	
	@Override
	protected void end() {
		System.out.println("CommandeRouesAvancer.end()");
		Robot.roues.arreter();
	}
	

}
