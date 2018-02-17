package org.firstchampionship.equipe5910.robot2018.commande;

import java.util.concurrent.SynchronousQueue;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesAvancer extends Command{

	public static int PAUSE_TOLEREE = 1000;
	public static double DISTANCE_NULLE = 50; // TODO peut-être un ratio sur la distance desiree !
	public static int ITERATIONS_PAR_MILLISECONDE = 50/1000;
	
	protected double distanceVoulue;
	protected double positionInitiale = 0;
	protected double vitesse = 0.1; // test primitif
	protected boolean PIDFirstLoop = true;
	
	protected double pauseToleree = PAUSE_TOLEREE; // en millisecondes
	protected int iterationsImmobile = 1;
	// protected Timer horloge = null;// TODO version avec timer
	protected SynchronousQueue<Double> dernieresPositions = new SynchronousQueue<Double>();

	public CommandeRouesAvancer(double distanceVoulue)
	{
		requires(Robot.roues);		
		this.distanceVoulue = distanceVoulue;
		//this.horloge = new Timer();
		this.calculeIterationsImmobiles();
	}

	public void setPauseToleree(double pauseToleree)
	{
		this.pauseToleree = pauseToleree;
		this.calculeIterationsImmobiles();
	}
	
	private void calculeIterationsImmobiles()
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
	
	@Override
	protected void initialize() {
		Robot.roues.setGyroPid(RobotMap.Roues.GYRO_KP_AVANCER, RobotMap.Roues.GYRO_KP_AVANCER);
		Robot.roues.zeroSensors();
		Robot.roues.setGyroConsigne(0);
		System.out.println("CommandeRouesAvancer.initialize()");
		//this.positionInitiale = Robot.roues.getDistanceGauche();
		System.out.println("Position initiale " + positionInitiale);
		
		// Robot.roues.avancer(vitesse); 
		// Robot.roues.informerEncodeurDroitDeLaCible(distanceVoulue);
	}

	protected double distanceActuelle;
	protected double distanceAncienne;
	
	@Override
	protected void execute() {
		
		try {
			//double temps = this.horloge.get();
			distanceActuelle = Robot.roues.getDistanceGauche();
			this.dernieresPositions.put(new Double(distanceActuelle));
			distanceAncienne = this.dernieresPositions.remove();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (distanceVoulue - Robot.roues.getDistanceGauche() <= 500)
		{
			if (PIDFirstLoop)
			{
					Robot.roues.resetPIDS();
					PIDFirstLoop = false;
			}
			
			Robot.roues.setDistanceConsigne(distanceVoulue);
			Robot.roues.conduireDroit();
		}
		else
		{
			Robot.roues.conduireDroitGyroSeul(0.75);
		}
		//System.out.println("CommandeRouesAvancer.execute()");
		//Robot.roues.avancer(vitesse); 
		//Robot.roues.avancer(Robot.roues.getVitesseSelonEncodeurDroitStabilise()); 
		// System.out.println("selon pid vitesse = "  + Robot.roues.getVitesseSelonEncodeurDroitStabilise());
	}
	
	protected boolean estArrive = false;
	protected boolean estImmobile = false;
	@Override
	protected boolean isFinished() {
		System.out.println("Distance parcourue " + (Robot.roues.getDistanceGauche() - this.positionInitiale));
		estArrive = Robot.roues.getDistanceGauche() >= (this.distanceVoulue);
		estImmobile = false; //estImmobile = ((distanceActuelle - distanceAncienne) < this.DISTANCE_NULLE);
		System.out.println("estArrive " + estArrive + " est immobile " + estImmobile);
		return estArrive || estImmobile;
	}
	
	@Override
	protected void end() {
		System.out.println("CommandeRouesAvancer.end()");
		Robot.roues.disablePIDs();
		
		//Robot.roues.arreter();
	}
	

}
