package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeBrasRetrecir extends Command{

	public CommandeBrasRetrecir()
	{
		requires(Robot.bras);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandePinceOuvrir");
		Robot.bras.allonger();
	}
	
	@Override
	protected void execute() {
		
	}	
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
