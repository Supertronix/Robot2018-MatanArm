package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.soussysteme.Bras;
import org.firstchampionship.equipe5910.robot2018.soussysteme.Chariot;
import org.firstchampionship.equipe5910.robot2018.soussysteme.Pince;
import org.firstchampionship.equipe5910.robot2018.soussysteme.Roues;
import org.firstchampionship.equipe5910.robot2018.soussysteme.RouesTankDrive;

public class Robot {
	
	public static RouesTankDrive roues;
	public static Chariot chariot;
	public static Pince pince;
	public static Bras bras;
	
	public static void construire()
	{
		roues = new RouesTankDrive();
		chariot = new Chariot();
		pince = new Pince();
		bras = new Bras();
	}
}
