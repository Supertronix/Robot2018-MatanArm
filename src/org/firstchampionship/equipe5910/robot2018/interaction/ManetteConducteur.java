package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasAllonger;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeBrasRetrecir;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesActiverVitesseBasse;
import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesActiverVitesseElevee;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ManetteConducteur implements RobotMap.ManetteConducteur{
	
	protected Joystick manettePrincipale;
	
	protected JoystickButton selecteurVitesseElevee;
	protected JoystickButton selecteurVitesseBasse;

	// test
	protected JoystickButton selecteurPinceOuverte;
	protected JoystickButton selecteurPinceFermee;
	protected JoystickButton selecteurBrasAllonge;
	protected JoystickButton selecteurBrasRetreci;
	
	public ManetteConducteur(){
		this.manettePrincipale = new Joystick(MANETTE_CONDUCTEUR);
		
		this.selecteurVitesseElevee = new JoystickButton(manettePrincipale, BOUTON_HAUTE_VITESSE);
		this.selecteurVitesseElevee.whenPressed(new CommandeRouesActiverVitesseElevee());
		this.selecteurVitesseBasse = new JoystickButton(manettePrincipale, BOUTON_BASSE_VITESSE);
		this.selecteurVitesseBasse.whenPressed(new CommandeRouesActiverVitesseBasse());
		
		// boutons temporaires pour test
		this.selecteurBrasAllonge = new JoystickButton(this.manettePrincipale, BOUTON_Y);
		this.selecteurBrasAllonge.whenPressed(new CommandeBrasAllonger());
		this.selecteurBrasRetreci = new JoystickButton(this.manettePrincipale, BOUTON_A);
		this.selecteurBrasRetreci.whenPressed(new CommandeBrasRetrecir());
		//this.selecteurPinceOuverte = new JoystickButton(this.manettePrincipale, BOUTON_DEMARRER);
		//this.selecteurPinceOuverte.whenPressed(new CommandePinceOuvrir());
		//this.selecteurPinceFermee = new JoystickButton(this.manettePrincipale, BOUTON_RETOUR);
		//this.selecteurPinceFermee.whenPressed(new CommandePinceFermer());
		
		this.selecteurSpectacleFlash = new JoystickButton(this.manettePrincipale, BOUTON_DROIT);
		this.selecteurSpectacleFlash.whenPressed(new AnimateurLed.CommandeLedActiverFlash());
		this.selecteurSpectacleFlash.whenReleased(new AnimateurLed.CommandeLedEteindreFlash());
		
		
	}
	
	public double getAvancer(){
		// System.out.println("getAvancer()" + manettePrincipale.getRawAxis(GACHETTE_DROITE) );
		return manettePrincipale.getRawAxis(GACHETTE_DROITE);
	}
	
	public double getReculer(){
		return manettePrincipale.getRawAxis(GACHETTE_GAUCHE);
	}
	
	public double getTournerSurPlace(){
		return manettePrincipale.getRawAxis(0);
	}
	
	public double getdirection(){
		return manettePrincipale.getRawAxis(0);
	}
	
	public boolean veuxAvancer(){
		return manettePrincipale.getRawAxis(GACHETTE_DROITE) > manettePrincipale.getRawAxis(GACHETTE_GAUCHE);
	}
	
	public boolean veuxReculer(){
		return  manettePrincipale.getRawAxis(GACHETTE_GAUCHE) > manettePrincipale.getRawAxis(GACHETTE_DROITE);
	}
	
	public boolean veuxTournerSurPlace(){
		return manettePrincipale.getRawAxis(0) != 0;
	}
	
	public double getY1(){
		return manettePrincipale.getRawAxis(1);
	}
	public double getY2(){
		return manettePrincipale.getRawAxis(5);
	}
	
	public double getAxeDescend(){
		return manettePrincipale.getRawAxis(2);
	}
	public double getAxeMonte(){
		return manettePrincipale.getRawAxis(3);
	}
	
	
	
}
