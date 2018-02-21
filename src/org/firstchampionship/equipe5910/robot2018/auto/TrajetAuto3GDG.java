package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasAllonger;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasPIDSet;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasRetrecir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverBasArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHome;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHautAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePause;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceOuvrir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancerAngle;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;
import org.firstchampionship.equipe5910.robot2018.interaction.SelecteurNombreCubes;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto3GDG extends CommandGroup{
	
	public TrajetAuto3GDG()
	{
		
		if(!SelecteurNombreCubes.getInstance().viseDeuxCube()) // MODE 1 CUBE
		{
			//SCALE DROIT
			addSequential(new CommandeRouesAvancer(5000));
			addParallel(new CommandeChariotActiverHautAvant());
			addParallel(new CommandeBrasAllonger());
			addSequential(new CommandeRouesAvancerAngle(1000, -45));
			addSequential(new CommandeRouesAvancerAngle(750, 45));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.450));
			addSequential(new CommandePinceFermer());
			addParallel(new CommandeBrasRetrecir());
			addParallel(new CommandeChariotActiverHome());
		}
		else // MODE 2 CUBES
		{
			// SCALE DROIT
			addSequential(new CommandeRouesAvancer(5000));
			addParallel(new CommandeChariotActiverHautAvant());
			addParallel(new CommandeBrasAllonger());
			addSequential(new CommandeRouesAvancerAngle(1000, -45));
			addSequential(new CommandeRouesAvancerAngle(750, 45));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.450));
			addSequential(new CommandePinceFermer());
			addParallel(new CommandeBrasRetrecir());
			addParallel(new CommandeChariotActiverHome());
			
			// SCALE DROIT
			addSequential(new CommandeRouesTourner(16.5));
			addSequential(new CommandeChariotActiverBasArriere());
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandeRouesAvancer(-1500));
			addSequential(new CommandePinceFermer());
			addSequential(new CommandePause(0.350));
			addParallel(new CommandeChariotActiverHautAvant());
			addSequential(new CommandeRouesAvancer(1400));
			addParallel(new CommandeBrasAllonger());
			addParallel(new CommandeRouesTourner(-5));
			addSequential(new CommandePause(0.500));
			addSequential(new CommandePinceOuvrir());
			addSequential(new CommandePause(0.450));
			//addSequential(new CommandePinceFermer());
			//addParallel(new CommandeBrasRetrecir());
			//addSequential(new CommandeChariotActiverHome());
		}
		
	}
	
	protected void initialize(){
		System.out.println("Trajet3GDG");
		SmartDashboard.putString("Trajet", "3GDG");
	}
		
}
