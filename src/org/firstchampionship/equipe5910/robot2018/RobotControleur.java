package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.RobotMap.Bras.POSITION;
import org.firstchampionship.equipe5910.robot2018.auto.CommandeAutoTest;
import org.firstchampionship.equipe5910.robot2018.commande.CommandePinceFermer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancerAngle;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesTourner;
import org.firstchampionship.equipe5910.robot2018.interaction.AnimateurLed;
import org.firstchampionship.equipe5910.robot2018.interaction.LecteurAttributionsAutonomes;
import org.firstchampionship.equipe5910.robot2018.interaction.ManetteConducteur;
import org.firstchampionship.equipe5910.robot2018.interaction.ManetteOperateur;
import org.firstchampionship.equipe5910.robot2018.interaction.SelecteurPositionAutonome;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotControleur extends IterativeRobot {
	
	protected ManetteOperateur manetteOperateur;
	protected ManetteConducteur manetteConducteur;

	 public void zeroAllSensors() {
       Robot.roues.zeroSensors();
	 }
	
	 static public boolean estAutonome = false;
	 
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		/*
		Robot.construire();
		manetteConducteur = new ManetteConducteur();
		manetteOperateur = new ManetteOperateur();
		//TimeUnit.SECONDS.sleep(10);
		
		this.lecteurAttributionsAutonomes = new LecteurAttributionsAutonomes();
		//this.lecteurAttributionsAutonomes.vider();
		 */
	}

	protected LecteurAttributionsAutonomes lecteurAttributionsAutonomes = null;	
	protected SelecteurPositionAutonome selecteurPosition = null;
	protected LecteurAttributionsAutonomes.Attribution attributionCotes = null;
	protected CommandGroup trajet = null;
	protected ModeAutonome controleurTrajet = null;
	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit()");
		RobotControleur.estAutonome = true;
		/*
		Robot.roues.activerVitesseBasse();
		Robot.roues.zeroSensors();
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////// GYRO ///////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		SmartDashboard.putNumber("Gyro_Kp_TOURNER", RobotMap.Roues.GYRO_KP_ROTATEONLY);
		SmartDashboard.putNumber("Gyro_Ki_TOURNER", RobotMap.Roues.GYRO_KI_ROTATEONLY);
		SmartDashboard.putNumber("GyroSP", 0.0);		
		Robot.roues.setGyroConsigne(0.0);
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////// CHOIX TRAJET ////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		
		this.selecteurPosition = SelecteurPositionAutonome.getInstance();
		this.attributionCotes = this.lecteurAttributionsAutonomes.lire();
		if(null != this.attributionCotes)
		{
			controleurTrajet = new ModeAutonome();
			int positionDepart = selecteurPosition.lireChoix();
			this.trajet = controleurTrajet.obtenirTrajet(positionDepart, attributionCotes);
			if(this.trajet != null) this.trajet.start();	
		}
		*/
	}

	@Override
	public void autonomousPeriodic() {
		System.out.println("autonomousPeriodic()");
		Robot.roues.conduire(0, 0); // garder pour tests
		/*
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		//this.selecteurPosition.lireChoix();
		//Robot.roues.setDistancePid(SmartDashboard.getNumber("Dist_Kp", RobotMap.Roues.DISTANCE_KP), SmartDashboard.getNumber("Dist_Ki", RobotMap.Roues.DISTANCE_KI));
		//Robot.roues.setDistanceConsigne(SmartDashboard.getNumber("DistanceSP", 0.0));
		//Robot.roues.setGyroPid(SmartDashboard.getNumber("Gyro_Kp", RobotMap.Roues.GYRO_KP_AVANCER_ANGLE), SmartDashboard.getNumber("Gyro_Ki",  RobotMap.Roues.GYRO_KI));
		//Robot.roues.conduireDroit();
		
		SmartDashboard.putNumber("GyroV", Robot.roues.getGyroAngle());
		//Robot.roues.setGyroConsigne(SmartDashboard.getNumber("GyroSP", 0));
		//Robot.roues.setGyroPid(SmartDashboard.getNumber("Gyro_Kp_TOURNER", RobotMap.Roues.GYRO_KP_ROTATEONLY), SmartDashboard.getNumber("Gyro_Ki_TOURNER",  RobotMap.Roues.GYRO_KI_ROTATEONLY));
		//Robot.roues.rotateWithGyro();
		//if (SmartDashboard.getBoolean("resetSensors", false))
		{
		//	Robot.roues.zeroSensors();
		//	SmartDashboard.putNumber("DistanceSP", 0.0);
		//	Robot.roues.setGyroConsigne(0.0);
		//	Robot.roues.setDistanceConsigne(0.0);
		}
				
		if(null == this.attributionCotes)
		{
			this.attributionCotes = this.lecteurAttributionsAutonomes.lire();
			if(null != this.attributionCotes)
			{
				ModeAutonome controleurTrajet = new ModeAutonome();
				int positionDepart = selecteurPosition.lireChoix();
				this.trajet = controleurTrajet.obtenirTrajet(positionDepart, attributionCotes);
				if(this.trajet != null) this.trajet.start();	
			}
		}
		*/
	}

	@Override
	public void teleopInit() {	
		RobotControleur.estAutonome = false;
		/*
		if (controleurTrajet != null)
		{
			controleurTrajet.cancel();
			controleurTrajet = null;
		}
			
		System.out.println("teleopInit()");
		Robot.pince.fermer();
		*/
	}

	
	@Override
	public void teleopPeriodic() {		
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		/*
		Robot.roues.conduire(-manetteConducteur.getY1(), -manetteConducteur.getY2());
		
		// BRAS
		if (Math.abs(manetteConducteur.getAxeMonte()) >= 0.1)
		{
			Robot.bras.ajusterPID(manetteConducteur.getAxeMonte());
		}
		else if (Math.abs(manetteConducteur.getAxeDescend()) >= 0.1)
		{
			Robot.bras.ajusterPID(-manetteConducteur.getAxeDescend());
		}
		
		// CHARIOT	
		if (Math.abs(manetteOperateur.getY1()) >= 0.1)
		{
			if (Timer.getMatchTime() > 30)
			{
				Robot.chariot.ajusterPID(manetteOperateur.getY1() / 5);
			}
			else
			{
				Robot.chariot.ajusterPID(manetteOperateur.getY1());
			}
		}
		if (Robot.bras.isInExtendedLimits() && Robot.chariot.getPosition() < RobotMap.Chariot.CHARIOT_POSITION_LIMITE_OUVERTURE_PINCE)
		{
			CommandePinceFermer fermerPince = new CommandePinceFermer();
			fermerPince.start();
		}
		//L'operateur ne veut plus le controle du bras
		//if (Math.abs(manetteOperateur.getX1()) >= 0.1)
		//{
		//	Robot.bras.ajusterPID(manetteOperateur.getX1());
		//}
		
		SmartDashboard.putNumber("Angle_bras", Robot.bras.getPosition());
		SmartDashboard.putNumber("Position_Chariot", Robot.chariot.getPosition());
		*/
	}
	@Override
	public void disabledInit() {
	}
	
	
	@Override
	public void testInit() {
	}
	
	@Override
	public void testPeriodic() {
		System.out.println("testPeriodic()");
		// http://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/command/Scheduler.html
		Scheduler.getInstance().run(); // pour faire marcher les commandes
		AnimateurLed.getInstance().indiquerAlliance(AnimateurLed.ALLIANCE_ROUGE);
	    Timer.delay(1);
	}

}
