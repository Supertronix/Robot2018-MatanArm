package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RobotControleur extends IterativeRobot {

	Roue roue;
	
	Manette manette;
	
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		roue = new Roue();
		manette = new Manette();
		
		}

	
	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit()");
	
		
	}


	@Override
	public void autonomousPeriodic() {
		System.out.println("autonomousPeriodic()");
		
		
	}

	@Override
	public void teleopInit() {
		System.out.println("teleopInit()");
	}

	
	@Override
	public void teleopPeriodic() {
		System.out.println("teleopPeriodic()");
		
		roue.deplacer(manette.getConduiteGauche(), manette.getConduiteDroite());
		
	}

		@Override
	public void testPeriodic() {
		System.out.println("testPeriodic()");
	}
	
	
	@Override
	public void testInit() {
		System.out.println("testInit()");
	}
	
}
