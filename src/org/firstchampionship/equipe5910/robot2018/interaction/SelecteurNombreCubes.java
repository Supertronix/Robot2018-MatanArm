package org.firstchampionship.equipe5910.robot2018.interaction;

import org.firstchampionship.equipe5910.robot2018.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;

public class SelecteurNombreCubes implements RobotMap.SelecteurNombreCube{
	
    protected DigitalInput activateurDeuxCubes = null;
    
    private SelecteurNombreCubes()
    {
        this.activateurDeuxCubes = new DigitalInput(ACTIVATION_DEUX_CUBES);
    }
    
    protected static SelecteurNombreCubes instance = null;
    static public SelecteurNombreCubes getInstance()
    {
    	if(null == instance) instance = new SelecteurNombreCubes();
    	return instance;
    }

    public boolean viseDeuxCube() // verbe conjugue car question booleenne
    {
    	return this.activateurDeuxCubes.get();
    }

}
