package org.firstchampionship.equipe5910.robot2018;

import org.firstchampionship.equipe5910.robot2018.interaction.LecteurAttributionsAutonomes;
import org.firstchampionship.equipe5910.robot2018.trajet.Trajet1DDD;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ModeAutonome {

	public static int POSITION_DEPART_1 = 0;
	public static int POSITION_DEPART_2 = 1;
	public static int POSITION_DEPART_3 = 2;
	public static int COTE_GAUCHE = 0;
	public static int COTE_DROIT = 1;
	
	protected LecteurAttributionsAutonomes.Attribution attribution;
	protected int depart;
	
	protected CommandGroup[][][][] grille = new CommandGroup[3][2][2][2];
	
	public ModeAutonome()
	{
		this.grille[POSITION_DEPART_1][COTE_DROIT][COTE_DROIT][COTE_DROIT] = new Trajet1DDD();
		this.grille[POSITION_DEPART_1][COTE_DROIT][COTE_DROIT][COTE_GAUCHE] = new CommandGroup();
		this.grille[POSITION_DEPART_1][COTE_DROIT][COTE_GAUCHE][COTE_DROIT] = new CommandGroup();
		this.grille[POSITION_DEPART_1][COTE_DROIT][COTE_GAUCHE][COTE_GAUCHE] = new CommandGroup();
		
		this.grille[POSITION_DEPART_2][COTE_DROIT][COTE_DROIT][COTE_DROIT] = new CommandGroup();
		this.grille[POSITION_DEPART_2][COTE_DROIT][COTE_DROIT][COTE_GAUCHE] = new CommandGroup();
		this.grille[POSITION_DEPART_2][COTE_DROIT][COTE_GAUCHE][COTE_DROIT] = new CommandGroup();
		this.grille[POSITION_DEPART_2][COTE_DROIT][COTE_GAUCHE][COTE_GAUCHE] = new CommandGroup();
		
		this.grille[POSITION_DEPART_3][COTE_DROIT][COTE_DROIT][COTE_DROIT] = new CommandGroup();
		this.grille[POSITION_DEPART_3][COTE_DROIT][COTE_DROIT][COTE_GAUCHE] = new CommandGroup();
		this.grille[POSITION_DEPART_3][COTE_DROIT][COTE_GAUCHE][COTE_DROIT] = new CommandGroup();
		this.grille[POSITION_DEPART_3][COTE_DROIT][COTE_GAUCHE][COTE_GAUCHE] = new CommandGroup();
		
	}
	
	public CommandGroup obtenirTrajet(int depart, LecteurAttributionsAutonomes.Attribution attribution)
	{
		this.depart = depart;
		this.attribution = attribution;
		return this.grille[depart][attribution.premier.ordinal()][attribution.second.ordinal()][attribution.troisieme.ordinal()];
	}
}
