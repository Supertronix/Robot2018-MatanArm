package org.firstchampionship.equipe5910.robot2018.soussysteme;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pince extends Subsystem implements RobotMap.Pince
{	
	protected DoubleSolenoid selecteurOuverture;

	public Pince()
	{
		this.selecteurOuverture = new DoubleSolenoid(PINCE_FERMEE, PINCE_OUVERTE);
	}
	
	public void ouvrir()
	{
		this.selecteurOuverture.set(DoubleSolenoid.Value.kForward);	
	}
	
	public void fermer()
	{
		this.selecteurOuverture.set(DoubleSolenoid.Value.kReverse);
	}

	@Override
	protected void initDefaultCommand() { }

}
