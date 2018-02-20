package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverHome extends Command{
	
	boolean estFini = false;
	
	public CommandeChariotActiverHome(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		System.out.println("CommandeChariotActiverCentre");
		Robot.chariot.allerPosition(Chariot.POSITION.BAS);
		Robot.bras.allerPosition(Bras.POSITION.HOME);
		Robot.bras.retrecir();
		estFini = true;
	}

	@Override
	protected boolean isFinished() {
		return estFini;
	}
	
	
}
