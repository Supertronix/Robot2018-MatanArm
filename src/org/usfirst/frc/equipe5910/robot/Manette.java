package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Manette {
	
	Joystick roueGauche;
	Joystick roueDroite;
	
	public Manette(){
		roueGauche = new Joystick(0);
		roueDroite = new Joystick(0);
	}
	
	public double getConduiteGauche(){
		return roueGauche.getRawAxis(1);
	}

	public double getConduiteDroite(){
		return -roueDroite.getRawAxis(5);
	}
}
