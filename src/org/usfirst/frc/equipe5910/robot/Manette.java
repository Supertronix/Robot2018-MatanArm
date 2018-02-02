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
	
	public double getAvancer(){
		System.out.println("getAvancer()" + manettePrincipale.getRawAxis(3) );
		return manettePrincipale.getRawAxis(3);
	}
	
	public double getReculer(){
		return manettePrincipale.getRawAxis(2);
	}
	
	public boolean veuxAvancer(){
		return manettePrincipale.getRawAxis(3) > manettePrincipale.getRawAxis(2);
	}
	
	public boolean veuxReculer(){
		return  manettePrincipale.getRawAxis(2) > manettePrincipale.getRawAxis(3);
	}
	
}
