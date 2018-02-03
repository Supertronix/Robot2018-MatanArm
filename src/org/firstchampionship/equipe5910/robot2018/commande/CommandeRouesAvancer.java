package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesAvancer extends Command{

	int distanceEnMillimetres;
	double positionInitiale = 0;
	
	public CommandeRouesAvancer(int distanceEnMillimetres)
	{
		requires(Robot.roues);		
		this.distanceEnMillimetres = distanceEnMillimetres;
	}

	@Override
	protected void initialize() {
		System.out.println("CommandeRouesAvancer.initialize()");
		this.positionInitiale = Robot.roues.getDistanceDroiteSelonEncodeur();
		Robot.roues.avancer(0.1); // test primitif
	}

	@Override
	protected void execute() {
		System.out.println("CommandeRouesAvancer.execute()");
	}
	
	
	@Override
	protected boolean isFinished() {
		return Robot.roues.getDistanceDroiteSelonEncodeur() > (this.positionInitiale + this.distanceEnMillimetres);
	}
	
	@Override
	protected void end() {
		Robot.roues.arreter();
	}
	

}
