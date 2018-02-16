package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SelecteurModeAutonomeViaDashBoard extends SelecteurModeAutonome{

    @SuppressWarnings("rawtypes")
	protected SendableChooser selecteur;
    
    @SuppressWarnings("rawtypes")
	public SelecteurModeAutonomeViaDashBoard()
    {
		// http://wpilib.screenstepslive.com/s/3120/m/7932/l/81109-choosing-an-autonomous-program-from-smartdashboard
		selecteur = new SendableChooser();
		//selecteur.addDefault("No move", new CommandeImmobile());
		SmartDashboard.putData("Choix de mode autonome", selecteur);    	
    }
    
    public Command lireChoix()
    {
    	return (Command)selecteur.getSelected();
    }


}
