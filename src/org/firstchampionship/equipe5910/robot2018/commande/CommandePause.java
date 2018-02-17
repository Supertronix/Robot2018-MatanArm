package org.firstchampionship.equipe5910.robot2018.commande;




import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class CommandePause extends Command {
	
	double dureeMicroseconde;
	double startTime;

	public CommandePause(double dureeSeconde) {
		 dureeMicroseconde = dureeSeconde * 1000000;
		 
	 }
	 
	 @Override
	protected void initialize() {
		 startTime = RobotController.getFPGATime();

	}
	 
	@Override
	protected boolean isFinished() {
		if(RobotController.getFPGATime() >= startTime + dureeMicroseconde){
			return true;

		}
		else {
			
			return false;
		}
	}

}
