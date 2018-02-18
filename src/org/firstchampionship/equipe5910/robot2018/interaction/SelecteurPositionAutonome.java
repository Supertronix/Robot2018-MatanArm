package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SelecteurPositionAutonome implements RobotMap.SelecteurPositionAutonome{

    protected DigitalInput interrupteurGauche = new DigitalInput(INTERRUPTEUR_GAUCHE);
    protected DigitalInput interrupteurDroit = new DigitalInput(INTERRUPTEUR_DROIT);

    protected int position = 0;
    
    public int lireChoix()
    {
    	if(this.interrupteurGauche.get() && this.interrupteurDroit.get()) position = 2;
    	else if(this.interrupteurGauche.get()) position = 1;
    	else if(this.interrupteurDroit.get()) position = 3;
		return position;
    }
    
	public void afficherChoix() 
	{
		String trajetChoisi = "no Command selected";
		SmartDashboard.putNumber("TRAJET CHOISI", position);
		Timer.delay(0.2);
	}
	
}
