package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Chariot;
import org.firstchampionship.equipe5910.robot2018.interaction.AnimateurLed;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverBasAvant extends Command{
	
	public CommandeChariotActiverBasAvant(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		//System.out.println("CommandeChariotActiverBasAvant");
	}
	
	@Override
	protected void execute() {
		Robot.bras.allerPosition(Bras.POSITION.AVANT_BAS);
		Robot.chariot.allerPosition(Chariot.POSITION.BAS);
		Robot.bras.retrecir();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
