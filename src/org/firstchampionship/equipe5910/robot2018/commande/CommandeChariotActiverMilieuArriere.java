package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverMilieuArriere extends Command{
	
	public CommandeChariotActiverMilieuArriere(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		//System.out.println("CommandeChariotActiverMilieuArriere");
	}
	
	@Override
	protected void execute() {
		//Robot.chariot.positionnerMilieuArriere();
		Robot.bras.allerPosition(Bras.POSITION.ARRIERE_MILIEU);
		Robot.chariot.allerPosition(Chariot.POSITION.MILIEU);
		Robot.bras.retrecir();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
