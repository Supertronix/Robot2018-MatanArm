package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.interaction.LecteurAttributionsAutonomes;
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
	LecteurAttributionsAutonomes lecteurAttributionsAutonomes;	
	
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		Robot.construire();
		manetteConducteur = new ManetteConducteur();
		manetteOperateur = new ManetteOperateur();
		//TimeUnit.SECONDS.sleep(10);		
		this.lecteurAttributionsAutonomes = new LecteurAttributionsAutonomes();
		//this.lecteurAttributionsAutonomes.vider();
	}

	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit()");
		//CommandeRouesAvancer commandeRouesAvancer = new CommandeRouesAvancer(500);
		//commandeRouesAvancer.start();	 // devrait avancer de 10 millimetres
		this.lecteurAttributionsAutonomes.lire();
		
		
	}

	@Override
	public void autonomousPeriodic() {
		Robot.roues.conduire(0, 0);
		// System.out.println("autonomousPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		//this.lecteurAttributionsAutonomes.lire();
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
		
		Robot.roues.conduire(-manetteConducteur.getY1(), -manetteConducteur.getY2());
		//Robot.bras.manualOffsetPID(-manetteConducteur.getY2());
		
		/*if (Math.abs(manetteConducteur.getY2()) >= 0.025)
		{
			Robot.bras.manualControl(-manetteConducteur.getY2());
		}
		else
		{
			
		}*/
		if (Math.abs(manetteConducteur.getAxeMonte()) >= 0.1)
		{
			Robot.bras.ajusterPID(manetteConducteur.getAxeMonte());
		}
		else if (Math.abs(manetteConducteur.getAxeDescend()) >= 0.1)
		{
			Robot.bras.ajusterPID(-manetteConducteur.getAxeDescend());
		}
		
		Robot.chariot.ajusterPID(manetteOperateur.getY1());
		
		if (Math.abs(manetteOperateur.getX1()) >= 0.1)
		{
			Robot.bras.ajusterPID(manetteOperateur.getX1());
		}
		
		
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
