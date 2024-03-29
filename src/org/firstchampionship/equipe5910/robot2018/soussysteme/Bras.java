package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.RobotMap.Constants;
import org.firstchampionship.equipe5910.robot2018.outil.Calculateur;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Bras extends Subsystem implements RobotMap.Bras
{	
	
	protected TalonSRX brasMoteurPrincipal = new TalonSRX(BRAS_MOTEUR_PRINCIPAL);
	protected TalonSRX brasMoteurEsclave = new TalonSRX(BRAS_MOTEUR_ESCLAVE);
		
	protected DoubleSolenoid selecteurExtension;
	
	public Bras()
	{		
		brasMoteurPrincipal.setNeutralMode(NeutralMode.Brake);
		brasMoteurPrincipal.setInverted(RobotMap.Bras.BRAS_MOTEUR_PRINCIPAL_INVERSION);
		brasMoteurPrincipal.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, Constants.kTimeoutMs);
		brasMoteurPrincipal.configAllowableClosedloopError(0, 0, Constants.kTimeoutMs);

		brasMoteurPrincipal.config_kP(0, BRAS_PID_KP, Constants.kTimeoutMs); //config_kP(int slotIdx, double value, int timeoutMs) 
		brasMoteurPrincipal.config_kI(0, BRAS_PID_KI, Constants.kTimeoutMs);
		
		brasMoteurPrincipal.setSensorPhase(RobotMap.Bras.BRAS_SENSOR_POTENTIOMETRE_INVERSION);
		
		brasMoteurPrincipal.configForwardSoftLimitEnable(true, Constants.kTimeoutMs);
		brasMoteurPrincipal.configReverseSoftLimitEnable(true, Constants.kTimeoutMs);
		brasMoteurPrincipal.configForwardSoftLimitThreshold(BRAS_LIMITE_AVANT, Constants.kTimeoutMs);
		brasMoteurPrincipal.configReverseSoftLimitThreshold(BRAS_LIMITE_ARRIERE, Constants.kTimeoutMs);
		
		brasMoteurEsclave.setNeutralMode(NeutralMode.Brake);
		brasMoteurEsclave.set(ControlMode.Follower, brasMoteurPrincipal.getDeviceID());
		brasMoteurEsclave.setInverted(RobotMap.Bras.BRAS_MOTEUR_ESCLAVE_INVERSION);
		
		this.selecteurExtension = new DoubleSolenoid(BRAS_RETRECI, BRAS_ALLONGE);
		this.retrecir();
		allerPosition(RobotMap.Bras.POSITION.HOME);
		SmartDashboard.putNumber("BrasKP", BRAS_PID_KP);
		SmartDashboard.putNumber("BrasKI", BRAS_PID_KI);
	}
	
	public void allonger()
	{
		this.selecteurExtension.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retrecir()
	{
		this.selecteurExtension.set(DoubleSolenoid.Value.kReverse);		
	}
 
	public double getPosition()
	{
		return brasMoteurPrincipal.getSensorCollection().getAnalogIn();
	}
	public void allerPosition(RobotMap.Bras.POSITION pos)
	{
		
		 switch (pos) {
		 case AVANT_BAS:
			 brasMoteurPrincipal.set(ControlMode.Position, Bras.BRAS_POSITION_AVANT_BAS);
			 break;
		 case HOME:
			 brasMoteurPrincipal.set(ControlMode.Position, Bras.BRAS_POSITION_HOME);
			 break; 
		 case ARRIERE_BAS:
			 brasMoteurPrincipal.set(ControlMode.Position, Bras.BRAS_POSITION_ARRIERE_BAS);
			 break; 
		 case AVANT_HAUT:
			 brasMoteurPrincipal.set(ControlMode.Position, Bras.BRAS_POSITION_AVANT_HAUT);
			 break; 
		 case ARRIERE_HAUT:
			 brasMoteurPrincipal.set(ControlMode.Position, Bras.BRAS_POSITION_ARRIERE_HAUT);
			 break; 
		 case AVANT_MILIEU:
			 brasMoteurPrincipal.set(ControlMode.Position, Bras.BRAS_POSITION_AVANT_MILIEU);
			 break; 
		 case ARRIERE_MILIEU:
			 brasMoteurPrincipal.set(ControlMode.Position, Bras.BRAS_POSITION_ARRIERE_MILIEU);
			 break; 
		default:
			break;
	 }
		 
	}
	
	public void positionner(double value)
	{
		double clampedValue = Calculateur.clamp(value, -1, 1);
		brasMoteurPrincipal.set(ControlMode.PercentOutput, clampedValue);
		SmartDashboard.putNumber("POTENTIOMETRE", brasMoteurPrincipal.getSensorCollection().getAnalogIn());
	}
	
	public void ajusterPID(double value)
	{	
		value = clampedPosition(brasMoteurPrincipal.getClosedLoopTarget(0) + value *4);
		//value = Calculateur.clamp(brasMoteurPrincipal.getClosedLoopTarget(0) + value *4, RobotMap.Bras.BRAS_LIMITE_ARRIERE, RobotMap.Bras.BRAS_LIMITE_AVANT);
		brasMoteurPrincipal.set(ControlMode.Position, value);
		
		//brasMoteurPrincipal.config_kP(0, SmartDashboard.getNumber("BrasKP", BRAS_PID_KP), Constants.kTimeoutMs); //config_kP(int slotIdx, double value, int timeoutMs) 
		//brasMoteurPrincipal.config_kI(0, SmartDashboard.getNumber("BrasKI", BRAS_PID_KP), Constants.kTimeoutMs);		
	}
	
	public void setPositionPIDmanuel(double value)
	{	
		brasMoteurPrincipal.set(ControlMode.Position, clampedPosition(value));
	}
	
	public double clampedPosition(double value)
	{
		if (this.selecteurExtension.get() == DoubleSolenoid.Value.kForward) // ALLONGE
		{
			return Calculateur.clamp(value, BRAS_LIMITE_ARRIERE_ALLONGE, BRAS_LIMITE_AVANT_ALLONGE);
		}
		else // RETRECI
		{
			return Calculateur.clamp(value, BRAS_LIMITE_ARRIERE, BRAS_LIMITE_AVANT);
		}
	}
	
	public boolean isInExtendedLimits()
	{
		double actualPosition = this.getPosition();
		return (actualPosition > 394 && actualPosition < 672);
	}
	
	@Override
	protected void initDefaultCommand() { }
	
	
}
