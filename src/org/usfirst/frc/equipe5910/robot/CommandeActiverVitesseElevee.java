package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeActiverVitesseElevee extends Command {
	
	public CommandeActiverVitesseElevee() {
		requires(RobotControleur.roue);
		System.out.println("CommandeActiverVitesseElevee");
	}
	
	@Override
	protected void initialize() {
		RobotControleur.roue.activerVitesseElevee();
		System.out.println("CommandeActiverVitesseElevee.initialize()");
	}

	@Override
	protected void execute() {
		RobotControleur.roue.activerVitesseElevee();
		System.out.println("CommandeActiverVitesseElevee.execute()");
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
