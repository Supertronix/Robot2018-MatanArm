package org.firstchampionship.equipe5910.robot2018.commande.roues;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesActiverVitesseBasse extends Command{

	public CommandeRouesActiverVitesseBasse() {
		requires(Robot.roues);
		//System.out.println("CommandeActiverVitesseBasse()");
	}
	
	@Override
	protected void initialize() {
		Robot.roues.activerVitesseBasse();
		//System.out.println("CommandeActiverVitesseBasse.initialize()");
	}
	
	@Override
	protected void execute() {
		//RobotControleur.roue.activerVitesseBasse();
		//System.out.println("CommandeActiverVitesseBasse.execute()");
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
