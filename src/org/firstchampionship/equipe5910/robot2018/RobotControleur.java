package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras.POSITION;
import org.firstchampionship.equipe5910.robot2018.auto.CommandeAutoTest;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancerAngle;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;
import org.firstchampionship.equipe5910.robot2018.interaction.LecteurAttributionsAutonomes;
import org.firstchampionship.equipe5910.robot2018.interaction.ManetteConducteur;
import org.firstchampionship.equipe5910.robot2018.interaction.ManetteOperateur;
import org.firstchampionship.equipe5910.robot2018.interaction.SelecteurPositionAutonome;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotControleur extends IterativeRobot {
	
	protected ManetteOperateur manetteOperateur;
	protected ManetteConducteur manetteConducteur;
	
	 public void zeroAllSensors() {
       Robot.roues.zeroSensors();
	 }
	 
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
		Robot.roues.activerVitesseBasse();
		Robot.roues.zeroSensors();
		SmartDashboard.putNumber("Gyro_Kp_TOURNER", RobotMap.Roues.GYRO_KP_ROTATEONLY);
		SmartDashboard.putNumber("Gyro_Ki_TOURNER", RobotMap.Roues.GYRO_KI_ROTATEONLY);
		SmartDashboard.putNumber("GyroSP", 0.0);
		
		Robot.roues.setGyroConsigne(0.0);
		
		/*CommandeRouesTourner commandeTourner = new CommandeRouesTourner(-90);
		commandeTourner.start();*/
		
		CommandeRouesAvancer commandeAvancer = new CommandeRouesAvancer(500);
		commandeAvancer.start();
		
		//CommandeAutoTest commandeAuto = new CommandeAutoTest();
		//commandeAuto.start();
		
		//CommandeRouesAvancer commandeRouesAvancer = new CommandeRouesAvancer(1000);
		//commandeRouesAvancer.start();	 // devrait avancer de 10 millimetres
		
		/*SelecteurPositionAutonome selecteurPosition = new SelecteurPositionAutonome();
		LecteurAttributionsAutonomes.Attribution attributionCotes = this.lecteurAttributionsAutonomes.lire();
		int positionDepart = selecteurPosition.lireChoix();
		ModeAutonome controleurTrajet = new ModeAutonome();
		CommandGroup trajet = controleurTrajet.obtenirTrajet(positionDepart, attributionCotes);
		trajet.start();*/
		
	}

	@Override
	public void autonomousPeriodic() {
		// System.out.println("autonomousPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		
		//Robot.roues.setDistancePid(SmartDashboard.getNumber("Dist_Kp", RobotMap.Roues.DISTANCE_KP), SmartDashboard.getNumber("Dist_Ki", RobotMap.Roues.DISTANCE_KI));
		//Robot.roues.setDistanceConsigne(SmartDashboard.getNumber("DistanceSP", 0.0));
		//Robot.roues.setGyroPid(SmartDashboard.getNumber("Gyro_Kp", RobotMap.Roues.GYRO_KP_AVANCER_ANGLE), SmartDashboard.getNumber("Gyro_Ki",  RobotMap.Roues.GYRO_KI));
		/*Robot.roues.conduireDroit();*/
		
		SmartDashboard.putNumber("GyroV", Robot.roues.getGyroAngle());
		//Robot.roues.setGyroConsigne(SmartDashboard.getNumber("GyroSP", 0));
		//Robot.roues.setGyroPid(SmartDashboard.getNumber("Gyro_Kp_TOURNER", RobotMap.Roues.GYRO_KP_ROTATEONLY), SmartDashboard.getNumber("Gyro_Ki_TOURNER",  RobotMap.Roues.GYRO_KI_ROTATEONLY));
		//Robot.roues.rotateWithGyro();
		/*if (SmartDashboard.getBoolean("resetSensors", false))
		{
			Robot.roues.zeroSensors();
			SmartDashboard.putNumber("DistanceSP", 0.0);
			Robot.roues.setGyroConsigne(0.0);
			Robot.roues.setDistanceConsigne(0.0);
		}*/
		
	}

	@Override
	public void teleopInit() {		
		System.out.println("teleopInit()");
		//Robot.bras.allerPosition(POSITION.MILIEU);
		Robot.pince.fermer();
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
		SmartDashboard.putNumber("Angle_bras", Robot.bras.getPosition());
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
