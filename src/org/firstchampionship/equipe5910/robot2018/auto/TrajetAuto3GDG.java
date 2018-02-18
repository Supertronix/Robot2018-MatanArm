package org.firstchampionship.equipe5910.robot2018.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto3GDG extends CommandGroup{
	
	public TrajetAuto3GDG()
	{
		
	}
	
	protected void initialize(){
		System.out.println("Trajet3GDG");
		SmartDashboard.putString("Trajet", "3GDG");
	}
		
}
