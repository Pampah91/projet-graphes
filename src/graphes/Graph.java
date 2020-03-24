package graphes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
	
	public void readFile() {
		
		try {
			  String filename = null;
			  System.out.println("Quel graphe voulez vous ouvrir ? Exemple : graphe1.txt \nVotre graphe : ");
			  
			  Scanner input = new Scanner(System.in);
			  filename = input.nextLine();
			  input.close();
			  
			  
		      File file = new File(filename);
		      Scanner myReader = new Scanner(file);
		      
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Une erreur est survenue ! Impossible de lire le fichier.");
		      e.printStackTrace();
		    }
		  
	}

}
