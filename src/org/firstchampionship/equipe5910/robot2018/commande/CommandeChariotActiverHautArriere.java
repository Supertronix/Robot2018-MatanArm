package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverHautArriere extends Command{
	
	public CommandeChariotActiverHautArriere(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeChariotActiverHautArriere");
	}
	
	@Override
	protected void execute() {
		//Robot.chariot.positionnerHautArriere();
		Robot.bras.allerPosition(Bras.POSITION.ARRIERE_HAUT);
		Robot.chariot.allerPosition(Chariot.POSITION.HAUT);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
