package org.firstchampionship.equipe5910.robot2018.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrajetAuto2DGD extends CommandGroup{
	
	public TrajetAuto2DGD()
	{
		
	}
	
	protected void initialize(){
		System.out.println("Trajet2DGD");
		SmartDashboard.putString("Trajet", "1GGG");
	}
		
}
