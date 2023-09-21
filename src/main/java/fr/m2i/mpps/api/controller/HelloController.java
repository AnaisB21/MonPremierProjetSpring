package fr.m2i.mpps.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.mpps.api.model.Calculette;
import fr.m2i.mpps.api.model.Personne;
import fr.m2i.mpps.api.model.ToDoElement;
import fr.m2i.mpps.api.service.ToDoService;

@RestController
@RequestMapping ("/api")

public class HelloController {

	
	//exercice : 1
	@GetMapping (path="/sayhello")
	public String sayHello() {
		Personne personne = new Personne("Anaïs", "BERTA");
		return "Bonjour " + personne.getPrenom() + " " + personne.getNom() ;
	}
	
	@GetMapping (path="/toctoc")
	public String toctoc () {
		return "Qui est là?";
	}
	
	@GetMapping (path="/listepersonne")
	public List<Personne> listePersonne(){
		List<Personne> liste = new ArrayList<>(); // on créé une liste de type List et après on spécifie quel type de liste
		
		liste.add(new Personne ("PONPON","Michel"));
		liste.add(new Personne ("DUPONT", "Albert"));
		
		return liste;
	}
	
	@PostMapping
	public String spring () {
		return "C'est trop cool !!! ";
	}
	
	
	//exercice : 2
	@PostMapping (path="/addition", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addition(@RequestBody Calculette calculette) {
		System.out.println("Résultat addition :" + calculette.addition());		
	}
	
	@PostMapping (path="/soustraction", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void soustraction(@RequestBody Calculette calculette) {
		System.out.println("Résultat soustraction :" + calculette.soustraction());		
	}
	
	@PostMapping (path="/multiplication", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void multiplication(@RequestBody Calculette calculette) {
		System.out.println("Résultat multiplication :" + calculette.multiplication());		
	}
	
	@PostMapping (path="/division", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void division(@RequestBody Calculette calculette) {
		System.out.println("Résultat division :" + calculette.division());		
	}
	
	@PostMapping (path="/factorielle", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void factorielle(@RequestBody Calculette calculette) {
		System.out.println("Résultat factorielle :" + calculette.factorielle());		
	}
	
	
	
}
