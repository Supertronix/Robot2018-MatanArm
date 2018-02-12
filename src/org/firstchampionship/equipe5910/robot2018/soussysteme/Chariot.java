package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chariot extends Subsystem implements RobotMap.Chariot
{
	public static final int CHARIOT_MOTEUR_PRINCIPAL = 3;
	public static final int CHARIOT_MOTEUR_ESCLAVE = 0;
	TalonSRX chariotMoteurPrincipal = new TalonSRX(CHARIOT_MOTEUR_PRINCIPAL);
	TalonSRX chariotMoteurEsclave = new TalonSRX(CHARIOT_MOTEUR_ESCLAVE);

	public Chariot(){
		// TODO  chariotMoteurEsclave.changeControlMode(CANTalon.TalonControlMode.Follower); chariotMoteurEsclave.set(chariotMoteurPrincipal.getDeviceID());		
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
