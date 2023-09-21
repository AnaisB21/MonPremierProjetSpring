package fr.m2i.mpps.api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.m2i.mpps.api.bdd.GestBDD;
import fr.m2i.mpps.api.model.ToDoElement;

@Service
public class ToDoService {

	List<ToDoElement> toDoListe ; //identifiant > déclaration
	
	
	public ToDoService() {
		this.toDoListe = new LinkedList<>(); //contenant > initialisation
	}
	
	
	//Getter
	
	public List<ToDoElement> getToDoListe() {
		return toDoListe;
	}

	
	//création des méthodes CRUD (=boîte à outils)
	
	public void testConnection () {
		GestBDD bdd = new GestBDD();
		bdd.connection();
		}	
	
	public void ajouter (ToDoElement tache) {
		this.toDoListe.add(tache);
	}
	
	public List<ToDoElement> afficher() {
		return this.toDoListe;
	}
	
	public void supprimer (ToDoElement tache) {
		this.toDoListe.remove(tache);
	}
	
	public void modifier ( int index, ToDoElement tache) {
		this.toDoListe.set(index, tache);
	}
	
	
}
