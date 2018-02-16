package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandePinceFermer extends Command{

	public CommandePinceFermer()
	{
		requires(Robot.pince);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandePinceFermer");
		
	}
	
	@Override
	protected void execute() {
		Robot.pince.fermer();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
