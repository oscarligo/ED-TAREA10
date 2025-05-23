public class Main {

    //∞ ∞ 
    public static void main(String[] args) {

        Graph rutas = new Graph(5);

        rutas.addEdge(0, 1, 3); 
        rutas.addEdge(0, 3, 7); 
        rutas.addEdge(1, 2, 1); 
        rutas.addEdge(1, 4, 8); 
        rutas.addEdge(2, 3, 2); 
        rutas.addEdge(3, 4, 3); 
        rutas.addEdge(4, 0, 4); 


        System.err.println("\nMatriz de Adyacencia:\n");
        rutas.printGraph();
        

        ShortestPath sp = new ShortestPath(rutas);

        Graph shortestPaths = sp.FloydWarshall();


        System.err.println("\nMatriz con las rutas más cortas:\n");

        shortestPaths.printGraph();

        int centerIndex = sp.graphCenter();

        System.out.println("\n");  

        if (centerIndex == 0) {
            System.out.print("El centro del grafo es Ciudad de Guatemala" + " con excentricidad: " + sp.getExcentricity());
        } else if (centerIndex == 1) {
            System.out.print("El centro del grafo es Zacapa" + " con excentricidad: " + sp.getExcentricity());
        } else if (centerIndex == 2) {
            System.out.print("El centro del grafo es Chiquimula" + " con excentricidad: " + sp.getExcentricity());
        } else if (centerIndex == 3) {
            System.out.print("El centro del grafo es Quetzaltenango" + " con excentricidad: " + sp.getExcentricity());
        } else if (centerIndex == 4) {
            System.out.print("El centro del grafo es Cobán" + " con excentricidad: " + sp.getExcentricity());
        }

        System.out.println("\n");
    
    }


    
    

    
}
