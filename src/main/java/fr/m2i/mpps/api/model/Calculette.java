package fr.m2i.mpps.api.model;

public class Calculette {
	
	
	private int valeur1, valeur2;
	
	
	public int getValeur1() {
		return valeur1;
	}

	public void setValeur1(int valeur1) {
		this.valeur1 = valeur1;
	}

	public int getValeur2() {
		return valeur2;
	}

	public void setValeur2(int valeur2) {
		this.valeur2 = valeur2;
	}

	
	public Calculette(int valeur1, int valeur2) {
		this.valeur1=valeur1;
		this.valeur2=valeur2;	
		
	}
	
	
	public int addition() {
		return valeur1 + valeur2;
	}
	
	
	public int soustraction() {
		return valeur1 - valeur2;
	}
	
	public int multiplication() {
		return valeur1 * valeur2;
	}
	
	public int division() {
		return valeur1 / valeur2;
	}
	
	public int factorielle() {
	        int f = 1;
	        for (int i=1; i<=valeur1; i++)
	        f=f*i;
	        return(f);
	    }

}
