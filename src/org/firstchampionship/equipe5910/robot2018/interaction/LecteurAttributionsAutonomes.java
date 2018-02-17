package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.DriverStation;

public class LecteurAttributionsAutonomes {
			
	public class Attribution
	{
		public char premier;
		public char second;
		public char troisieme;
	}
		
	Attribution attribution = new Attribution();
	//char attributions[] = new char[3];
		
	public void lire()
	{
		String message = DriverStation.getInstance().getGameSpecificMessage();
		System.out.println("Message : " + message);
		
		if(message.length() > 0)
		{
			attribution.premier = message.charAt(0);
			attribution.second = message.charAt(1);
			attribution.troisieme = message.charAt(2);
			
			System.out.println("premier : " + attribution.premier);
			System.out.println("second : " + attribution.second);
			System.out.println("troisieme : " + attribution.troisieme);			
		}
		
	}
	
	public void vider()
	{
		String message;
		do
		{
			message = DriverStation.getInstance().getGameSpecificMessage();
		}
		while(message.length() > 0);
		
	}
}
