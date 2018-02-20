package org.firstchampionship.equipe5910.robot2018.auto;

import org.firstchampionship.equipe5910.robot2018.commande.CommandeRouesAvancer;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrajetAutoAvancerSeulement extends CommandGroup{
	
	public TrajetAutoAvancerSeulement()
	{
		addSequential(new CommandeRouesAvancer(5350));
	}
	
	protected void initialize(){
		System.out.println("Trajet1DDD");
	}
		
}
