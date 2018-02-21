package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeBrasPIDSet extends Command {

	protected double valeur;
	
	public CommandeBrasPIDSet(double value)
	{
		requires(Robot.bras);
		this.valeur = value;
	}
	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		Robot.bras.setPositionPIDmanuel(this.valeur);
	}	
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
