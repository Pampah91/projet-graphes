package graphes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.StringTokenizer;


public class Graph {
	
//déclaration de variables

public int[] valeurs_diff_arcs;
public int[] nbre_sommets;
public int[] memo_length_SI_SF; // tableau qui stockera le nbre d'informations/valeurs de EI en [0] et EF en [1]
public int[] sommets_initiaux;
public int[] sommets_terminaux;
public int[] nbre_transitions;
public String[] transitions;

	/*public int compteur_taille() {
		
		return 1;
	}*/
	
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
		
		memo_length_SI_SF = new int[2];// tableau qui stockera le nbre d'information de EI en [0] et EF en [1]
		
		try {
			  String filename = null;
			  System.out.println("Quel graphe voulez vous ouvrir ? Exemple : graphe1.txt \nVotre graphe : ");
			  
			  Scanner input = new Scanner(System.in);
			  filename = input.nextLine();
			  input.close();
			  
			  System.out.println("");
			  
		      File file = new File(filename);
		      Scanner myReader = new Scanner(file);
		      
		      System.out.println("----Début fichier texte du graphe---- ");
		      
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
	        	
	        	else if (data.contains("Sommets_initiaux")) 
	        	{
	        		int i = 0; 
	        		int compt_taille_sespace = 0;// compteur pour connaître le nombre d'informations/valeurs de EI
	        		
	        		sommets_initiaux = new int[10];
		            data = myReader.nextLine();//sauter la ligne
		            
		            
		            
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	sommets_initiaux[i] = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.print(sommets_initiaux[i]+" ");// on affiche avec le get la valeur de Sortie
		            	i++;
		            	compt_taille_sespace++;
		            } 
		            
		            System.out.println(" ");// afficher un saut de ligne
		            
		            memo_length_SI_SF[0]=compt_taille_sespace;
		           // System.out.println("Test memo_length :"+ memo_length_EI_EF[0]);//test
		           //System.out.println(line);	 
	        	}
	        	
		      }
		      myReader.close();
		      
		      System.out.println("----FIN du fichier texte du graphe---- ");
		      
		    } catch (FileNotFoundException e) 
		      {
		      System.out.println("Une erreur est survenue ! Impossible de lire le fichier.");
		      e.printStackTrace();
		      }
		  
	}
	
	
		
	}
