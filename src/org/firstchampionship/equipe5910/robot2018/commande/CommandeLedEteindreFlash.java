package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.interaction.AnimateurLed;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeLedEteindreFlash extends Command {

	public CommandeLedEteindreFlash()
	{
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeLedEteindreFlash.initialize()");
	}
	
	@Override
	protected void execute() {
		AnimateurLed.getInstance().arreterSpectacleFlash();	
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
