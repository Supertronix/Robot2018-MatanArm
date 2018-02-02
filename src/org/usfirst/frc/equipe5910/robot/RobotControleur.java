package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RobotControleur extends IterativeRobot {

	public static Roues roue;
	
	Manette manette;
	
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		
		
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
		roue = new Roues();
		manette = new Manette();
	}

	
	@Override
	public void teleopPeriodic() {
		// System.out.println("teleopPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes

		if(manette.veuxAvancer()){
			roue.avancer(manette.getAvancer());
		}
		else if(manette.veuxReculer()){
			roue.reculer(manette.getReculer());
		}
		else{
			roue.arreter();
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
