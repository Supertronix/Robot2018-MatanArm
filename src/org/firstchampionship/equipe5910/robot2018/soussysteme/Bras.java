package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.outil.Calculateur;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Bras extends Subsystem implements RobotMap.Bras
{	
	
	TalonSRX brasMoteurPrincipal = new TalonSRX(BRAS_MOTEUR_PRINCIPAL);
	TalonSRX brasMoteurEsclave = new TalonSRX(BRAS_MOTEUR_ESCLAVE);
	
	@Override
	protected void initDefaultCommand() { }
	
	protected DoubleSolenoid selecteurExtension;
	
	public Bras()
	{
		brasMoteurPrincipal.setNeutralMode(NeutralMode.Brake);
		brasMoteurPrincipal.setInverted(RobotMap.Bras.BRAS_MOTEUR_PRINCIPAL_INVERSION);
		//200 et 870
		brasMoteurPrincipal.setSensorPhase(RobotMap.Bras.BRAS_SENSOR_POTENTIOMETRE_INVERSION);
		
		brasMoteurPrincipal.configForwardSoftLimitEnable(false, 0);
		//brasMoteurPrincipal.configReverseSoftLimitEnable(true, 200);
		brasMoteurPrincipal.configReverseSoftLimitEnable(false,0);
		
		
		//brasMoteurPrincipal.configSelectedFeedbackSensor(FeedbackDevice.Analog, );
		brasMoteurEsclave.setNeutralMode(NeutralMode.Brake);
		brasMoteurEsclave.set(ControlMode.Follower, brasMoteurPrincipal.getDeviceID());
		brasMoteurEsclave.setInverted(RobotMap.Bras.BRAS_MOTEUR_ESCLAVE_INVERSION);
		
		this.selecteurExtension = new DoubleSolenoid(BRAS_RETRECI, BRAS_ALLONGE);
		this.retrecir();
	}
	
	public void allonger()
	{
		this.selecteurExtension.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retrecir()
	{
		this.selecteurExtension.set(DoubleSolenoid.Value.kReverse);		
	}
	
	public void manualControl(double value)
	{
		double clampedValue = Calculateur.clamp(value, -1, 1);
		brasMoteurPrincipal.set(ControlMode.PercentOutput, clampedValue);
		SmartDashboard.putNumber("POTENTIOMETRE", brasMoteurPrincipal.getSensorCollection().getAnalogIn());
	}
}
