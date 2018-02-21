package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasAllonger;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasRetrecir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverBasArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHome;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHautAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePause;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceOuvrir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancerAngle;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;
import org.firstchampionship.equipe5910.robot2018.interaction.SelecteurNombreCubes;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrajetAuto1GGG extends CommandGroup{
	
	public TrajetAuto1GGG()
	{
		
		if(!SelecteurNombreCubes.getInstance().viseDeuxCube()) // 1 CUBE
		{
			// SWITCH GAUCHE
			addParallel(new CommandeChariotActiverMilieuAvant());
			addSequential(new CommandeRouesAvancer(3600));
			addSequential(new CommandeRouesTourner(90));
			addSequential(new CommandeRouesAvancer(175));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.350));
			addSequential(new CommandePinceFermer());
			addSequential(new CommandeChariotActiverHome());
		}
		else // 2 CUBES
		{
			// SCALE GAUCHE
			addSequential(new CommandeRouesAvancer(5000));
			addParallel(new CommandeChariotActiverHautAvant());
			addParallel(new CommandeBrasAllonger());
			addSequential(new CommandeRouesAvancerAngle(1300, 45));
			addSequential(new CommandeRouesAvancerAngle(800, -30));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.450));
			addSequential(new CommandePinceFermer());
			addSequential(new CommandeBrasRetrecir());
			addSequential(new CommandeChariotActiverHome());
			
			
			// SWITCH GAUCHE
			addSequential(new CommandeRouesTourner(-16.5));
			addSequential(new CommandeChariotActiverBasArriere());
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandeRouesAvancer(-1400));
			addSequential(new CommandePinceFermer());
			addSequential(new CommandePause(0.200));
			addSequential(new CommandeChariotActiverMilieuArriere());
			addSequential(new CommandePause(0.600));
			addSequential(new CommandeRouesAvancer(-200));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.450));
			addSequential(new CommandePinceFermer());
		}		
		
		
	}
	
	protected void initialize(){
		System.out.println("Trajet1GGG");
	}
		
}
