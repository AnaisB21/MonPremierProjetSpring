package fr.m2i.mpps.api.model;

import com.fasterxml.jackson.annotation.JsonView;

public class ToDoElement {

		// champs
	
		@JsonView(IToDoElementRestrictif.class)
		private String titre;
		@JsonView(IToDoElementRestrictif.class)
		private String description;
		@JsonView(IToDoElement.class)
		private int id;		

		// getters et setters
	
		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
	

		// constructeur
		
		public ToDoElement(int id, String titre, String description) {
			super();
			this.titre = titre;
			this.description = description;
			this.id = id;
		}

		//constructeur par défaut vide
		
		public ToDoElement() {
			super();
		}
}
