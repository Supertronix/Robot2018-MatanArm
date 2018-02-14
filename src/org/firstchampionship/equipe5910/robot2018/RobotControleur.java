package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.interaction.ManetteConducteur;
import org.firstchampionship.equipe5910.robot2018.interaction.ManetteOperateur;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;


public class RobotControleur extends IterativeRobot {
	
	protected ManetteOperateur manetteOperateur;
	protected ManetteConducteur manetteConducteur;
	
	//DigitalInput encodeurGaucheA = new DigitalInput(RobotMap.Roues.ENCODEUR_CONDUITE_GAUCHE_A);
	//DigitalInput encodeurGaucheB = new DigitalInput(RobotMap.Roues.ENCODEUR_CONDUITE_GAUCHE_B);
	//DigitalInput encodeurDroitA = new DigitalInput(RobotMap.Roues.ENCODEUR_CONDUITE_DROITE_A);
	//DigitalInput encodeurDroitB = new DigitalInput(RobotMap.Roues.ENCODEUR_CONDUITE_DROITE_B);
	
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		Robot.construire();
		manetteConducteur = new ManetteConducteur();
		manetteOperateur = new ManetteOperateur();
		//TimeUnit.SECONDS.sleep(10);		
	}

	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit()");
		//CommandeRouesAvancer commandeRouesAvancer = new CommandeRouesAvancer(500);
		//commandeRouesAvancer.start();	 // devrait avancer de 10 millimetres
	}

	@Override
	public void autonomousPeriodic() {
		// System.out.println("autonomousPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		
		
	}

	@Override
	public void teleopInit() {		
		System.out.println("teleopInit()");
	}

	
	@Override
	public void teleopPeriodic() {		
		// System.out.println("teleopPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes

		//System.out.println("Distance droite " + Robot.roues.getDistanceDroiteSelonEncodeur());
		//System.out.println("Distance gauche " + Robot.roues.getDistanceGaucheSelonEncodeur());
        
        //System.out.println("Pin analogue gauche A " + encodeurGaucheA.get());
        //System.out.println("Pin analogue gauche B " + encodeurGaucheB.get());
        //System.out.println("Pin analogue droite A " + encodeurDroitA.get());
        //System.out.println("Pin analogue droite B " + encodeurDroitB.get());
        
		/*if(manetteConducteur.veuxAvancer()){
			Robot.roues.avancer(manetteConducteur.getAvancer(), manetteConducteur.getdirection());
		}
		else if(manetteConducteur.veuxReculer()){
			Robot.roues.reculer(manetteConducteur.getReculer(), manetteConducteur.getdirection());
		}
		else{
			if(manetteConducteur.veuxTournerSurPlace()){
				Robot.roues.tournerSurPlace(manetteConducteur.getTournerSurPlace());
			}
			else{
				Robot.roues.arreter();
			}
			
		}*/
		
		if (Math.abs(manetteConducteur.getY2()) >= 0.025)
		{
			Robot.bras.manualControl(-manetteConducteur.getY2());
		}
		
		//Robot.chariot.manualControl(-manetteConducteur.getY2());
	}
	
	@Override
	public void testInit() {
		System.out.println("testInit()");
	}
	
	@Override
	public void testPeriodic() {
		// System.out.println("testPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
	}

}
