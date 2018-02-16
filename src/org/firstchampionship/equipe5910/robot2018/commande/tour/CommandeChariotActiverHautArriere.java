package org.firstchampionship.equipe5910.robot2018.commande.tour;

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
		//Robot.chariot.positionnerHautArriere();
	}
	
	@Override
	protected void execute() {
		Robot.bras.aller_position(Bras.POSITION.ARRIERE_ANGLE);
		Robot.chariot.aller_position(Chariot.POSITION.HAUT);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
