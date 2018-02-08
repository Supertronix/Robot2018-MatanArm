package org.firstchampionship.equipe5910.robot2018.outil;

public class Calculateur {
	public static double clamp(double val, double min, double max) 
	{
	    return Math.max(min, Math.min(max, val));
	}

}