package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LecteurAttributionsAutonomes {

	public enum Cote {GAUCHE, DROIT}
	
	public class Attribution
	{
		public Cote premier;
		public Cote second;
		public Cote troisieme;
	}
			
	public Cote convertirLettreEnCote(char lettre)
	{
		switch(lettre)
		{
			case 'L': return Cote.GAUCHE;
			case 'R': return Cote.DROIT;
		}
		return null;
	}
	
	public Attribution lire()
	{
		Attribution attribution = new Attribution();

		String message = DriverStation.getInstance().getGameSpecificMessage();
		//System.out.println("Message : " + message);
		SmartDashboard.putString("Attribution de plates : ", message);
		
		if(message.length() > 0)
		{
			attribution.premier = convertirLettreEnCote(message.charAt(0));
			attribution.second = convertirLettreEnCote(message.charAt(1));
			attribution.troisieme = convertirLettreEnCote(message.charAt(2));
			
			System.out.println("premier : " + attribution.premier);
			System.out.println("second : " + attribution.second);
			System.out.println("troisieme : " + attribution.troisieme);			
		}
		return attribution;
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
