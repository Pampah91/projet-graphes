package graphes;

//import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {

	/*public static int[] valeurs_diff_arcs;
	public static int[] nbre_sommets;
	public static int[] etats_initiaux;
	public static int[] etats_terminaux;
	public static int[] nbre_transitions;*/
	
	static Graph g = new Graph();
	
	public static void main(String[] args){
		
		
	try {
			int i = 0;
			int arret_programme = 1;// stop la fonction à "0", continue le programme à "1"
				
		while(arret_programme != 0 && arret_programme == 1)
		{
			g.readAndStore();
			System.out.println("");
			
		//test sauvegarde info lecture
			System.out.println("Il y a "+g.valeurs_diff_arcs[0]+" valeur(s) différente(s) sur les arcs");

			System.out.println("Il y a "+g.nbre_sommets[0]+" sommet(s)");

			//affichage Sommet initiaux
			//System.out.println("Test memo_length[0] :"+ g.memo_length_SI_SF[0]);//test
			
			System.out.println("On a :"+ g.sommets_initiaux[0]+" sommets qui n'ont pas de prédécesseur");
			
			System.out.print("Le(s) sommet(s) qui n'a(n'ont) pas de prédécesseur est (sont) : ");
			
			for(i=1;i<g.memo_length_SI_SF[0];i++)// On s'arrete aux nombres totales d'informations de la ligne.
			{
				System.out.print(g.sommets_initiaux[i]+", ");
			}
			
			System.out.println(" ");// saut de ligne
			
			//affichage Sommets terminaux
			//System.out.println("Test memo_length[1] :"+ g.memo_length_SI_SF[1]);//test
			
			System.out.println("On a :"+ g.sommets_terminaux[0]+" sommets qui n'ont pas de successeur");
			
			System.out.print("Le(s) sommet(s) qui n'a(n'ont) pas de successeur est (sont) : ");
			
			for(i=1;i<g.memo_length_SI_SF[1];i++)// On s'arrete aux nombres totales d'informations de la ligne.
			{
				System.out.print(g.sommets_terminaux[i]+", ");
			}
			
			System.out.println(" ");
			System.out.println("Il y a "+g.nbre_transitions[0]+" transition(s)");
			
		do {
			 System.out.println(" Voullez-vous changer de graphe? Si oui, tapez \"1\". Sinon, arreter le programme en tapant \"0\" ");
			 Scanner input_arretP = new Scanner(System.in);
			 arret_programme = input_arretP.nextInt();
			 
			 if(arret_programme == 0 )
			 {
			   System.out.println("Fin du programme");
			 }
			
		   }while(arret_programme != 0 && arret_programme != 1);
			
			  System.out.println("");
		}
		}catch (NoSuchElementException e) 
	      {
	       System.out.println("Caca");
	       e.printStackTrace();
	      }
		
	}

}
