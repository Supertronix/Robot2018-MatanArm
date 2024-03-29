package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHome;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePause;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceOuvrir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancerAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto2GGG extends CommandGroup{
	
	public TrajetAuto2GGG()
	{
		addParallel(new CommandeChariotActiverMilieuAvant());
		addSequential(new CommandeRouesAvancerAngle(2250, -40));
		addSequential(new CommandeRouesAvancerAngle(650, 50));
		addSequential(new CommandePinceOuvrir());
		addSequential(new CommandePause(0.350));
		addSequential(new CommandePinceFermer());
		addSequential(new CommandeChariotActiverHome());
	}
	
	protected void initialize(){
		System.out.println("Trajet2GGG");
		SmartDashboard.putString("Trajet", "1GGG");
	}
		
}
