package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras;

import edu.wpi.first.wpilibj.command.Command;

public class CommandeChariotActiverBasAvant extends Command{
	
	public CommandeChariotActiverBasAvant(){
		requires(Robot.chariot);
	}
	
	@Override
	protected void initialize() {
		System.out.println("CommandeChariotActiverBasAvant");
		Robot.chariot.positionnerBasAvant();
	}
	
	@Override
	protected void execute() {
		Robot.bras.aller_position(Bras.POSITION.AVANT);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	
}
