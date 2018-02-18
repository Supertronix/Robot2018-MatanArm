package org.firstchampionship.equipe5910.robot2018.outil;

import java.util.ArrayDeque;
import org.firstchampionship.equipe5910.robot2018.Robot;

public class InterpreteurMouvement {

	public static int PAUSE_TOLEREE = 1000;
	public static double DISTANCE_NULLE = 50; // TODO peut-etre un ratio sur la distance desiree !
	public static int ITERATIONS_PAR_MILLISECONDE = 50/1000;
	protected double pauseToleree = PAUSE_TOLEREE; // en millisecondes
	protected int iterationsImmobile = 1;
	// protected Timer horloge = null;// TODO version avec timer
	protected ArrayDeque<Double> dernieresPositions;

	public InterpreteurMouvement()
	{
		this.dernieresPositions = new ArrayDeque<Double>();
		this.calculerIterationsImmobiles();
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
		for(int position = 0; position < this.iterationsImmobile; position++)
		{
			this.dernieresPositions.push(new Double(-1000000));
		}		
		System.out.println("Taille buffer des positions " + this.dernieresPositions.size());
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
