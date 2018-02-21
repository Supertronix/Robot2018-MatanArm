package org.firstchampionship.equipe5910.robot2018.outil;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

public class InterpreteurMouvementFin implements RobotMap.InterpreteurMouvement{

	//protected Timer horloge = null; // plus des secondes de match
	protected double intervalle = INTERVALLE_IMMOBILITE; // en millisecondes
	protected int echantillons = 0;
	protected double tempsDernier; // temps en millisecondes
	protected double tempsActuel; // temps en millisecondes
	protected double tempsDebut; // temps en millisecondes
	protected double tempsDebutZero;
	protected double distanceActuelle;
	protected double distanceDernier;
	protected double distanceDebut;
	protected double deltaMoyen;
	protected double deltaActuel;
	protected double deltaSeuil;
	protected int iterationsImmobile;
	
	public InterpreteurMouvementFin()
	{
		this.initialiser();
	}
	
	public void initialiser()
	{		
		this.tempsDebutZero = this.tempsDebut = this.tempsActuel = System.currentTimeMillis();
		this.iterationsImmobile = (int) (intervalle * 50 / 1000);
		this.deltaSeuil = DISTANCE_NULLE / this.iterationsImmobile;
		//this.distanceDernier = -this.deltaSeuil * 3; // plus necessaire avec delai de grace du debut
	}
	
	public void setPauseToleree(double pauseToleree)
	{
		System.out.println("InterpreteurMouvement.setPauseToleree()");
		this.intervalle = pauseToleree;
	}
			
	public void mesurer()
	{
		this.echantillons++;
		
		this.tempsDernier = this.tempsActuel; this.tempsActuel = System.currentTimeMillis();		
		this.distanceDernier = this.distanceActuelle; this.distanceActuelle = Robot.roues.getDistanceGauche();
		this.deltaActuel = Math.abs(this.distanceActuelle - this.distanceDernier);
		this.deltaMoyen = Math.abs(this.distanceActuelle - this.distanceDebut) / this.echantillons;
		
		if((this.tempsActuel - this.tempsDebut) > INTERVALLE_IMMOBILITE)
		{
			this.recommencerIntervalle();
		}
		
		System.out.println("mesurer() - distanceActuelle " + distanceActuelle + " distanceDerniere " + distanceDebut);
	}
	
	protected void recommencerIntervalle()
	{
		this.echantillons = 0;
		this.tempsDebut = System.currentTimeMillis();
		this.distanceDebut = this.distanceActuelle;	
	}
	
	public boolean estImmobile()
	{
		if((this.tempsActuel - this.tempsDebutZero) < INTERVALLE_IMMOBILITE) return false; // delais de grace du debut
		return (this.deltaMoyen < this.deltaSeuil) || (this.deltaActuel < 2*this.deltaSeuil);
	}
}
