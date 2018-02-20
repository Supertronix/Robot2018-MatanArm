package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHome;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePause;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceOuvrir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;
import org.firstchampionship.equipe5910.robot2018.interaction.SelecteurNombreCubes;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto3DGD extends CommandGroup{
	
	public TrajetAuto3DGD()
	{
		addParallel(new CommandeChariotActiverMilieuAvant());
		addSequential(new CommandeRouesAvancer(3600));
		addSequential(new CommandeRouesTourner(-90));
		addSequential(new CommandeRouesAvancer(175));
		addSequential(new CommandePinceOuvrir());
		addSequential(new CommandePause(0.350));
		addSequential(new CommandePinceFermer());
		addSequential(new CommandeChariotActiverHome());
		
		if(SelecteurNombreCubes.getInstance().viseDeuxCube())
		{
			
		}		
	}
	
	protected void initialize(){
		System.out.println("Trajet3DGD");
		SmartDashboard.putString("Trajet", "3DGD");
	}
		
}
