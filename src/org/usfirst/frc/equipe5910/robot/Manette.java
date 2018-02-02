package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Manette {
	
	Joystick manettePrincipale;
	
	JoystickButton selecteurVitesse;
	
	public Manette(){
		manettePrincipale = new Joystick(0);
		selecteurVitesse = new JoystickButton(manettePrincipale, 2);
		selecteurVitesse.whenPressed(new CommandeActiverVitesseElevee());
		selecteurVitesse.whenReleased(new CommandeActeverVitesseBasse());
	}
	
	public double getConduiteGauche(){
		return manettePrincipale.getRawAxis(1);
	}

	public double getConduiteDroite(){
		return -manettePrincipale.getRawAxis(5);
	}
}
