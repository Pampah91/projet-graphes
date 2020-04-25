package graphes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	
//d�claration de variables

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
public int[][] mft;

	public void readAndStore() {
		
	memo_length_SI_SF = new int[2];// tableau qui stockera le nbre d'information de EI en [0] et EF en [1]
	int restart;// recommence la demande de graphe si restart=1 (lorque l'utilisateur se trompe sur le nom du fichier texte), si restart = 0 alors passons � la suite
	String filename = null;
	
	do {
		try {
			  
              System.out.println("Quel graphe voulez vous ouvrir ? Exemple : graphe1.txt \nVotre graphe : ");
			  Scanner input = new Scanner(System.in);
              filename = input.nextLine();
			  System.out.println("");
		
		      File file = new File(filename);
		      Scanner myReader = new Scanner(file);
		      
		      System.out.println("----D�but fichier texte du graphe---- ");
		      
		      while (myReader.hasNextLine()) 
		      {
		        String data = myReader.nextLine();
		        System.out.println(data);
	        	
	        	if (data.contains("Valeurs_diff_arcs")) 
	        	{
		            data = myReader.nextLine();//sauter la ligne  
		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le s�parateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            { 
		            	valeurs_diff_arcs = Integer.parseInt(val.nextToken()); //le tableau prend l'entier
		            	System.out.println(valeurs_diff_arcs); 
		            } 
	        	}
	        	
	        	else if (data.contains("Nbre_sommets")) 
	        	{
		            data = myReader.nextLine();//sauter la ligne	            		            	
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le s�parateur de mots (de valeurs) espace.
		            
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
	        		int compt_taille_sespace = 0;// compteur pour conna�tre le nombre d'informations/valeurs de EI
	        		
	        		sommets_initiaux = new int[10];
		            data = myReader.nextLine();//sauter la ligne
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le s�parateur de mots (de valeurs) espace.
		            
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
	        		int compt_taille_sespace = 0;// compteur pour conna�tre le nombre d'informations/valeurs de EI
	        		
	        		sommets_terminaux = new int[10];
		            data = myReader.nextLine();//sauter la ligne
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le s�parateur de mots (de valeurs) espace.
		            
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
		            StringTokenizer val = new StringTokenizer(data," "); // ici point important: ," " indique qu'on utilise le s�parateur de mots (de valeurs) espace.
		            
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
		            StringTokenizer val = new StringTokenizer(data," "); //" " indique qu'on utilise le s�parateur de mots (de valeurs) espace.
		            
		            while(val.hasMoreTokens()) //tant que il y a encore des valeurs
		            {   		
		            	transitions_string.add(val.nextToken());
		            }
		          System.out.println(transitions_string);

				  for (i=0; i<valTableauSansSignetransitions.length; i++)
				  {   
					  int j=0;
					  StringTokenizer val2 = new StringTokenizer(transitions_string.get(i),"'");//"'" indique qu'on utilise le s�parateur de mots (de valeurs) '.
					  
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
        //System.out.println("l230, test compteursArcs="+compteurArcs);//test
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
				matrix[Global_valTableauSansSignetransitions[i][0]][Global_valTableauSansSignetransitions[i][2]] = Global_valTableauSansSignetransitions[i][1];// on place les valeurs des arcs � la position souhaiter dans la matrice des valeurs
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
	
	// Calcul des degr�s / demi-degr�s
	
	public int ddExt(int sommet) { 
		int dde = 0;
		
		/* A partir de la matrice d'adjacence :
		 * somme des coefficients sur la ligne correspondant au sommet choisi 
		 */
		
		for (int j = 0; j < nbre_sommets; j++) {
			// on somme les �l�ments
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
			// on somme les �l�ments
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
	
	public void Matrice_adjacence_fermetureTransitive() {
		
		int x=0; //sommet actuel
		int y=0; //Pr�d�cesseur de x
		int z=0; //Successeur de x
		mft = adjMatrix;// G' = G
		
		for(x=0;x<nbre_sommets;x++) //on parcourt l'ensemble des sommets
		{
			System.out.println("Etape x = "+x);
			
			for(y=0;y<nbre_sommets;y++) //Pour le sommet x qu'on �tudie, on parcourt l'ensemble des sommets
			{
				for(z=0;z<nbre_sommets;z++) //Pour le sommet x et y qu'on �tudie, on parcourt l'ensemble des sommets
				{
					if(mft[y][x]==1 && mft[x][z]==1)// si le sommet x est un int�merdiaire entre deux sommets y=pr�d�cesseur et z=successeur
					{//alors on cr�er un arc entre le pr�d�cesseur y et le successeur z de x.
						mft[y][z]=1;
					}	
					else 
					{
						//Sinon, on ne modifie rien.
					}
					System.out.print(mft[y][z]+" | ");
				}
				System.out.println("");
			}
			System.out.println("");
		}	
	}
	
	public boolean detection_circuit(){
		
		 // on consid�re que mft est le tableau 2D repr�sentant la matrice fermeture transitive
		 boolean thereIsACircuit = false;
		 int i=0;		 
		
		 while(i<mft.length && thereIsACircuit == false) 
		 {
			 if(mft[i][i] == 1)
			 {
				 thereIsACircuit = true;
			 }
		   i++;
		 }
	  return thereIsACircuit;
	}
	
	public void initialisation_rang_sommets(){
		
		
		
	}
	
	public void remove_arraylist_transitions_string()
	{
		int memo_transitionsize = transitions_string.size();		
		//System.out.println("l404 test size = "+memo_transitionsize);//test
		
		for(int i=0;i<memo_transitionsize;i++)
		{
			//System.out.println("l404 test i = "+i);//test
			transitions_string.remove(0);
		}
	}
	
	
	/*
	 * ORDONNANCEMENT
	 */
	/* V�rification des points d'entr�es et de sorties */
   
   // Le graphe a-t-il un unique point d'entr�e et un unique point de sortie ?
      // est un point d'entr�e tout sommet x qui v�rifie d�-(x) = 0
	
	 public boolean isEntryPoint(int sommet) {
	        
	        boolean answer = false;
	        
	        if(ddInt(sommet) == 0) {
	        	answer = true;
	        }
	        return answer;    
	    }
	 
	 public boolean hasUniqueEntryPoint() {
		 boolean unique = false;
		 int compteurSommets = 0;
		 
		 for (int i = 0; i < nbre_sommets; i++) {
			 if(ddInt(i) == 0) {
				 compteurSommets++;    	
		     }	 
		 }
		 
		 if(compteurSommets == 1) {
			 unique = true;
		 }
		 
		 return unique;
	 }
	 
	 public boolean isExitPoint(int sommet) {
	        
	        boolean answer = false;
	        
	        if(ddExt(sommet) == 0) {
	        	answer = true;
	        }
	        return answer;    
	    }
	 
	 public boolean hasUniqueExitPoint() {
		 boolean unique = false;
		 int compteurSommets = 0;
		 
		 for (int i = 0; i < nbre_sommets; i++) {
			 if(ddExt(i) == 0) {
				 compteurSommets++;    	
		     }	 
		 }
		 
		 if(compteurSommets == 1) {
			 unique = true;
		 }
		 
		 return unique;
	 }
	
	 
	 //Fonction de d�tection de circuit un peu plus haut
}
