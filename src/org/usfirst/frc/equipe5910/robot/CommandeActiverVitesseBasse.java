package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeActiverVitesseBasse extends Command{

	
	public CommandeActiverVitesseBasse() {
		requires(RobotControleur.roue);
		System.out.println("CommandeActiverVitesseBasse()");
	}
	
	@Override
	protected void initialize() {
		RobotControleur.roue.activerVitesseBasse();
		System.out.println("CommandeActiverVitesseBasse.initialize()");
	}
	
	@Override
	protected void execute() {
		//RobotControleur.roue.activerVitesseBasse();
		System.out.println("CommandeActiverVitesseBasse.execute()");
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
