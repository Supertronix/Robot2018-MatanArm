package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.interaction.AnimateurLed;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeLedActiverFlash extends Command {

	public CommandeLedActiverFlash()
	{
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeLedActiverClignoter.initialize()");
	}
	
	@Override
	protected void execute() {
		AnimateurLed.getInstance().lancerSpectacleFlash();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
