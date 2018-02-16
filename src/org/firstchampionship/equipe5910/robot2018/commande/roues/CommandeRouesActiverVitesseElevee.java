package org.firstchampionship.equipe5910.robot2018.commande.roues;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesActiverVitesseElevee extends Command {
	
	public CommandeRouesActiverVitesseElevee() {
		requires(Robot.roues);
		//System.out.println("CommandeActiverVitesseElevee()");
	}
	
	@Override
	protected void initialize() {
		Robot.roues.activerVitesseElevee();
		//System.out.println("CommandeActiverVitesseElevee.initialize()");
	}

	@Override
	protected void execute() {
		//RobotControleur.roue.activerVitesseElevee();
		//System.out.println("CommandeActiverVitesseElevee.execute()");
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
