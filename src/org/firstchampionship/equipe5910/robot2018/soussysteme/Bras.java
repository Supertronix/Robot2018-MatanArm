package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Bras implements RobotMap.Bras
{	
	protected DoubleSolenoid selecteurExtension;
	
	public Bras()
	{
		this.selecteurExtension = new DoubleSolenoid(BRAS_EXTENSION_MIN, BRAS_EXTENSION_MAX);
	}
	
	public void allonger()
	{
		this.selecteurExtension.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retrecir()
	{
		this.selecteurExtension.set(DoubleSolenoid.Value.kReverse);		
	}
}
