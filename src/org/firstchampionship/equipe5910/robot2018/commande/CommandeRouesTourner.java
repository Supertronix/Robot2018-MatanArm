package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesTourner extends Command{

	protected double angleVoulue;
	protected double angleInitiale = 0;
	protected boolean negativeAngle = false;
	
	public CommandeRouesTourner(double angleVoulue)
	{
		requires(Robot.roues);		
		this.angleVoulue = angleVoulue;
		if (angleVoulue < 0) negativeAngle = true;
	}

	@Override
	protected void initialize() {
		Robot.roues.setGyroPid(RobotMap.Roues.GYRO_KP_ROTATEONLY, RobotMap.Roues.GYRO_KI_ROTATEONLY);
		Robot.roues.zeroSensors();
		Robot.roues.setGyroConsigne(angleVoulue);
		
		
		System.out.println("CommandeRouesAvancer.initialize()");
		//this.positionInitiale = Robot.roues.getDistanceGauche();

		// Robot.roues.avancer(vitesse); 
		// Robot.roues.informerEncodeurDroitDeLaCible(distanceVoulue);
	}

	@Override
	protected void execute() {
		//Robot.roues.rotateWithGyro();
		if (angleVoulue > 0)
		{
			Robot.roues.conduire(0.65, -0.65);
		}
		else
		{
			Robot.roues.conduire(-0.65, 0.65);
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		boolean estFini = false;
		if (negativeAngle)
		{
			estFini = Robot.roues.getGyroAngle() <= (this.angleVoulue);
		}
		else
		{
			estFini = Robot.roues.getGyroAngle() >= (this.angleVoulue);
		}
			
		if (estFini) Robot.roues.conduire(0,0);
		System.out.println("Angle parcourue " + (Robot.roues.getGyroAngle() - this.angleInitiale));
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
