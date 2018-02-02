package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeActeverVitesseBasse extends Command{

	
	public CommandeActeverVitesseBasse() {
		requires(RobotControleur.roue);
		System.out.println("CommandeActeverVitesseBasse");
	}
	
	@Override
	protected void initialize() {
		RobotControleur.roue.activerVitesseBasse();
		System.out.println("CommandeActeverVitesseBasse.initialize");
	}
	
	@Override
	protected void execute() {
		RobotControleur.roue.activerVitesseBasse();
		System.out.println("CommandeActeverVitesseBasse.execute");
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
