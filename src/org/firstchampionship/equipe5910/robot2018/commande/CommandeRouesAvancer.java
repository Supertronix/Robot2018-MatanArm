package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesAvancer extends Command{

	protected double distanceVoulue;
	protected double positionInitiale = 0;
	protected double vitesse = 0.1; // test primitif
	protected boolean PIDFirstLoop = true;
	public CommandeRouesAvancer(double distanceVoulue)
	{
		requires(Robot.roues);		
		this.distanceVoulue = distanceVoulue;
	}

	@Override
	protected void initialize() {
		Robot.roues.setGyroPid(RobotMap.Roues.GYRO_KP_AVANCER, RobotMap.Roues.GYRO_KP_AVANCER);
		Robot.roues.zeroSensors();
		Robot.roues.setGyroConsigne(0);
		System.out.println("CommandeRouesAvancer.initialize()");
		//this.positionInitiale = Robot.roues.getDistanceGauche();
		System.out.println("Position initiale " + positionInitiale);
		
		// Robot.roues.avancer(vitesse); 
		// Robot.roues.informerEncodeurDroitDeLaCible(distanceVoulue);
	}

	@Override
	protected void execute() {
		
		
		if (distanceVoulue - Robot.roues.getDistanceGauche() <= 500)
		{
			if (PIDFirstLoop)
			{
					Robot.roues.resetPIDS();
					PIDFirstLoop = false;
			}
			
			Robot.roues.setDistanceConsigne(distanceVoulue);
			Robot.roues.conduireDroit();
		}
		else
		{
			Robot.roues.conduireDroitGyroSeul(0.75);
		}
		//System.out.println("CommandeRouesAvancer.execute()");
		//Robot.roues.avancer(vitesse); 
		//Robot.roues.avancer(Robot.roues.getVitesseSelonEncodeurDroitStabilise()); 
		// System.out.println("selon pid vitesse = "  + Robot.roues.getVitesseSelonEncodeurDroitStabilise());
	}
	
	@Override
	protected boolean isFinished() {
		boolean estFini = Robot.roues.getDistanceGauche() >= (this.distanceVoulue);
		System.out.println("Distance parcourue " + (Robot.roues.getDistanceGauche() - this.positionInitiale));
		System.out.println("isFinished() " + estFini);
		return estFini;
	}
	
	@Override
	protected void end() {
		System.out.println("CommandeRouesAvancer.end()");
		Robot.roues.disablePIDs();
		
		//Robot.roues.arreter();
	}
	

}
