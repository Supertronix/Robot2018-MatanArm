package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;


public class RobotControleur extends IterativeRobot {
	
	Manette manette;
	
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		Robot.construire();
		manette = new Manette();
		
		}

	
	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit()");
	
		
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

        System.out.println("Distance droite " + Robot.roues.getDistanceDroiteSelonEncodeur());
        System.out.println("Distance gauche " + Robot.roues.getDistanceGaucheSelonEncodeur());
        
		if(manette.veuxAvancer()){
			Robot.roues.avancer(manette.getAvancer(), manette.getdirection());
		}
		else if(manette.veuxReculer()){
			Robot.roues.reculer(manette.getReculer());
		}
		else{
			
			if(manette.veuxTournerSurPlace()){
				Robot.roues.tournerSurPlace(manette.getTournerSurPlace());
			}
			else{
				Robot.roues.arreter();
			}
			
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
