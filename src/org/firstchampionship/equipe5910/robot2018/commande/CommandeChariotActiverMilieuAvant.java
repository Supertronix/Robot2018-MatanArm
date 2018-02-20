package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverMilieuAvant extends Command{
	
	public CommandeChariotActiverMilieuAvant(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeChariotActiverMilieuAvant");
	}
	
	@Override
	protected void execute() {
		//Robot.chariot.positionnerMilieuAvant();
		Robot.bras.allerPosition(Bras.POSITION.AVANT_MILIEU);
		Robot.chariot.allerPosition(Chariot.POSITION.MILIEU);
		Robot.bras.retrecir();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
