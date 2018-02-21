package org.firstchampionship.equipe5910.robot2018.outil;

import java.util.ArrayDeque;
import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

public class InterpreteurMouvementBaseSurPositions implements RobotMap.InterpreteurMouvement{

	protected double pauseToleree = INTERVALLE_IMMOBILITE; // en millisecondes
	protected int iterationsImmobile = 1;
	// protected Timer horloge = null;// TODO version avec timer
	protected DernieresPositions dernieresPositions;
	
	public class DernieresPositions
	{
		protected double[] listePositions;
		protected int debut;
		protected int fin;
		protected int taille;
		
		public DernieresPositions(int taille)
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
		
		int ancienDebut;
		public double removeFirst()
		{
			ancienDebut = debut++;
			if(debut >= taille) debut = 0;
			return this.listePositions[ancienDebut];
		}
		
		public void afficher()
		{
			for(int position = 0; position < taille; position++)
				System.out.print(this.listePositions[position] + " ");
			System.out.println("");
		}		
	}

	public InterpreteurMouvementBaseSurPositions()
	{

	}
	
	public void setPauseToleree(double pauseToleree)
	{
		System.out.println("InterpreteurMouvement.setPauseToleree()");
		this.pauseToleree = pauseToleree;
		this.calculerIterationsImmobiles();
	}
	
	private void calculerIterationsImmobiles()
	{
		this.iterationsImmobile = (int) (pauseToleree * 50 / 1000);
		this.dernieresPositions = new DernieresPositions(this.iterationsImmobile);
		for(int position = 0; position < this.iterationsImmobile; position++)
		{
			this.dernieresPositions.addLast(new Double(-1000000));
		}		
		System.out.println("Taille buffer des positions " + this.iterationsImmobile);
	}
	
	protected double distanceActuelle;
	protected double distanceAncienne;
	public void mesurer()
	{
			//double temps = this.horloge.get();
			distanceActuelle = Robot.roues.getDistanceGauche();
			this.dernieresPositions.addLast(new Double(distanceActuelle));
			distanceAncienne = this.dernieresPositions.removeFirst();
			System.out.println("mesurer() - distanceActuelle " + distanceActuelle + " distanceAncienne " + distanceAncienne);			
	}
	
	public boolean estImmobile()
	{
		return ((distanceActuelle - distanceAncienne) < DISTANCE_NULLE);
	}
}
