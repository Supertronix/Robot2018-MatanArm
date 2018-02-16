package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverBasArriere extends Command{
	
	public CommandeChariotActiverBasArriere(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeChariotActiverBasArriere");
	}
	
	@Override
	protected void execute() {
		//Robot.chariot.positionnerBasArriere();
		Robot.bras.allerPosition(Bras.POSITION.ARRIERE);
		Robot.chariot.allerPosition(Chariot.POSITION.BAS);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
