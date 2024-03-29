package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Constants;
import org.firstchampionship.equipe5910.robot2018.outil.Calculateur;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chariot extends Subsystem implements RobotMap.Chariot
{
	protected TalonSRX chariotMoteurPrincipal = new TalonSRX(CHARIOT_MOTEUR_PRINCIPAL);
	protected TalonSRX chariotMoteurEsclave = new TalonSRX(CHARIOT_MOTEUR_ESCLAVE);
	
	public Chariot()
	{
		SmartDashboard.putNumber("Chariot_SP", 0);
		chariotMoteurPrincipal.setNeutralMode(NeutralMode.Brake);
		chariotMoteurPrincipal.setInverted(RobotMap.Chariot.CHARIOT_MOTEUR_PRINCIPAL_INVERSION);
		chariotMoteurPrincipal.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.kTimeoutMs);
		chariotMoteurPrincipal.configAllowableClosedloopError(0, 0, Constants.kTimeoutMs);
		chariotMoteurPrincipal.setSensorPhase(RobotMap.Chariot.CHARIOT_SENSOR_ENCODEUR_INVERSION);
		chariotMoteurPrincipal.config_kP(0, CHARIOT_PID_KP, Constants.kTimeoutMs);
		
		//Configure Talon to clear sensor position on Reverse Limit only
		chariotMoteurPrincipal.configSetParameter(ParamEnum.eClearPositionOnLimitR, 1, 0, 0, Constants.kTimeoutMs);
		chariotMoteurPrincipal.configSetParameter(ParamEnum.eClearPositionOnLimitF, 0, 0, 0, Constants.kTimeoutMs);
		chariotMoteurEsclave.setNeutralMode(NeutralMode.Brake);
		chariotMoteurEsclave.set(ControlMode.Follower, chariotMoteurPrincipal.getDeviceID());
		chariotMoteurEsclave.setInverted(RobotMap.Chariot.CHARIOT_MOTEUR_ESCLAVE_INVERSION);
	}
	
	public void allerPosition(RobotMap.Chariot.POSITION pos)
	{
		
		 switch (pos) {
		 case BAS:
			 chariotMoteurPrincipal.set(ControlMode.Position, Chariot.CHARIOT_POSITION_BAS);
			 break;
		 case MILIEU:
			 chariotMoteurPrincipal.set(ControlMode.Position, Chariot.CHARIOT_POSITION_MILIEU);
			 break; 
		 case HAUT:
			 chariotMoteurPrincipal.set(ControlMode.Position, Chariot.CHARIOT_POSITION_HAUT);
			 break; 
		default:
			break;
	 }
	}
		 
	
	public void positionner(double value)
	{
		double clampedValue = Calculateur.clamp(value, -1, 1);
		chariotMoteurPrincipal.set(ControlMode.PercentOutput, clampedValue);
		SmartDashboard.putNumber("Chariot_Encoder_value", chariotMoteurPrincipal.getSensorCollection().getQuadraturePosition());
		//chariotMoteurPrincipal.set(ControlMode.Position, SmartDashboard.getNumber("Chariot_SP", 0));
	}
	
	public void incrementerPID()
	{	
		double value = Calculateur.clamp(chariotMoteurPrincipal.getClosedLoopTarget(0) + 100, RobotMap.Chariot.CHARIOT_POSITION_BAS, RobotMap.Chariot.CHARIOT_POSITION_HAUT);
		chariotMoteurPrincipal.set(ControlMode.Position, value);
	}
	public void decrementerPID()
	{	
		double value = Calculateur.clamp(chariotMoteurPrincipal.getClosedLoopTarget(0) - 100, RobotMap.Chariot.CHARIOT_POSITION_BAS, RobotMap.Chariot.CHARIOT_POSITION_HAUT);
		chariotMoteurPrincipal.set(ControlMode.Position, value);
	}
	
	public void ajusterPID(double value)
	{	
		value = Calculateur.clamp(chariotMoteurPrincipal.getClosedLoopTarget(0) + value *500, RobotMap.Chariot.CHARIOT_POSITION_BAS, RobotMap.Chariot.CHARIOT_POSITION_HAUT);
		chariotMoteurPrincipal.set(ControlMode.Position, value);
	}
	
	public double getPosition()
	{	
		return chariotMoteurPrincipal.getSensorCollection().getQuadraturePosition();
	}
	
	@Override
	protected void initDefaultCommand() { }
}
