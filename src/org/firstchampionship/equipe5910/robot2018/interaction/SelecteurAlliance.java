package org.firstchampionship.equipe5910.robot2018.interaction;

import edu.wpi.first.wpilibj.DigitalInput;

public class SelecteurAlliance {

	public static final int CURSEUR_ALLIANCE = 17; // TODO deplacer dans RobotMap
	public static final boolean ALLIANCE_BLEUE = false;
	public static final boolean ALLIANCE_ROUGE = true;
	
    protected DigitalInput curseurAlliance = null;
    
    private SelecteurAlliance()
    {
        this.curseurAlliance = new DigitalInput(CURSEUR_ALLIANCE);
    }
    
    protected static SelecteurAlliance instance = null;
    static public SelecteurAlliance getInstance()
    {
    	if(null == instance) instance = new SelecteurAlliance();
    	return instance;
    }

    public boolean estDansAllianceBleue() // verbe conjugue car question booleenne
    {
    	return (this.curseurAlliance.get() == ALLIANCE_BLEUE);
    }
	
    public boolean estDansAllianceRouge() // verbe conjugue car question booleenne
    {
    	return (this.curseurAlliance.get() == ALLIANCE_ROUGE);
    }
}
