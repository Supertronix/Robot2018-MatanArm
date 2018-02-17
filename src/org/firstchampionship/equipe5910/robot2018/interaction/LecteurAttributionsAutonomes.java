package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.DriverStation;

public class LecteurAttributionsAutonomes {
					
	public void lire()
	{
		String message = DriverStation.getInstance().getGameSpecificMessage();
		System.out.println("Message : " + message);
		
		if(message.length() > 0)
		{
			char premier = message.charAt(0);
			char second = message.charAt(1);
			char troisieme = message.charAt(2);
			
			System.out.println("premier : " + premier);
			System.out.println("second : " + second);
			System.out.println("troisieme : " + troisieme);			
		}
		
	}
	
	/*public void vider()
	{
		String message;
		do
		{
			message = DriverStation.getInstance().getGameSpecificMessage();
		}
		while(message.length() > 0);		
	}*/
}
