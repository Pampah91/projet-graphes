package graphes;

public class Main {

	/*public static int[] valeurs_diff_arcs;
	public static int[] nbre_sommets;
	public static int[] etats_initiaux;
	public static int[] etats_terminaux;
	public static int[] nbre_transitions;*/
	
	static Graph g = new Graph();
	
	public static void main(String[] args){
		
		int i = 0;
		
		g.readAndStore();
		System.out.println("");
		
		//test sauvegarde info lecture

		System.out.println("Il y a "+g.valeurs_diff_arcs[0]+" valeur(s) différente(s) sur les arcs");

		System.out.println("Il y a "+g.nbre_sommets[0]+" sommet(s)");

		System.out.println("Test memo_length :"+ g.memo_length_SI_SF[0]);//test
		
		System.out.println("On a :"+ g.sommets_initiaux[i]+" sommets qui n'ont pas de prédécesseur");
		
		System.out.print("Le(s) sommet(s) qui n'a(n'ont) pas de successeur sont : ");
		
		for(i=1;i<g.memo_length_SI_SF[0];i++)// On s'arrete aux nombres totales d'informations de la ligne.
		{
			System.out.print(g.sommets_initiaux[i]+", ");
		}
		
	}

}
