package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotOuvrir extends Command{
	
	public CommandeChariotOuvrir(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeChariotOuvrir");
	}
	
	@Override
	protected void execute() {
		Robot.chariot.Ouvrir();		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
