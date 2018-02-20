package org.firstchampionship.equipe5910.robot2018.outil;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

public class InterpreteurMouvement implements RobotMap.InterpreteurMouvement{

	//protected Timer horloge = null; // plus des secondes de match
	protected double pauseToleree = PAUSE_TOLEREE; // en millisecondes
	protected int echantillons = 0;
	protected double tempsDernier; // temps en millisecondes
	protected double tempsActuel; // temps en millisecondes
	protected double tempsDebut; // temps en millisecondes
	protected double distanceActuelle;
	protected double distanceDernier;
	protected double distanceDebut;
	protected double deltaMoyen;
	protected double deltaActuel;
	protected double deltaSeuil;
	protected int iterationsImmobile;
	
	public InterpreteurMouvement()
	{
		this.tempsDebut = this.tempsActuel = System.currentTimeMillis();
		this.iterationsImmobile = (int) (pauseToleree * 50 / 1000);
		this.deltaSeuil = DISTANCE_NULLE / this.iterationsImmobile;
	}
	
	public void setPauseToleree(double pauseToleree)
	{
		System.out.println("InterpreteurMouvement.setPauseToleree()");
		this.pauseToleree = pauseToleree;
	}
			
	public void mesurer()
	{
		this.echantillons++;
		
		this.tempsDernier = this.tempsActuel; this.tempsActuel = System.currentTimeMillis();		
		this.distanceDernier = this.distanceActuelle; this.distanceActuelle = Robot.roues.getDistanceGauche();
		System.out.println("mesurer() - distanceActuelle " + distanceActuelle + " distanceDerniere " + distanceDebut);
		
		this.deltaMoyen = (this.distanceActuelle - this.distanceDebut) / this.echantillons;
		this.deltaActuel = (this.distanceActuelle - this.distanceDernier);
		
		// RESET
		if((this.tempsActuel - this.tempsDebut) > PAUSE_TOLEREE)
		{
			this.echantillons = 0;
			this.tempsDebut = System.currentTimeMillis();
			this.distanceDebut = this.distanceActuelle;
		}
	}
	
	public boolean estImmobile()
	{
		return (this.deltaMoyen < this.deltaSeuil) || (this.deltaActuel < 2*this.deltaSeuil);
	}
}
