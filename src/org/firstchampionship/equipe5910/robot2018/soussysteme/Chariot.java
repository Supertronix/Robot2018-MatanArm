package org.firstchampionship.equipe5910.robot2018.soussysteme;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chariot extends Subsystem
{

	public Chariot(){
		
	}
	
	public void positionnerHautAvant(){
		System.out.println("Chariot => positionnerHautAvant");
	}
	
	public void positionnerHautArriere(){
		System.out.println("Chariot => positionnerHautArriere");
	}
	
	public void positionnerMilieuAvant(){
		System.out.println("Chariot => positionnerMilieuAvant");
	}
	
	public void positionnerMilieuArriere(){
		System.out.println("Chariot => positionnerMilieuArriere");
	}
	
	public void positionnerBasAvant(){
		System.out.println("Chariot => positionnerBasAvant");
	}
	
	public void positionnerBasArriere(){
		System.out.println("Chariot => positionnerBasArriere");
	}
	
	public void positionnerCentre(){
		System.out.println("Chariot => positionnerCentre");
	}
	
	public void Ouvrir(){
		System.out.println("Chariot => Ouvrir");
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}
