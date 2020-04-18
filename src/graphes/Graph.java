package graphes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	
//déclaration de variables

public int valeurs_diff_arcs;
public int nbre_sommets;
public int[] memo_length_SI_SF; // tableau qui stockera le nbre d'informations/valeurs de EI en [0] et EF en [1]
public int[] sommets_initiaux;
public int[] sommets_terminaux;
public int nbre_transitions;
public ArrayList<String> transitions_string = new ArrayList<String>();
public int[][] Global_valTableauSansSignetransitions;//tableau global de valTableauSansSignetransitions int [][]
public int[][] adjMatrix;
public int[][] ValueMatrix;

//static int arret_readAndStore;// stop la fonction à 1, continue le programme à 0


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
	int restart;// recommence la demande de graphe si restart=1 (lorque l'utilisateur se trompe sur le nom du fichier texte), si restart = 0 alors passons à la suite
	String filename = null;
	
	do {
		try {
			  
              System.out.println("Quel graphe voulez vous ouvrir ? Exemple : graphe1.txt \nVotre graphe : ");
			  Scanner input = new Scanner(System.in);
              filename = input.nextLine();
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
		            data = myReader.nextLine();//sauter la ligne  
		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	valeurs_diff_arcs = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.println(valeurs_diff_arcs); 
		            } 
	        	}
	        	
	        	else if (data.contains("Nbre_sommets")) 
	        	{
		            data = myReader.nextLine();//sauter la ligne	            		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	nbre_sommets = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.println(nbre_sommets);// on affiche avec le get la valeur de Sortie
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
	        	
	        	else if (data.contains("Sommets_terminaux")) 
	        	{
	        		int i = 0; 
	        		int compt_taille_sespace = 0;// compteur pour connaître le nombre d'informations/valeurs de EI
	        		
	        		sommets_terminaux = new int[10];
		            data = myReader.nextLine();//sauter la ligne
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	sommets_terminaux[i] = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.print(sommets_terminaux[i]+" ");// on affiche avec le get la valeur de Sortie
		            	i++;
		            	compt_taille_sespace++;
		            } 
		            
		            System.out.println(" ");// afficher un saut de ligne
		            
		            memo_length_SI_SF[1]=compt_taille_sespace; 
	        	}
	        	
	        	else if (data.contains("Nbre_transitions")) 
	        	{
		            data = myReader.nextLine();//sauter la ligne	            		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	nbre_transitions = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.println(nbre_transitions);// on affiche avec le get la valeur de Sortie
		            } 
		            //System.out.println(line);	  
	        	}
	        	
	        	else if (data.contains("Transitions")) 
	        	{
	        		int i=0;
	        		int valTableauSansSignetransitions[][] = new int[nbre_transitions][3];
		            data = myReader.nextLine();//sauter la ligne	            		            	
		            StringTokenizer val = new StringTokenizer(data," "); //" " indique qu'on utilise le séparateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            {   		
		            	transitions_string.add(val.nextToken());
		            }
		          System.out.println(transitions_string);

				  for (i=0; i<valTableauSansSignetransitions.length; i++)
				  {   
					  int j=0;
					  StringTokenizer val2 = new StringTokenizer(transitions_string.get(i),"'");//"'" indique qu'on utilise le séparateur de mots (de valeurs) '.
					  
				  	  while(val2.hasMoreTokens())
					  {
				  		valTableauSansSignetransitions[i][j]=Integer.parseInt(val2.nextToken());
						  //System.out.print(transitions_int[i][j]);//test
						  j++;
					  }
					 // System.out.println("");//test
				  }
				  Global_valTableauSansSignetransitions = valTableauSansSignetransitions ;
	        	}
		      }
		      myReader.close();
		      
		      System.out.println("----FIN du fichier texte du graphe---- ");
		      restart = 0;
		      
		    }catch (FileNotFoundException e) 
		      {
		       System.out.println("Erreur! Le fichier \" "+filename+" \" n'existe pas.");
		       restart=1;
		       //e.printStackTrace();
		  }
		
	   }while(restart != 0);
	}
	
	public int nbrArcsEntreSommets(int sommetA, int sommetB) {
		
		int compteurArcs = 0; 
        
        for(int i=0; i < transitions_string.size(); i++) {        
            
            String elem = transitions_string.get(i);
            String [] temp = elem.split("'");

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
		
		int[][] matrix = new int[nbre_sommets][nbre_sommets];
		
		// Affichage de la matrice
		
		for(int i = 0; i < nbre_sommets; i++)
		{			   
			for(int j = 0; j < nbre_sommets; j++)
			{
				 matrix[i][j] = nbrArcsEntreSommets(i, j);
		    }			  
		}
		
		adjMatrix = matrix;
		
		
		for(int i = 0; i < nbre_sommets; i++){
			   
			for(int j = 0; j < nbre_sommets; j++){
				 //System.out.println(adjMatrix);
			     System.out.print(adjMatrix[i][j] + " | ");
			   }
			  System.out.println("");
			  System.out.println("");
		}	
		return adjMatrix;
	}
	
	public void matrice_des_valeurs() {
		
		int[][] matrix = new int[nbre_sommets][nbre_sommets];
		int valeur_Inexistant = -999;// valeur de l'arc si l'arc n'existe pas dans le tableau matrice des valeurs
		
		for(int i=0;i<nbre_sommets;i++)
		{
			for(int j=0;j<nbre_sommets;j++)
			{
				matrix[i][j] = valeur_Inexistant;// on initialise toute la matrice des valeurs avec la valeur inexistant
				//System.out.print(matrix[i][j]+"|");//test
			}
			//System.out.println("");//test
		}
		//System.out.println("");//test
		
		for(int i=0;i<Global_valTableauSansSignetransitions.length;i++)
		{
			for(int j=0;j<Global_valTableauSansSignetransitions[i].length;j++)
			{
				matrix[Global_valTableauSansSignetransitions[i][0]][Global_valTableauSansSignetransitions[i][2]] = Global_valTableauSansSignetransitions[i][1];// on place les valeurs des arcs à la position souhaiter dans la matrice des valeurs
			}			
		}
		
		ValueMatrix = matrix;
		
		//affichage test de matrice des valeurs
		for(int i=0;i<nbre_sommets;i++)
		{
			for(int j=0;j<nbre_sommets;j++)
			{
				if(matrix[i][j] == -999)
				{
					System.out.print("X |");//test
				}
				else
				{
					if(matrix[i][j] < 10 && matrix[i][j] >= 0)
					{
						System.out.print(matrix[i][j]+" |");
					}
					else 
					{
						System.out.print(matrix[i][j]+"|");
					}				
				}
			}
			System.out.println("");//test
		}
	}
	
	// Calcul des degrés / demi-degrés
	
	public int ddExt(int sommet) { 
		int dde = 0;
		
		/* A partir de la matrice d'adjacence :
		 * somme des coefficients sur la ligne correspondant au sommet choisi 
		 */
		
		for (int j = 0; j < nbre_sommets; j++) {
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
		
		for (int i = 0; i < nbre_sommets; i++) {
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
