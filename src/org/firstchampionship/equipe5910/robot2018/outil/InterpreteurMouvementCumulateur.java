package org.firstchampionship.equipe5910.robot2018.outil;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

public class InterpreteurMouvementCumulateur implements RobotMap.InterpreteurMouvement{

	protected DernieresPositions dernieresPositions;
	protected double intervalle = INTERVALLE_IMMOBILITE;
	protected int iterationsImmobile = 1;
	protected double distanceActuelle;
	protected double distanceAncienne;
	protected int iteration = 0;
	
	public InterpreteurMouvementCumulateur()
	{
		this.initialiser();
	}
	
	public void initialiser()
	{
		this.iteration = 0;
		this.iterationsImmobile = (int) (intervalle * 50 / 1000);
		this.dernieresPositions = new DernieresPositions(this.iterationsImmobile);
		for(int position = 0; position < this.iterationsImmobile; position++)
		{
			this.dernieresPositions.addLast(new Double(-1000000));
		}
		System.out.println("Taille buffer des positions " + this.iterationsImmobile);
	}

	public void mesurer()
	{
		this.iteration++;
		this.distanceAncienne = this.dernieresPositions.removeFirst();
		this.distanceActuelle = Robot.roues.getDistanceGauche();
		this.dernieresPositions.addLast(new Double(distanceActuelle));
		System.out.println("mesurer() - distanceActuelle " + distanceActuelle + " distanceAncienne " + distanceAncienne);			
	}
	
	public boolean estImmobile()
	{
		return ((Math.abs(distanceActuelle - distanceAncienne) < DISTANCE_NULLE) && (this.iteration > this.iterationsImmobile));
	}
	
 	public class DernieresPositions
	{
		protected double[] listePositions;
		protected int debut;
		protected int fin;
		protected int taille;
		
		public DernieresPositions(int taille)
		{
			this.initialiser(taille);
		}
		
		public void initialiser(int taille)
		{
			this.debut = this.fin = 0;
			this.taille = taille;
			this.listePositions = new double[taille];			
		}
		
		public void addLast(double valeur)
		{
			this.listePositions[fin++] = valeur;
			if(fin >= taille) fin = 0;
		}
		
		protected int ancienDebut;
		protected double ancienneValeur;
		public double removeFirst()
		{
			ancienDebut = debut++;
			ancienneValeur = this.listePositions[ancienDebut]; this.listePositions[ancienDebut] = -1;
			if(debut >= taille) debut = 0;
			
			//return this.listePositions[ancienDebut];
			return ancienneValeur;
		}
		
		public void afficher()
		{
			for(int position = 0; position < taille; position++)
				System.out.print(this.listePositions[position] + " ");
			System.out.println("");
		}		
	}
	
}
