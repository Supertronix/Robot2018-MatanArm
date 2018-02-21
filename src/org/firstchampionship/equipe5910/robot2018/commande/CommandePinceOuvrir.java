package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandePinceOuvrir extends Command{

	public CommandePinceOuvrir()
	{
		requires(Robot.pince);
	}
	
	@Override
	protected void initialize() {		
	}
	
	@Override
	protected void execute() {
		if (Robot.bras.isInExtendedLimits() && Robot.chariot.getPosition() < RobotMap.Chariot.CHARIOT_POSITION_LIMITE_OUVERTURE_PINCE)
		{
			// ON OUVRE PAS
		}
		else
		{
			Robot.pince.ouvrir();
		}
			
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
