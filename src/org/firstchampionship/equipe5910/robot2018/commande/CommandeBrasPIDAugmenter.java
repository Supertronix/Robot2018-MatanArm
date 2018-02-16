package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeBrasPIDAugmenter extends Command {

	public CommandeBrasPIDAugmenter()
	{
		requires(Robot.bras);
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		
	}	
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
