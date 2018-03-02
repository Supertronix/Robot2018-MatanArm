package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.I2C;

public class AnimateurLedI2c {
	
	protected I2C lienLed;
	protected byte[] message = new byte[1];
	protected byte[] vide = new byte[1];

	public static byte[] ALLIANCE_ROUGE = new byte[1];
	public static byte[] ALLIANCE_BLEUE = new byte[1];
	protected static byte[] MESSAGE_TELEOP = new byte[1];
	protected static byte[] MESSAGE_AUTONOME = new byte[1];
	protected static byte[] MESSAGE_FLASH = new byte[1];
	protected static byte[] MESSAGE_NIVEAU = new byte[1];
	public static byte[] niveauChariot = new byte[1];
	
	private AnimateurLedI2c()
	{
		lienLed = new I2C(I2C.Port.kOnboard,4);
		ALLIANCE_ROUGE[0] = 'R';
		ALLIANCE_BLEUE[0] = 'B';
		MESSAGE_TELEOP[0] = 'T';
		MESSAGE_AUTONOME[0] = 'A';
		MESSAGE_FLASH[0] = 'F';
		MESSAGE_NIVEAU[0] = 'N';
	}
	static protected AnimateurLedI2c instance = null;
	static public AnimateurLedI2c getInstance()
	{
		if(instance == null) instance = new AnimateurLedI2c();
		return instance;
	}
	
	public void indiquerAlliance(byte[] alliance)
	{
	    lienLed.transaction(alliance, 1,vide,0);
	}
	public void indiquerNiveau(short niveau)
	{
		niveauChariot[0] = (byte)niveau;
	    lienLed.transaction(niveauChariot, 1,vide,0);		
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
	    lienLed.transaction(MESSAGE_AUTONOME, 1,vide,0);		
	}
	public void lancerSpectacleTeleop()
	{
	    lienLed.transaction(MESSAGE_TELEOP, 1,vide,0);				
	}
	public void lancerSpectacleNiveau()
	{
	    lienLed.transaction(MESSAGE_NIVEAU, 1,vide,0);
	}

}