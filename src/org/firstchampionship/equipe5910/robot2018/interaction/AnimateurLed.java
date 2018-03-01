package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.I2C;

public class AnimateurLed {
	
	protected I2C lienLed;
	protected byte[] message = new byte[1];
	protected byte[] vide = new byte[1];

	public static byte[] ALLIANCE_ROUGE = new byte[1];
	public static byte[] ALLIANCE_BLEUE = new byte[1];
	protected static byte[] MESSAGE_TELEOP = new byte[1];
	protected static byte[] MESSAGE_FLASH = new byte[1];
	
	private AnimateurLed()
	{
		lienLed = new I2C(I2C.Port.kOnboard,4);
		ALLIANCE_ROUGE[0] = 'R';
		ALLIANCE_BLEUE[0] = 'B';
		MESSAGE_TELEOP[0] = 'T';
		MESSAGE_FLASH[0] = 'F';
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
	    lienLed.transaction(MESSAGE_FLASH, 1,vide,0);
	}
	public void arreterSpectacleFlash()
	{
		this.lancerSpectacleTeleop();
	}
	public void lancerSpectacleAutonome()
	{
		
	}
	public void lancerSpectacleTeleop()
	{
	    lienLed.transaction(MESSAGE_TELEOP, 1,vide,0);				
	}
	public void lancerSpectacleNiveau()
	{
	}

}