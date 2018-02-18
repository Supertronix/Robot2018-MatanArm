package org.firstchampionship.equipe5910.robot2018.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto3DDD extends CommandGroup{
	
	public TrajetAuto3DDD()
	{
		
	}
	
	protected void initialize(){
		System.out.println("Trajet3DDD");
		SmartDashboard.putString("Trajet", "3DDD");
	}
		
}
