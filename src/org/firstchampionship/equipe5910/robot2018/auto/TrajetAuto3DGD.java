package org.firstchampionship.equipe5910.robot2018.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto3DGD extends CommandGroup{
	
	public TrajetAuto3DGD()
	{
		
	}
	
	protected void initialize(){
		System.out.println("Trajet3DGD");
		SmartDashboard.putString("Trajet", "3DGD");
	}
		
}
