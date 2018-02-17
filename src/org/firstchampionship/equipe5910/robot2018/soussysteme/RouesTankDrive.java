package org.firstchampionship.equipe5910.robot2018.soussysteme;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RouesTankDrive extends Roues{
	
	protected DifferentialDrive tankDrive;
	protected double dernierEncodeurGauche;
	protected long delaiDepuisChangementVitesse;
	
	public RouesTankDrive(){
		super();
		tankDrive = new DifferentialDrive(roueGauche, roueDroite);
		/*SmartDashboard.putNumber("encodeurChangementVitesse", 1500);
		SmartDashboard.putNumber("tempsChangementVitesse", 250);
		delaiDepuisChangementVitesse = System.currentTimeMillis();*/
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////  CONDUITE  /////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////	
	
	public void conduire(double Y1, double Y2)
	{
		tankDrive.tankDrive(Y1, Y2);
	}
	
	public void conduireDroit() 
	{
		//Verifier si on se rapproche de la cible on change le profil PID de 0 a 1
		tankDrive.tankDrive(pidSortieDistance.getPIDOut() + pidSortieGyro.getPIDOut(), pidSortieDistance.getPIDOut() - pidSortieGyro.getPIDOut());
	}
			
	
}
