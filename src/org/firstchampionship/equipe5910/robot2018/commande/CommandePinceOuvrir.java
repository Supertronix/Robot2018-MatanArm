package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandePinceOuvrir extends Command{

	public CommandePinceOuvrir()
	{
		requires(Robot.pince);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandePinceOuvrir");
		
	}
	
	@Override
	protected void execute() {
		Robot.pince.ouvrir();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
