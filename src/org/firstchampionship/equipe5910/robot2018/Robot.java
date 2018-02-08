package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.soussysteme.Chariot;
import org.firstchampionship.equipe5910.robot2018.soussysteme.Roues;

public class Robot {
	
	public static Roues roues;
	public static Chariot chariot;
	
	
	public static void construire()
	{
		roues = new Roues();
		chariot = new Chariot();
	}

}
