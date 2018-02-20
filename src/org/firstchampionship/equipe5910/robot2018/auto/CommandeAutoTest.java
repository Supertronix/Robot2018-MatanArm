package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasAllonger;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasRetrecir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverBasArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHome;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHautAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePause;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceOuvrir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancerAngle;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandeAutoTest extends CommandGroup {

public CommandeAutoTest() {
	
	
	/* CENTRE VERS SWITCH DROITE
 	addParallel(new CommandeChariotActiverMilieuAvant());
	addSequential(new CommandeRouesAvancerAngle(2250, 35));
	addSequential(new CommandeRouesAvancerAngle(725, -40));
	addSequential(new CommandePinceOuvrir());
	addSequential(new CommandePause(0.350));
	addSequential(new CommandePinceFermer());
	addSequential(new CommandeChariotActiverCentre());
	*/
	
	/* CENTRE VERS SWITCH GAUCHE 
	addParallel(new CommandeChariotActiverMilieuAvant());
	addSequential(new CommandeRouesAvancerAngle(2000, -35));
	addSequential(new CommandeRouesAvancerAngle(750, 40));
	addSequential(new CommandePinceOuvrir());
	addSequential(new CommandePause(0.350));
	addSequential(new CommandePinceFermer());
	addSequential(new CommandeChariotActiverCentre());
	*/
	
	/* DROITE VERS SWITH DROITE
	addParallel(new CommandeChariotActiverMilieuAvant());
	addSequential(new CommandeRouesAvancer(3600));
	addSequential(new CommandeRouesTourner(-90));
	addSequential(new CommandeRouesAvancer(175));
	addSequential(new CommandePinceOuvrir());
	addSequential(new CommandePause(0.350));
	addSequential(new CommandePinceFermer());
	addSequential(new CommandeChariotActiverCentre());
	*/
	
	/* DROITE VERS SCALE DROITE
	addSequential(new CommandeRouesAvancer(5000));
	addParallel(new CommandeChariotActiverHautAvant());
	addParallel(new CommandeBrasAllonger());
	addSequential(new CommandeRouesAvancerAngle(1000, -45));
	addSequential(new CommandeRouesAvancerAngle(750, 45));
	addSequential(new CommandePinceOuvrir());
	addSequential(new CommandePause(0.450));
	addSequential(new CommandePinceFermer());
	addParallel(new CommandeBrasRetrecir());
	addParallel(new CommandeChariotActiverCentre());
	addSequential(new CommandeRouesTourner(16.5));
	addSequential(new CommandeChariotActiverBasArriere());
	addSequential(new CommandePinceOuvrir());
	addSequential(new CommandeRouesAvancer(-1400));
	addSequential(new CommandePinceFermer());
	//addSequential(new CommandeChariotActiverMilieuArriere());
	
	*/
	
	/* GAUCHE VERS SCALE GAUCHE
	addSequential(new CommandeRouesAvancer(5000));
	//addParallel(new CommandeChariotActiverHautAvant());
	//addParallel(new CommandeBrasAllonger());
	addSequential(new CommandeRouesAvancerAngle(1000, 45));
	addSequential(new CommandeRouesAvancerAngle(750, -45));
	//addSequential(new CommandePinceOuvrir());
	//addSequential(new CommandePause(0.450));
	//addSequential(new CommandePinceFermer());
	*/

	// public CommandeConduiteDistance(double distance, double driveP, double driveI)
	// public CommandeConduiteTourner(double angle, double P, double I)
	/*addSequential(new CommandeConduiteAvancer(6.0, 0.08, 0.00065)); //5.7
	addSequential(new CommandeConduiteTourner(60, 0.008, 0.0002));
	addSequential(new CommandeConduiteAvancer(6.4, 0.08, 0.00065)); //6.7
	addSequential(new CommandeConduiteAvancer(-3.5, 0.14, 0.00045)); //0.16
	addSequential(new CommandeConduiteTourner(-150, 0.005, 0.00011));
	addSequential(new CommandeConduiteAvancer(5.5, 0.08, 0.00058));
	addSequential(new CommandeTourellePositionnerTilt(-520));
	addSequential(new CommandeTourelleChercherCibleAndHold(1));
	addParallel(new CommandeLanceurDuree(10));
	addParallel(new CommandeBrasseurDuree(10));
	addParallel(new CommandeIndexeurDuree(10));*/
	
}

}
