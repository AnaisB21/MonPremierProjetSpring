package fr.m2i.mpps.api.model;

//import lombok.Getter;

public class Personne {

	//ici on déclare nos variables avec l'annotation @getter pour que les getters se fassent automatiquement avec Lambok
	//@Getter public String nom, prenom;
	
	//champs
	private String nom, prenom;
	
	//getters et setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	//constructeur
	public Personne(String prenom, String nom) {
		this.nom=nom;
		this.prenom=prenom;
		
	}
	
}
