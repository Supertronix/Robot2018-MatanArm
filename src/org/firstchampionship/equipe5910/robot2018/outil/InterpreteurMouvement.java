package org.firstchampionship.equipe5910.robot2018.outil;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

public class InterpreteurMouvement implements RobotMap.InterpreteurMouvement{

	protected double tempsDernier; 
	protected double tempsActuel; 
	protected double distanceActuelle;
	protected double distanceDernier;
	protected boolean estImmobile;
					
	public InterpreteurMouvement()
	{
		this.initialiser();
	}
	
	public void initialiser()
	{
		this.tempsDernier = this.tempsActuel = System.currentTimeMillis();
		this.distanceDernier = this.distanceActuelle = Robot.roues.getDistanceGauche();
		this.estImmobile = false;		
	}
	
	public void mesurer()
	{
		this.tempsActuel = System.currentTimeMillis();		
		
		if((this.tempsActuel - this.tempsDernier) > INTERVALLE_IMMOBILITE)
		{
			// verifier
			this.distanceActuelle = Robot.roues.getDistanceGauche();
			this.estImmobile = (Math.abs(this.distanceActuelle - this.distanceDernier) < DISTANCE_NULLE);
			
			// reinitialiser
			this.tempsDernier = this.tempsActuel; 
			this.distanceDernier = this.distanceActuelle; 
		}		
	}
		
	public boolean estImmobile()
	{
		return this.estImmobile;
	}
}
