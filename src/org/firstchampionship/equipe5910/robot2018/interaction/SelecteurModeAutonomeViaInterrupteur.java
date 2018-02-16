package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SelecteurModeAutonomeViaInterrupteur extends SelecteurModeAutonome implements RobotMap.SelecteurModeAutonome{

    protected DigitalInput interrupteur0 = new DigitalInput(INTERRUPTEUR_DIGITAL_0);
    protected DigitalInput interrupteur1 = new DigitalInput(INTERRUPTEUR_DIGITAL_1);
    protected DigitalInput interrupteur2 = new DigitalInput(INTERRUPTEUR_DIGITAL_2);
    protected DigitalInput interrupteur3 = new DigitalInput(INTERRUPTEUR_DIGITAL_3);

    protected Command commandeAutonome;
    
    public Command lireChoix()
    {
		if (interrupteur0.get() == true) //RED
		{
			if (interrupteur1.get() == true && interrupteur2.get() == true && interrupteur3.get() == true) //WTF
			{
				//commandeAutonome = new CommandeTrajetWTF();
			}
			else if (interrupteur1.get() == false && interrupteur2.get() == false && interrupteur3.get() == false) // No move
			{
				//commandeAutonome = new CommandeImmobile();
			}
			else if (interrupteur1.get() == true) //R1
			{
				//commandeAutonome = new CommandeTrajetR1();
			}
			else if (interrupteur2.get() == true) //R2
			{
				//commandeAutonome = new CommandeTrajetR2();
			}
			else if (interrupteur3.get() == true) //R3
			{
				//commandeAutonome = new CommandeTrajetR3();
			}
		}
		else // Blue
		{
			if (interrupteur1.get() == true && interrupteur2.get() == true && interrupteur3.get() == true) //WTF
			{
				//commandeAutonome = new CommandeTrajetWTF();
			}
			else if (interrupteur1.get() == false && interrupteur2.get() == false && interrupteur3.get() == false) // No move
			{
				//commandeAutonome = new CommandeImmobile();
			}
			else if (interrupteur1.get() == true) //B1
			{
				//commandeAutonome = new CommandeTrajetB1();
			}
			else if (interrupteur2.get() == true) //B2
			{
				//commandeAutonome = new CommandeTrajetB2();
			}
			else if (interrupteur3.get() == true) //B3
			{
				//commandeAutonome = new CommandeTrajetB3();
			}
		}
		return commandeAutonome;

    }
    
    
	public void afficherChoix() 
	{
		String trajetChoisi = "no Command selected";
		if (interrupteur0.get() == true) //Rouge
		{
			if (interrupteur1.get() == true && interrupteur2.get() == true && interrupteur3.get() == true) //WTF
			{
				trajetChoisi = " WTF";
			}
			else if (interrupteur1.get() == false && interrupteur2.get() == false && interrupteur3.get() == false) // No move
			{
				trajetChoisi = " No move";
			}
			else if (interrupteur1.get() == true)
			{
				trajetChoisi = " R1";
			}
			else if (interrupteur2.get() == true)
			{
				trajetChoisi = " R2";
			}
			else if (interrupteur3.get() == true)
			{
				trajetChoisi = " R3";
			}
		}
		else // Bleu
		{
			if (interrupteur1.get() == true && interrupteur2.get() == true && interrupteur3.get() == true) //WTF
			{
				trajetChoisi = " WTF";
			}
			else if (interrupteur1.get() == false && interrupteur2.get() == false && interrupteur3.get() == false) // No move
			{
				trajetChoisi = " No move";
			}
			else if (interrupteur1.get() == true)
			{
				trajetChoisi = " B1";
			}
			else if (interrupteur2.get() == true)
			{
				trajetChoisi = "B2";
			}
			else if (interrupteur3.get() == true)
			{
				trajetChoisi = " B3";	
			}
			
		}
		SmartDashboard.putString("TRAJET CHOISI", trajetChoisi);
		Timer.delay(0.2);
	}
	
}
