package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.outil.Calculateur;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chariot extends Subsystem implements RobotMap.Chariot
{
	TalonSRX chariotMoteurPrincipal = new TalonSRX(CHARIOT_MOTEUR_PRINCIPAL);
	TalonSRX chariotMoteurEsclave = new TalonSRX(CHARIOT_MOTEUR_ESCLAVE);

	public Chariot(){
		chariotMoteurPrincipal.setNeutralMode(NeutralMode.Brake);
		chariotMoteurPrincipal.setInverted(RobotMap.Chariot.CHARIOT_MOTEUR_PRINCIPAL_INVERSION);
		//chariotMoteurPrincipal.set(ControlMode., arg1);
		
		//Configure Talon to clear sensor position on Forward Limit
		//chariotMoteurPrincipal.configSetParameter(ParamEnum.eClearPositionOnLimitF, 1, 0, 0, 10);
		
		chariotMoteurEsclave.setNeutralMode(NeutralMode.Brake);
		chariotMoteurEsclave.set(ControlMode.Follower, chariotMoteurPrincipal.getDeviceID());
		chariotMoteurEsclave.setInverted(RobotMap.Chariot.CHARIOT_MOTEUR_ESCLAVE_INVERSION);
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
	
	public void manualControl(double value)
	{
		double clampedValue = Calculateur.clamp(value, -1, 1);
		chariotMoteurPrincipal.set(ControlMode.PercentOutput, clampedValue);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}
