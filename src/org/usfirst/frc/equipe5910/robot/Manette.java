package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Manette implements RobotMap.Manette{
	
	Joystick manettePrincipale;
	
	JoystickButton selecteurVitesseElevee;
	JoystickButton selecteurVitesseBasse;
	
	public Manette(){
		manettePrincipale = new Joystick(MANETTE_PRINCIPALE);
		selecteurVitesseElevee = new JoystickButton(manettePrincipale, BOUTON_A);
		selecteurVitesseBasse = new JoystickButton(manettePrincipale, BOUTON_X);
		selecteurVitesseElevee.whenPressed(new CommandeActiverVitesseElevee());
		selecteurVitesseBasse.whenPressed(new CommandeActiverVitesseBasse());
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
