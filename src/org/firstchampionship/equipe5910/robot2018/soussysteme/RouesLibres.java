package org.firstchampionship.equipe5910.robot2018.soussysteme;

public class RouesLibres extends Roues{
		
	public RouesLibres()
	{
		super();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////  CONDUITE  /////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////	
	
	public void avancer(double demandeVitesse, double direction){
		//String etatVitesse = "";
		if(Math.abs(demandeVitesse) > 0.5){
			tournerHauteVitesse(demandeVitesse, direction);
			//etatVitesse = "haute";
		}
		else if(Math.abs(demandeVitesse) < 0.3){
			tournerBasseVitesse(demandeVitesse, direction);
			//etatVitesse = "basse";
		}
		else{
			tournerMoyenneVitesse(demandeVitesse, direction);
			//etatVitesse = "moyenne";
		}
		//System.out.println(etatVitesse + " vitesse roue gauche " + roueGauche.get());
	}
	
	public void avancer(double demandeVitesse){
		roueGauche.set(demandeVitesse);
		roueDroite.set(-demandeVitesse);
	}
	
	public void reculer(double demandeVitesse){
		roueGauche.set(-demandeVitesse);
		roueDroite.set(demandeVitesse);
	}
	
	public void reculer(double demandeVitesse, double direction){
		//String etatVitesse = "";
		if(Math.abs(demandeVitesse) > 0.5){
			tournerHauteVitesseEnReculant(demandeVitesse, direction);
			//etatVitesse = "haute";
		}
		else if(Math.abs(demandeVitesse) < 0.3){
			tournerBasseVitesseEnReculant(demandeVitesse, direction);
			//etatVitesse = "basse";
		}
		else{
			tournerMoyenneVitesseEnReculant(demandeVitesse, direction);
			//etatVitesse = "moyenne";
		}
		//System.out.println(etatVitesse + " vitesse roue gauche " + roueGauche.get());
	}
	
	public void arreter(){
		roueGauche.set(0);
		roueDroite.set(0);
	}

	//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////  ROTATION  /////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	
	public void tournerHauteVitesse(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(demandeVitesse);
			roueDroite.set(-demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(demandeVitesse * coefficientDirection);
			roueDroite.set(-demandeVitesse);
			//System.out.println("gauche"+Math.abs(direction));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			
			roueGauche.set(demandeVitesse );
			roueDroite.set(-demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerMoyenneVitesse(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(demandeVitesse);
			roueDroite.set(-demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(demandeVitesse * coefficientDirection);
			roueDroite.set(-demandeVitesse * 2);
			//System.out.println("gauche"+ demandeVitesse * (1 - Math.abs(direction)));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			roueGauche.set(demandeVitesse * 2);
			roueDroite.set(-demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerBasseVitesse(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(demandeVitesse);
			roueDroite.set(-demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(demandeVitesse * coefficientDirection);
			roueDroite.set(-demandeVitesse * 3);
			//System.out.println("gauche"+Math.abs(direction));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			roueGauche.set(demandeVitesse * 3);
			roueDroite.set(-demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerHauteVitesseEnReculant(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(-demandeVitesse);
			roueDroite.set(demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			roueGauche.set(-demandeVitesse * coefficientDirection);
			roueDroite.set(demandeVitesse);
			//System.out.println("gauche"+Math.abs(direction));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			
			roueGauche.set(-demandeVitesse );
			roueDroite.set(demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerMoyenneVitesseEnReculant(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(-demandeVitesse);
			roueDroite.set(demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			roueGauche.set(-demandeVitesse * coefficientDirection);
			roueDroite.set(demandeVitesse * 2);
			//System.out.println("gauche"+ demandeVitesse * (1 - Math.abs(direction)));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(-demandeVitesse * 2);
			roueDroite.set(demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerBasseVitesseEnReculant(double demandeVitesse, double direction){
		double coefficientDirection;
		if(direction >= -0.15 && direction <= 0.15){
			roueGauche.set(-demandeVitesse);
			roueDroite.set(demandeVitesse);
			//System.out.println("avant"+Math.abs(direction));
		}
		else if(direction < 0){
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = 0.5;
			}
			roueGauche.set(-demandeVitesse * coefficientDirection);
			roueDroite.set(demandeVitesse * 3);
			//System.out.println("gauche"+Math.abs(direction));
		}
		else{
			coefficientDirection = 1 - Math.abs(direction);
			if(coefficientDirection == 0){
				coefficientDirection = -0.5;
			}
			roueGauche.set(-demandeVitesse * 3);
			roueDroite.set(demandeVitesse  * coefficientDirection);
			//System.out.println("droite"+Math.abs(direction));
		}
	}
	
	public void tournerSurPlace(double demandeVitesse){
		if(demandeVitesse >= -0.15 && demandeVitesse <= 0.15){
			roueGauche.set(0);
			roueDroite.set(0);
			//System.out.println("arret"+Math.abs(demandeVitesse));
		}
		else{
			roueGauche.set(demandeVitesse);
			roueDroite.set(demandeVitesse);
			//System.out.println("tourne"+Math.abs(demandeVitesse));
		}	
	}
}
