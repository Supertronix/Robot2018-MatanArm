package org.firstchampionship.equipe5910.robot2018.commande.tour;

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
		//Robot.chariot.positionnerBasArriere();
	}
	
	@Override
	protected void execute() {
		Robot.bras.aller_position(Bras.POSITION.ARRIERE);
		Robot.chariot.aller_position(Chariot.POSITION.BAS);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
