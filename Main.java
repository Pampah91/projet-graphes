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
		
		//System.out.println(g.nbrArcsEntreSommets(2, 9)); //test fonction
		System.out.println("\nMatrice d'adjacence du graphe :\n");
		
		g.dispAdjMatrix();
		
		
		
		System.out.println("Test demi degr� ext : ");
		System.out.println(g.ddExt(0)); // valeur rentr�e en param�tre est le sommet �tudi�
		
		System.out.println("Test demi degr� int : ");
		System.out.println(g.ddInt(0)); // valeur rentr�e en param�tre est le sommet �tudi�
		
		System.out.println("Valeur du degr� (somme de degInt et degExt : )");
		System.out.println(g.deg(0));
		
	}

}
