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
	
	protected Attribution attribution = null;

	public Attribution lire()
	{
		
		String message = DriverStation.getInstance().getGameSpecificMessage();
		//System.out.println("Message : " + message);
		SmartDashboard.putString("Attribution de plates : ", message);
		
		if(message.length() > 0)
		{
			this.attribution = new Attribution();
			this.attribution.premier = convertirLettreEnCote(message.charAt(0));
			this.attribution.second = convertirLettreEnCote(message.charAt(1));
			this.attribution.troisieme = convertirLettreEnCote(message.charAt(2));
			
			System.out.println("Premier cote : " + this.attribution.premier);
			System.out.println("Second cote: " + this.attribution.second);
			System.out.println("Troisieme cote : " + this.attribution.troisieme);			
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
