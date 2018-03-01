package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.I2C;

public class AnimateurLed {
	
	protected I2C lienLed;
	protected byte[] message = new byte[1];
	protected byte[] vide = new byte[1];

	public static byte[] ALLIANCE_ROUGE = new byte[1];
	public static byte[] ALLIANCE_BLEUE = new byte[1];

	
	private AnimateurLed()
	{
		lienLed = new I2C(I2C.Port.kOnboard,4);
		ALLIANCE_ROUGE[0] = 'R';
		ALLIANCE_BLEUE[0] = 'B';
	}
	static protected AnimateurLed instance = null;
	static public AnimateurLed getInstance()
	{
		if(instance == null) instance = new AnimateurLed();
		return instance;
	}
	
	public void indiquerAlliance(byte[] alliance)
	{
	    lienLed.transaction(alliance, 1,vide,0);
	}
	public void indiquerNiveau(int niveau)
	{
		
	}
	public void lancerSpectacleFlash()
	{
		
	}
	public void lancerSpectacleAutonome()
	{
		
	}
	public void lancerSpectacleTeleop()
	{
		
	}
	public void lancerSpectacleNiveau()
	{
	}

}