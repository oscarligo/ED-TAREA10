
public class Graph {

    private int size; // Numero de vertices, tamaño de la matriz
    private double[][] adjacencyMatrix; // Matriz de adyacencia
    

    /**
     * Constructor de la clase.
     *
     * @param size El número de vértices en el grafo.
     */

    public Graph(int size) {

        this.size = size;
        adjacencyMatrix = new double[size][size];
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                } else {
                    adjacencyMatrix[i][j] =  Double.POSITIVE_INFINITY; // Representa la ausencia de arista
                }
            }
        }
    }


    /**
    * Añade una arista al grafo.
    *
    * @param source      El vertice de origen.
    * @param destination El vertice de destino.
    * @param weight      El peso de la arista.
    */
    
    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getWeight(int source, int destination) {
        return adjacencyMatrix[source][destination];
    }

    public double[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(double[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    
    /**
     * Método para imprimir la matriz de adyacencia.
     */

    public void printGraph() {
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (adjacencyMatrix[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.printf("%-4s  ", "∞");
                    
                } else {
                    System.out.printf("%-4.0f  ", adjacencyMatrix[i][j]);
                }
            }

            System.out.println();
        
        }
    }

    
}
