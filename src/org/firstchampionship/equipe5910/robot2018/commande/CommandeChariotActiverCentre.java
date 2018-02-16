package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverCentre extends Command{
	
	boolean estFini = false;
	
	public CommandeChariotActiverCentre(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		System.out.println("CommandeChariotActiverCentre");
		Robot.chariot.allerPosition(Chariot.POSITION.BAS);
		Robot.bras.allerPosition(Bras.POSITION.MILIEU);
		estFini = true;
	}

	@Override
	protected boolean isFinished() {
		return estFini;
	}
	
	
}
