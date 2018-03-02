package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.outil.Calculateur;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AnimateurLed {
	
	public static class LecteurAttributionAlliance
	{
		public static final boolean ALLIANCE_ROUGE = true;
		public static final boolean ALLIANCE_BLEUE = false;
		public static boolean lire()
		{
			//System.out.println("Alliance " + DriverStation.getInstance().getAlliance().name());
			return (DriverStation.getInstance().getAlliance().name().compareTo("Red") == 0); 
		}		
	}
	
	protected DigitalOutput indicateurAlliance;
	protected DigitalOutput indicateurFlash;
	//protected AnalogOutput indicateurChariot;
	
	public static int INDICATEUR_ALLIANCE = 0;
	public static int INDICATEUR_FLASH = 1;
	public static int INDICATEUR_CHARIOT = 0;
	
	public static boolean MESSAGE_FLASH = true;	
	//public static boolean MESSAGE_AUTONOME = true;
	//public static boolean MESSAGE_TELEOP = false;
	//public static boolean MESSAGE_NIVEAU = true;
	
	private AnimateurLed()
	{
		this.indicateurAlliance = new DigitalOutput(INDICATEUR_ALLIANCE);
		this.indicateurFlash = new DigitalOutput(INDICATEUR_FLASH);
		//this.indicateurChariot = new AnalogOutput(INDICATEUR_CHARIOT);
	}
	static protected AnimateurLed instance = null;
	static public AnimateurLed getInstance()
	{
		if(instance == null) instance = new AnimateurLed();
		return instance;
	}
	public void indiquerAlliance()
	{
		this.indicateurAlliance.set(LecteurAttributionAlliance.lire());
	}
	public void indiquerAlliance(boolean alliance)
	{
		System.out.println("Messager alliance " + alliance);
		this.indicateurAlliance.set(alliance);
	}
	public void indiquerNiveau(short niveau)
	{
		//this.indicateurChariot.setVoltage(Calculateur.clamp(niveau*0.05, 0,5));
	}
	public void lancerSpectacleFlash()
	{
		System.out.println("lancerSpectacleFlash()");
		this.indicateurFlash.set(true);
	}
	public void arreterSpectacleFlash()
	{
		System.out.println("arreterSpectacleFlash()");
		this.indicateurFlash.set(false);
	}
	/*
	public void lancerSpectacleAutonome()
	{
		// deduit cote Arduino selon position chariot
	}
	public void lancerSpectacleTeleop()
	{
		// deduit cote Arduino selon temps 15 secondes depuis passage mode autonome
	}
	public void lancerSpectacleNiveau()
	{
		// deduit cote Arduino selon position chariot + temps
	}*/	
	
	//////////////////////////////////////////////////////
	
	
	static public class CommandeLedActiverFlash extends Command {
		
		@Override
		protected void initialize() {
			System.out.println("CommandeLedActiverFlash.initialize()");
		}
		
		@Override
		protected void execute() {
			AnimateurLed.getInstance().lancerSpectacleFlash();
		}
		
		@Override
		protected boolean isFinished() {
			return true;
		}
	}

	static public class CommandeLedEteindreFlash extends Command {
		
		@Override
		protected void initialize() {
			System.out.println("CommandeLedEteindreFlash.initialize()");
		}
		
		@Override
		protected void execute() {
			AnimateurLed.getInstance().arreterSpectacleFlash();	
		}
		
		@Override
		protected boolean isFinished() {
			return true;
		}
	}
	
	
}