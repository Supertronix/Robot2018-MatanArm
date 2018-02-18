package org.firstchampionship.equipe5910.robot2018.outil;

import java.util.concurrent.SynchronousQueue;

import org.firstchampionship.equipe5910.robot2018.Robot;

public class InterpreteurMouvement {

	public static int PAUSE_TOLEREE = 1000;
	public static double DISTANCE_NULLE = 50; // TODO peut-etre un ratio sur la distance desiree !
	public static int ITERATIONS_PAR_MILLISECONDE = 50/1000;
	protected double pauseToleree = PAUSE_TOLEREE; // en millisecondes
	protected int iterationsImmobile = 1;
	// protected Timer horloge = null;// TODO version avec timer
	protected SynchronousQueue<Double> dernieresPositions = new SynchronousQueue<Double>();

	public InterpreteurMouvement()
	{
		this.calculerIterationsImmobiles();
	}
	
	public void setPauseToleree(double pauseToleree)
	{
		this.pauseToleree = pauseToleree;
		this.calculerIterationsImmobiles();
	}
	
	private void calculerIterationsImmobiles()
	{
		this.iterationsImmobile = (int) (pauseToleree * 50 / 1000);
		for(int position = 0; position < this.iterationsImmobile; position++)
		{
			try {
				this.dernieresPositions.put(new Double(0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	protected double distanceActuelle;
	protected double distanceAncienne;
	public void mesurer()
	{
		try {
			//double temps = this.horloge.get();
			distanceActuelle = Robot.roues.getDistanceGauche();
			this.dernieresPositions.put(new Double(distanceActuelle));
			distanceAncienne = this.dernieresPositions.remove();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean estImmobile()
	{
		return ((distanceActuelle - distanceAncienne) < this.DISTANCE_NULLE);
	}
}
