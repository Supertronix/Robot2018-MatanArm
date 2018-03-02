package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;
import org.firstchampionship.equipe5910.robot2018.interaction.AnimateurLed;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverBasArriere extends Command{
	
	public CommandeChariotActiverBasArriere(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		//System.out.println("CommandeChariotActiverBasArriere");
	}
	
	@Override
	protected void execute() {
		Robot.bras.allerPosition(Bras.POSITION.ARRIERE_BAS);
		Robot.chariot.allerPosition(Chariot.POSITION.BAS);
		Robot.bras.retrecir();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
