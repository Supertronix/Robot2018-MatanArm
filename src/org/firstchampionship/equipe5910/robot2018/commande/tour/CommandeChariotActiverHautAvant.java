package org.firstchampionship.equipe5910.robot2018.commande.tour;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverHautAvant extends Command{
	
	public CommandeChariotActiverHautAvant(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeChariotActiverHautAvant");
		//Robot.chariot.positionnerHautAvant();
	}
	
	@Override
	protected void execute() {
		Robot.bras.aller_position(Bras.POSITION.AVANT_ANGLE);
		Robot.chariot.aller_position(Chariot.POSITION.HAUT);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
