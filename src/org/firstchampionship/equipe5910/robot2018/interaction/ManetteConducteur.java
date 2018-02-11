package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesActiverVitesseBasse;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesActiverVitesseElevee;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ManetteConducteur implements RobotMap.ManetteConducteur{
	
	Joystick manettePrincipale;
	
	JoystickButton selecteurVitesseElevee;
	JoystickButton selecteurVitesseBasse;
	
	public ManetteConducteur(){
		manettePrincipale = new Joystick(MANETTE_CONDUCTEUR);
		selecteurVitesseElevee = new JoystickButton(manettePrincipale, BOUTON_A);
		selecteurVitesseBasse = new JoystickButton(manettePrincipale, BOUTON_X);
		selecteurVitesseElevee.whenPressed(new CommandeRouesActiverVitesseElevee());
		selecteurVitesseBasse.whenPressed(new CommandeRouesActiverVitesseBasse());
	}
	
	public double getAvancer(){
		// System.out.println("getAvancer()" + manettePrincipale.getRawAxis(GACHETTE_DROITE) );
		return manettePrincipale.getRawAxis(GACHETTE_DROITE);
	}
	
	public double getReculer(){
		return manettePrincipale.getRawAxis(GACHETTE_GAUCHE);
	}
	
	public double getTournerSurPlace(){
		return manettePrincipale.getRawAxis(0);
	}
	
	public double getdirection(){
		return manettePrincipale.getRawAxis(0);
	}
	
	public boolean veuxAvancer(){
		return manettePrincipale.getRawAxis(GACHETTE_DROITE) > manettePrincipale.getRawAxis(GACHETTE_GAUCHE);
	}
	
	public boolean veuxReculer(){
		return  manettePrincipale.getRawAxis(GACHETTE_GAUCHE) > manettePrincipale.getRawAxis(GACHETTE_DROITE);
	}
	
	public boolean veuxTournerSurPlace(){
		return manettePrincipale.getRawAxis(0) != 0;
	}
	
}
