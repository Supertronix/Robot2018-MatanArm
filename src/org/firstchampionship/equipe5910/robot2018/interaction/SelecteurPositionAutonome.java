package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SelecteurPositionAutonome implements RobotMap.SelecteurPositionAutonome{

    protected DigitalInput interrupteur0 = new DigitalInput(INTERRUPTEUR_DIGITAL_0);
    protected DigitalInput interrupteur1 = new DigitalInput(INTERRUPTEUR_DIGITAL_1);

    protected int position = 0;
    
    public int lireChoix()
    {
    	if(this.interrupteur0.get() && this.interrupteur1.get()) position = 1;
    	if(this.interrupteur0.get() && !this.interrupteur1.get()) position = 2;
    	if(!this.interrupteur0.get() && this.interrupteur1.get()) position = 3;
		return position;
    }
    
    
	public void afficherChoix() 
	{
		String trajetChoisi = "no Command selected";
		SmartDashboard.putNumber("TRAJET CHOISI", position);
		Timer.delay(0.2);
	}
	
}
