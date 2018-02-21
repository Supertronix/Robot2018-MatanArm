package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasAllonger;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasRetrecir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverBasArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHautAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePause;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceOuvrir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;
import org.firstchampionship.equipe5910.robot2018.interaction.SelecteurNombreCubes;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrajetAuto3GGG extends CommandGroup{
	
	public TrajetAuto3GGG()
	{
		if(!SelecteurNombreCubes.getInstance().viseDeuxCube()) // 1 CUBE
		{
			addSequential(new CommandeRouesAvancer(5350));
		}
		else // 2 CUBES
		{
			// SCALE GAUCHE
			addSequential(new CommandeRouesAvancer(5350));
			addSequential(new CommandeRouesTourner(-90));
			addSequential(new CommandeRouesAvancer(4850));
			addParallel(new CommandeChariotActiverHautAvant());
			addParallel(new CommandeBrasAllonger());
			addSequential(new CommandeRouesTourner(90));
			addSequential(new CommandeRouesAvancer(1250));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.450));
			addSequential(new CommandePinceFermer());
			addParallel(new CommandeBrasRetrecir());
			
			// SWITCH GAUCHE
			addSequential(new CommandeRouesTourner(-3));
			addSequential(new CommandeChariotActiverBasArriere());
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandeRouesAvancer(-1500));
			addSequential(new CommandePinceFermer());
			addSequential(new CommandePause(0.350));
			addSequential(new CommandeChariotActiverMilieuArriere());
			addSequential(new CommandePause(0.700));
			addSequential(new CommandeRouesAvancer(-200));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.450));
			addSequential(new CommandePinceFermer());
		}		
	
		//addParallel(new CommandeChariotActiverHome());
	}
	
	protected void initialize(){
		System.out.println("Trajet3GGG");
	}
		
}
