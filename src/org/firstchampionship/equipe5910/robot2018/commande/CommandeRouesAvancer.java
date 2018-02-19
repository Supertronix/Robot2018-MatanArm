package org.firstchampionship.equipe5910.robot2018.commande;

import org.firstchampionship.equipe5910.robot2018.Robot;
import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.outil.InterpreteurMouvement;
import edu.wpi.first.wpilibj.command.Command;

public class CommandeRouesAvancer extends Command{
	
	protected double distanceVoulue;
	protected double positionInitiale = 0;
	protected boolean PIDFirstLoop = true;
	//protected InterpreteurMouvement verificateurImmobilite;
	
	public CommandeRouesAvancer(double distanceVoulue)
	{
		requires(Robot.roues);		
		this.distanceVoulue = distanceVoulue;
		//verificateurImmobilite = new InterpreteurMouvement();
	}

	public void setPauseToleree(double pauseToleree)
	{
		//this.verificateurImmobilite.setPauseToleree(pauseToleree);
	}
	
	@Override
	protected void initialize() {
		if (Math.abs(distanceVoulue) < 500)
			Robot.roues.setDistancePid(RobotMap.Roues.DISTANCE_KP * 5, RobotMap.Roues.DISTANCE_KI);
		else
			Robot.roues.setDistancePid(RobotMap.Roues.DISTANCE_KP, RobotMap.Roues.DISTANCE_KI);
		
		Robot.roues.setGyroPid(RobotMap.Roues.GYRO_KP_AVANCER, RobotMap.Roues.GYRO_KI_AVANCER);
		Robot.roues.zeroSensors();
		Robot.roues.setGyroConsigne(0);
		System.out.println("CommandeRouesAvancer.initialize()");
		//this.positionInitiale = Robot.roues.getDistanceGauche();
		System.out.println("Position initiale " + positionInitiale);
		
		// Robot.roues.avancer(vitesse); 
		// Robot.roues.informerEncodeurDroitDeLaCible(distanceVoulue);
	}
	
	@Override
	protected void execute() {
				
		if (Math.abs(distanceVoulue - Robot.roues.getDistanceGauche()) <= 500)
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
			if (distanceVoulue > 0)
			{
				Robot.roues.conduireDroitGyroSeul(0.75);
			}	
			else
			{
				Robot.roues.conduireDroitGyroSeul(-0.75);
			}
				
		}
		//System.out.println("CommandeRouesAvancer.execute()");
		//Robot.roues.avancer(vitesse); 
		//Robot.roues.avancer(Robot.roues.getVitesseSelonEncodeurDroitStabilise()); 
		// System.out.println("selon pid vitesse = "  + Robot.roues.getVitesseSelonEncodeurDroitStabilise());
		
		//this.verificateurImmobilite.mesurer();
	}
	
	protected boolean estArrive = false;
	@Override
	protected boolean isFinished() {
		System.out.println("Distance parcourue " + (Robot.roues.getDistanceGauche() - this.positionInitiale));
		if (distanceVoulue >= 0)
		{
			estArrive = Robot.roues.getDistanceGauche() >= (this.distanceVoulue);
		}
		else
		{
			estArrive = Robot.roues.getDistanceGauche() <= (this.distanceVoulue);
		}
		//System.out.println("estArrive " + estArrive + " est immobile " + this.verificateurImmobilite.estImmobile());
		//return estArrive || this.verificateurImmobilite.estImmobile();
		return estArrive;
	}
	
	@Override
	protected void end() {
		System.out.println("CommandeRouesAvancer.end()");
		Robot.roues.disablePIDs();
		
		//Robot.roues.arreter();
	}
	

}
