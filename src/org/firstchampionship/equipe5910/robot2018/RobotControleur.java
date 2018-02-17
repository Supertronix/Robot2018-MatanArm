package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.interaction.ManetteConducteur;
import org.firstchampionship.equipe5910.robot2018.interaction.ManetteOperateur;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotControleur extends IterativeRobot {
	
	protected ManetteOperateur manetteOperateur;
	protected ManetteConducteur manetteConducteur;
	
	 public void zeroAllSensors() {
       Robot.roues.zeroSensors();
	 }
	 
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
		Robot.roues.activerVitesseBasse();
		Robot.roues.zeroSensors();
		SmartDashboard.putNumber("Dist_Kp", RobotMap.Roues.DISTANCE_KP);
		SmartDashboard.putNumber("Dist_Ki", RobotMap.Roues.DISTANCE_KI);
		SmartDashboard.putNumber("DistanceSP", 0.0);
		
		Robot.roues.setGyroConsigne(0.0);
		SmartDashboard.putNumber("Gyro_Kp", RobotMap.Roues.GYRO_KP);
		SmartDashboard.putNumber("Gyro_Ki", RobotMap.Roues.GYRO_KI);
		SmartDashboard.putBoolean("resetSensors", false);
		SmartDashboard.putBoolean("enablePIDs", true);
		
		//CommandeRouesAvancer commandeRouesAvancer = new CommandeRouesAvancer(500);
		//commandeRouesAvancer.start();	 // devrait avancer de 10 millimetres
	}

	@Override
	public void autonomousPeriodic() {
		// System.out.println("autonomousPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		Robot.roues.setDistancePid(SmartDashboard.getNumber("Dist_Kp", RobotMap.Roues.DISTANCE_KP), SmartDashboard.getNumber("Dist_Ki", RobotMap.Roues.DISTANCE_KI));
		Robot.roues.setDistanceConsigne(SmartDashboard.getNumber("DistanceSP", 0.0));
		Robot.roues.setGyroPid(SmartDashboard.getNumber("Gyro_Kp", RobotMap.Roues.GYRO_KP), SmartDashboard.getNumber("Gyro_Ki",  RobotMap.Roues.GYRO_KI));
		Robot.roues.conduireDroit();
		
		SmartDashboard.putNumber("EncodeurG", Robot.roues.getDistanceGauche());
		SmartDashboard.putNumber("EncodeurD", Robot.roues.getDistanceDroite());
		SmartDashboard.putNumber("GyroV", Robot.roues.getGyroAngle());
		
		if (SmartDashboard.getBoolean("resetSensors", false))
		{
			Robot.roues.zeroSensors();
			SmartDashboard.putNumber("DistanceSP", 0.0);
			Robot.roues.setGyroConsigne(0.0);
			Robot.roues.setDistanceConsigne(0.0);
		}
	}

	@Override
	public void teleopInit() {		
		System.out.println("teleopInit()");
	}

	
	@Override
	public void teleopPeriodic() {		
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		
		Robot.roues.conduire(-manetteConducteur.getY1(), -manetteConducteur.getY2());
		if (Math.abs(manetteConducteur.getAxeMonte()) >= 0.1)
		{
			Robot.bras.ajusterPID(manetteConducteur.getAxeMonte());
		}
		else if (Math.abs(manetteConducteur.getAxeDescend()) >= 0.1)
		{
			Robot.bras.ajusterPID(-manetteConducteur.getAxeDescend());
		}
		if (Math.abs(manetteOperateur.getY1()) >= 0.1)
		{
			Robot.chariot.ajusterPID(manetteOperateur.getY1());
		}
		
		if (Math.abs(manetteOperateur.getX1()) >= 0.1)
		{
			Robot.bras.ajusterPID(manetteOperateur.getX1());
		}
		
	}
	
	@Override
	public void testInit() {
	}
	
	@Override
	public void testPeriodic() {
		// System.out.println("testPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
	}

}
