package org.firstchampionship.equipe5910.robot2018.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto3GGG extends CommandGroup{
	
	public TrajetAuto3GGG()
	{
		
	}
	
	protected void initialize(){
		System.out.println("Trajet3GGG");
		SmartDashboard.putString("Trajet", "3GGG");
	}
		
}
