package fr.m2i.mpps.api.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.m2i.mpps.api.model.ToDoElement;

public class GestBDD {

public static Connection connection;
	
	public void connection() {
		
		try {
			//étape 1 : charger la classe de driver
			Class.forName("com.mysql.jdbc.Driver");
            
			//étape 2 : créer l'objet de connexion
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todospring",
	                "root", null);
       
             System.out.println("connexion ok....");
             
	     } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

		}
	
	
	 public List<ToDoElement> afficherToDo() {       
         
		 List<ToDoElement> elementBDD = new ArrayList<ToDoElement>() ;
            
   	  try {
           
           Statement stmt = connection.createStatement();            
           ResultSet rs = stmt.executeQuery("select * from todolist");
              
           while (rs.next()) {
        	   	int id = rs.getInt("id");
        	   	String titre = rs.getString("titre");
        	   	String description = rs.getString("description");
                
        	   	ToDoElement element = new ToDoElement(id, titre, description);
                elementBDD.add(element);
                   
           }
           
           rs.close();
           stmt.close();
          
           
   	  } catch (SQLException e) {
 	        // TODO Auto-generated catch block
 	        e.printStackTrace();
 	    }
   	  
   	  
   	  return elementBDD;
   	  
     }
     
   
	
	public void AjoutDansBdd(String tache) throws Exception {
		
		//System.out.println("Ajout d'un élément : ");
		
		if (tache.equals ("Faire dodo"))
		throw new Exception("Cette tâche n'est pas autorisée !");
		
		else {
		
			String sql = "INSERT INTO listetaches (tache) VALUES (?) ";
			
			PreparedStatement ps = connection.prepareStatement (sql);
			
			ps.setString(1, tache);
			System.out.println("Elément ajouté : " + tache );
			
			ps.execute();
			ps.close();
		    
		}	
	}
	
	
	public void SuppDansBdd(int id){
		
		//System.out.println("Suppression d'un élément : ");
		
		try {
			String sql = "DELETE FROM listetaches WHERE id =?";
			
			PreparedStatement ps = connection.prepareStatement (sql);
			
			ps.setInt(1, id);
			System.out.println("ID n° " + id + " supprimé" );
			
			ps.execute();
			
			ps.close();
		}
		
			catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
				
	}	
	

	  public void close() {       
         try {
         connection.close();
         } catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         
 }  
}
