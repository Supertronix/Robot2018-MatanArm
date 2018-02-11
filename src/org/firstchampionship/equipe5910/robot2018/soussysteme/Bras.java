package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Bras extends Subsystem implements RobotMap.Bras
{	
	@Override
	protected void initDefaultCommand() { }
	
	protected DoubleSolenoid selecteurExtension;
	
	public Bras()
	{
		this.selecteurExtension = new DoubleSolenoid(BRAS_RETRECI, BRAS_ALLONGE);
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
