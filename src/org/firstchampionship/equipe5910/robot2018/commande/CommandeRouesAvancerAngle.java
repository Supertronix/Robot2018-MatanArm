package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesAvancerAngle extends Command{

	protected double distanceVoulue;
	protected double positionInitiale = 0;
	protected double vitesse = 0.1; // test primitif
	protected boolean PIDFirstLoop = true;
	protected double angleVoulue;
	public CommandeRouesAvancerAngle(double distanceVoulue, double angle)
	{
		requires(Robot.roues);		
		this.distanceVoulue = distanceVoulue;
		this.angleVoulue = angle;
	}

	@Override
	protected void initialize() {
		Robot.roues.setGyroPid(RobotMap.Roues.GYRO_KP_AVANCER_ANGLE, RobotMap.Roues.GYRO_KI_AVANCER_ANGLE);
		Robot.roues.zeroSensors();
		Robot.roues.setGyroConsigne(angleVoulue);
		System.out.println("CommandeRouesAvancer.initialize()");
		//this.positionInitiale = Robot.roues.getDistanceGauche();
		System.out.println("Position initiale " + positionInitiale);
		
		// Robot.roues.avancer(vitesse); 
		// Robot.roues.informerEncodeurDroitDeLaCible(distanceVoulue);
	}

	@Override
	protected void execute() {
		
		
		if (Math.abs(distanceVoulue - Robot.roues.getDistanceGauche()) <= 500)
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
			if (distanceVoulue > 0)
			{
				Robot.roues.conduireDroitGyroSeul(0.75);
			}
			else
			{
				Robot.roues.conduireDroitGyroSeul(-0.75);
			}
		}
		//System.out.println("CommandeRouesAvancer.execute()");
		//Robot.roues.avancer(vitesse); 
		//Robot.roues.avancer(Robot.roues.getVitesseSelonEncodeurDroitStabilise()); 
		// System.out.println("selon pid vitesse = "  + Robot.roues.getVitesseSelonEncodeurDroitStabilise());
	}
	
	@Override
	protected boolean isFinished() {
		boolean estFini;
		
		if (distanceVoulue >= 0)
		{
			estFini = Robot.roues.getDistanceGauche() >= (this.distanceVoulue);
		}
		else
		{
			estFini = Robot.roues.getDistanceGauche() <= (this.distanceVoulue);
		}
		
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
