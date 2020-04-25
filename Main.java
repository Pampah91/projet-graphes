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
			int arret_programme = 1;// stop la fonction � "0", continue le programme � "1"
				
		while(arret_programme != 0 && arret_programme == 1)
		{
			g.readAndStore();
			System.out.println("");
			
		//Valeur_diffarcs
			System.out.println("Il y a "+g.valeurs_diff_arcs+" valeur(s) diff�rente(s) sur les arcs");

			System.out.println("Il y a "+g.nbre_sommets+" sommet(s)");

		//Sommets initiaux
			//System.out.println("Test memo_length[0] :"+ g.memo_length_SI_SF[0]);//test
			
			System.out.println("On a :"+ g.sommets_initiaux[0]+" sommets qui n'ont pas de pr�d�cesseur");
			
			System.out.print("Le(s) sommet(s) qui n'a(n'ont) pas de pr�d�cesseur est (sont) : ");
			
			for(i=1;i<g.memo_length_SI_SF[0];i++)// On s'arrete aux nombres totales d'informations de la ligne.
			{
				System.out.print(g.sommets_initiaux[i]+", ");
			}
			
			System.out.println(" ");// saut de ligne
			
		//Sommets terminaux
			//System.out.println("Test memo_length[1] :"+ g.memo_length_SI_SF[1]);//test
			
			System.out.println("On a :"+ g.sommets_terminaux[0]+" sommets qui n'ont pas de successeur");
			
			System.out.print("Le(s) sommet(s) qui n'a(n'ont) pas de successeur est (sont) : ");
			
			for(i=1;i<g.memo_length_SI_SF[1];i++)// On s'arrete aux nombres totales d'informations de la ligne.
			{
				System.out.print(g.sommets_terminaux[i]+", ");
			}
			
		//Nbre transitions + transitions
			System.out.println(" ");
			System.out.println("Il y a "+g.nbre_transitions+" transition(s)");
			
			//System.out.println(g.transitions_int_memo);
			for(i=0;i<g.Global_valTableauSansSignetransitions.length;i++)
			{
				/*for(int j=0;j<g.Global_valTableauSansSignetransitions[i].length;j++)
				{*/
					System.out.println(g.Global_valTableauSansSignetransitions[i][0]+" --> "+g.Global_valTableauSansSignetransitions[i][2]+" = "+g.Global_valTableauSansSignetransitions[i][1]);
					//System.out.print(g.Global_valTableauSansSignetransitions[i][j]+" ");
				//} 
				//System.out.println(" ");
			}
			
		//Matrice d'adjacence
			//testSystem.out.println("le nbre d'arc entre 0 et 0 est : "+g.nbrArcsEntreSommets(0,0));
			System.out.println("\nMatrice d'adjacence du graphe :\n");
			g.dispAdjMatrix();
			
		//Degr� et demi degr�
			System.out.println("Test demi degr� ext : ");
			System.out.println(g.ddExt(0)); // valeur rentr�e en param�tre est le sommet �tudi�
			
			System.out.println("Test demi degr� int : ");
			System.out.println(g.ddInt(0)); // valeur rentr�e en param�tre est le sommet �tudi�
			
			System.out.println("Valeur du degr� (somme de degInt et degExt : )");
			System.out.println(g.deg(0));
			
		//Matrice des valeurs du graphe
			System.out.println("\nMatrice des valeurs du graphe :\n");
			g.matrice_des_valeurs();

		//Matrice d'adjacence de la fermeture transitive
			System.out.println("\nD�tection circuit: technique Roy_Marshall");
			System.out.println("Matrice d'adjacence de la fermeture transitive du graphe:\n");
			g.Matrice_adjacence_fermetureTransitive();

		//D�tecttion circuit
			System.out.println("On v�rifie la pr�sence d'un arc d'un sommet � lui m�me c'est � dire la pr�sence de \"1\" sur la diagonale.\n");
			if(g.detection_circuit())
			{
				System.out.println("Il y a au moins un circuit dans le graphe.");
			}
			else 
			{
				System.out.println("Le graphe ne contient pas de circuit.\nDonc nous pouvons faire le calcul du rang pour chaque sommet de ce graphe.");
		
		     //Calcul du rang des sommets.
				System.out.println("Initialisation du rang des sommets");
				
			}
			System.out.println("");
			
			
			
	    //test point d'entr�e
		 System.out.println("Test affichage points entr�es/sorties");	
		 System.out.print("Le graphe a-t-il un unique point d'entr�e ? ");
		 System.out.println(g.hasUniqueEntryPoint());
		 System.out.print("Le graphe a-t-il un unique point de sortie ? ");
		 System.out.println(g.hasUniqueExitPoint());
		 System.out.println();
	
			
		//Suppression de l'array list Transitions_string pour le r�initialiser lors du rebouclage.
			g.remove_arraylist_transitions_string();
			
		
			 //Recommencer le programme sans int�ruption	
		do {
			 System.out.println(" Voulez-vous changer de graphe? Si oui, tapez \"1\". Sinon, arreter le programme en tapant \"0\" ");
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
	       System.out.println("Erreur, vous n'avez pas saisi 0 ou 1!");
	       e.printStackTrace();
	      }
		
	}

}
