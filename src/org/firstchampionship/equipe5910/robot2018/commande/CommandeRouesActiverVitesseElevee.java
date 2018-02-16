package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesActiverVitesseElevee extends Command {
	
	public CommandeRouesActiverVitesseElevee() {
		requires(Robot.roues);
		//System.out.println("CommandeActiverVitesseElevee()");
	}
	
	@Override
	protected void initialize() {
		//System.out.println("CommandeActiverVitesseElevee.initialize()");
	}

	@Override
	protected void execute() {
		Robot.roues.activerVitesseElevee();
		//RobotControleur.roue.activerVitesseElevee();
		//System.out.println("CommandeActiverVitesseElevee.execute()");
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
