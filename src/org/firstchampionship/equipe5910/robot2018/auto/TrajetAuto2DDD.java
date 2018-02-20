package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHome;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePause;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceOuvrir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancerAngle;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrajetAuto2DDD extends CommandGroup{
	
	public TrajetAuto2DDD()
	{
		addParallel(new CommandeChariotActiverMilieuAvant());
		addSequential(new CommandeRouesAvancerAngle(2000, 35));
		addSequential(new CommandeRouesAvancerAngle(800, -45));
		addSequential(new CommandePinceOuvrir());
		addSequential(new CommandePause(0.350));
		addSequential(new CommandePinceFermer());
		addSequential(new CommandeChariotActiverHome());
	}
	
	protected void initialize(){
		System.out.println("Trajet2DDD");
	}
		
}
