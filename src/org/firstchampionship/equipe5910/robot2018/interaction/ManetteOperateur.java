package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverBasArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverBasAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverCentre;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHautArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverHautAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuArriere;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotActiverMilieuAvant;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeChariotOuvrir;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ManetteOperateur implements RobotMap.ManetteOperateur{
	
	Joystick manetteOperateur;
	
	JoystickButton hautAvant;
	JoystickButton hautArriere;
	JoystickButton milieuAvant;
	JoystickButton milieuArriere;
	JoystickButton basAvant;
	JoystickButton basArriere;
	JoystickButton centre;
	JoystickButton ouvrir;
	
	public ManetteOperateur(){
		manetteOperateur = new Joystick(MANETTE_OPERATEUR);
		hautAvant = new JoystickButton(manetteOperateur, BOUTON_HAUT_AVANT);
		hautArriere = new JoystickButton(manetteOperateur, BOUTON_HAUT_ARRIERE);
		milieuAvant = new JoystickButton(manetteOperateur, BOUTON_MILIEU_AVANT);
		milieuArriere = new JoystickButton(manetteOperateur, BOUTON_MILIEU_ARRIERE);
		basAvant = new JoystickButton(manetteOperateur, BOUTON_BAS_AVANT);
		basArriere = new JoystickButton(manetteOperateur, BOUTON_BAS_ARRIERE);
		centre = new JoystickButton(manetteOperateur, BOUTON_CENTRE);
		ouvrir = new JoystickButton(manetteOperateur, BOUTON_OUVRIR);
		
		hautAvant.whenPressed(new CommandeChariotActiverHautAvant());
		hautArriere.whenPressed(new CommandeChariotActiverHautArriere());
		milieuAvant.whenPressed(new CommandeChariotActiverMilieuAvant());
		milieuArriere.whenPressed(new CommandeChariotActiverMilieuArriere());
		basAvant.whenPressed(new CommandeChariotActiverBasAvant());
		basArriere.whenPressed(new CommandeChariotActiverBasArriere());
		centre.whenPressed(new CommandeChariotActiverCentre());
		ouvrir.whenPressed(new CommandeChariotOuvrir());
		
	}
}
