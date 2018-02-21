package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotControleur;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class CommandeBrasAllonger extends Command {

	public CommandeBrasAllonger()
	{
		requires(Robot.bras);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeBrasAllonger");
		
		//if (DriverStation.getInstance().get)

		if (Robot.bras.isInExtendedLimits() || RobotControleur.estAutonome)
		{
			Robot.bras.allonger();
		}	
	}
	
	@Override
	protected void execute() {
		
	}	
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
