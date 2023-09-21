package fr.m2i.mpps.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.m2i.mpps.api.model.IToDoElement;
import fr.m2i.mpps.api.model.IToDoElementRestrictif;
import fr.m2i.mpps.api.model.ToDoElement;
import fr.m2i.mpps.api.model.ToDoElement;
import fr.m2i.mpps.api.service.ToDoService;

@RestController
@RequestMapping ("/apitodo")
public class ServiceController {

		//exercice : 3
	
		ToDoService toDoOctobre; //ici je déclare mon service plus besoin d'instancier avec un new, Spring le fait automatiquement!
		
		public ServiceController(@Autowired ToDoService toDoService) {
			this.toDoOctobre=toDoService; // on injecte qqch qu'on a dans la mémoire vive
		}
		
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		@JsonView(IToDoElementRestrictif.class)
		public List<ToDoElement> afficher() {
			toDoOctobre.testConnection();
			return toDoOctobre.afficher();
		}
		
		
		@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(code=HttpStatus.CREATED)
		public void ajouter (@RequestBody ToDoElement tache) { //module jackson
			this.toDoOctobre.ajouter(tache);
		}
		
		@DeleteMapping
		public void supprimer (@RequestParam int index) { //...?index=1
			ToDoElement toDoElement = toDoOctobre.getToDoListe().get(index);
			this.toDoOctobre.supprimer(toDoElement);
		}
		
		@PatchMapping
		public void modifier (@RequestParam int index,@RequestBody ToDoElement tache ) {
			this.toDoOctobre.modifier(index, tache);
		}
	
}
