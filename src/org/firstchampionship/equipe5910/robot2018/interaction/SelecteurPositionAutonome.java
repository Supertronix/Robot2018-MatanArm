package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SelecteurPositionAutonome implements RobotMap.SelecteurPositionAutonome{

    protected DigitalInput interrupteurGauche = null;
    protected DigitalInput interrupteurDroit = null;

    protected int position = 0;
    
    private SelecteurPositionAutonome()
    {
        this.interrupteurGauche = new DigitalInput(INTERRUPTEUR_GAUCHE);
        this.interrupteurDroit = new DigitalInput(INTERRUPTEUR_DROIT);
    }
    
    static protected SelecteurPositionAutonome instance = null;
    static public SelecteurPositionAutonome getInstance()
    {
    	if(null == instance) instance = new SelecteurPositionAutonome();
    	return instance;
    }
    
    public int lireChoix()
    {
    	System.out.println("Interrupteur GAUCHE " + this.interrupteurGauche.get());
    	System.out.println("Interrupteur DROIT " + this.interrupteurDroit.get());
    	SmartDashboard.putBoolean("Switch GAUCHE", this.interrupteurGauche.get());
    	SmartDashboard.putBoolean("Switch DROITE", this.interrupteurDroit.get());
    	
    	if(this.interrupteurGauche.get() && this.interrupteurDroit.get()) position = 4;
    	else if(!this.interrupteurGauche.get() && !this.interrupteurDroit.get()) position = 2;
    	else if(this.interrupteurGauche.get()) position = 1;
    	else if(this.interrupteurDroit.get()) position = 3;
    	
    	System.out.println("Position trouvee " + position);
    	SmartDashboard.putNumber("Position depart autonome", position);
		return position;
    }	
}
