package graphes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.StringTokenizer;


public class Graph {
	
//déclaration de variables
public int[] valeurs_diff_arcs;
public int[] nbre_sommets;
public int[] etats_initiaux;
public int[] etats_terminaux;
public int[] nbre_transitions;
public int[][] adjMatrix;
ArrayList<String> transitions=new ArrayList<String>();

	public void readallFile() {
		
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
		    } catch (FileNotFoundException e) 
		    {
		      System.out.println("Une erreur est survenue ! Impossible de lire le fichier.");
		      e.printStackTrace();
		    }
		  
	}
	
	public void readAndStore() {
		
		try {
			  String filename = null;
			  System.out.println("Quel graphe voulez vous ouvrir ? Exemple : graphe1.txt \nVotre graphe : ");
			  
			  Scanner input = new Scanner(System.in);
			  filename = input.nextLine();
			  input.close();
			  
			  System.out.println("");
			  
		      File file = new File(filename);
		      Scanner myReader = new Scanner(file);
		      
		      
		      while (myReader.hasNextLine()) 
		      {
		        String data = myReader.nextLine();
		        System.out.println(data);
	        	
	        	if (data.contains("Valeurs_diff_arcs")) 
	        	{
	        		int i=0;
	        		valeurs_diff_arcs = new int[1];
		            data = myReader.nextLine();//sauter la ligne  
		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	valeurs_diff_arcs[i] = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.println(valeurs_diff_arcs[i]); 
		               	i++;
		            } 
		            	//System.out.println(line); // on affiche la ligne
	        	}
	        	
	        	else if (data.contains("Nbre_sommets")) 
	        	{
	        		int i = 0;
	        		nbre_sommets = new int[1];
		            data = myReader.nextLine();//sauter la ligne	            		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	
		            	nbre_sommets[i] = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.println(nbre_sommets[i]);// on affiche avec le get la valeur de Sortie
		            	i++;

		            } 
		            //System.out.println(line);	  
	        	}
	        	
	        	else if (data.contains("Etats_initiaux")) 
	        	{
	        		int i = 0;
	        		etats_initiaux = new int[3];
		            data = myReader.nextLine();//sauter la ligne	            		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	
		            	etats_initiaux[i] = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.println(etats_initiaux[i]);// on affiche avec le get la valeur de Sortie
		            	i++;

		            } 
		            //System.out.println(line);	  
	        	}
	        	else if (data.contains("Transitions")) 
	        	{
	        		
		            data = myReader.nextLine();//sauter la ligne	            		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	
		            	transitions.add(val.nextToken());

		            }
		          System.out.println(transitions);
	        	}
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) 
		      {
		      System.out.println("Une erreur est survenue ! Impossible de lire le fichier.");
		      e.printStackTrace();
		      }
		  
	}
	
	public int nbrArcsEntreSommets(int sommetA, int sommetB) {
		int compteurArcs = 0;
		
		
		for(int i=0; i < transitions.size(); i++) {        
            
            String elem = transitions.get(i);
            String [] temp = elem.split("/");

            List<String> al = new ArrayList<String>();
            al = Arrays.asList(temp);
            
            int valeur1 = Integer.valueOf(al.get(0)); // on convertit le string en int pour pouvoir comparer
            int valeur2 = Integer.valueOf(al.get(2));
           
            if(valeur1 == sommetA &&  valeur2 == sommetB) {
                compteurArcs++;
             }
        }
		
		
		return compteurArcs;
	}
	
	
	public int[][] dispAdjMatrix() {	
		int[][] matrix = new int[nbre_sommets[0]][nbre_sommets[0]];
		
		
		// Affichage de la matrice
		
		for(int i = 0; i < nbre_sommets[0]; i++){
			   
			for(int j = 0; j < nbre_sommets[0]; j++){
				 matrix[i][j] = nbrArcsEntreSommets(i, j);
			   }
			  
		}
		
		adjMatrix = matrix;
		
		
		for(int i = 0; i < nbre_sommets[0]; i++){
			   
			for(int j = 0; j < nbre_sommets[0]; j++){
				 //System.out.println(adjMatrix);
			     System.out.print(adjMatrix[i][j] + " | ");
			     
			     
			   }
			  System.out.println("");
			  System.out.println("");
		}	
		return adjMatrix;
	}
	

	
	// Calcul des degrés / demi-degrés
	
	public int ddExt(int sommet) { 
		int dde = 0;
		
		/* A partir de la matrice d'adjacence :
		 * somme des coefficients sur la ligne correspondant au sommet choisi 
		 */
		
		for (int j = 0; j < nbre_sommets[0]; j++) {
			// on somme les éléments
			dde = dde + adjMatrix[sommet][j];
		}
		return dde;
	}
	
	public int ddInt(int sommet) { 
		int ddi = 0;
		
		/* A partir de la matrice d'adjacence :
		 * somme des coefficients sur la colonne correspondant au sommet choisi 
		 */
		
		for (int i = 0; i < nbre_sommets[0]; i++) {
			// on somme les éléments
			ddi = ddi + adjMatrix[i][sommet];
		}
		return ddi;
	}
	
	public int deg(int sommet) {
		int degValue;
		
		int demiDegInt = ddInt(sommet);
		int demiDegExt = ddExt(sommet);
		
		degValue = demiDegInt + demiDegExt;
		
		return degValue;
	}

		
}