public class ShortestPath {
    
    private Graph graph;// grafo de entrada
    private double excentricity; // excentricidad del centro del grafo


    /**
     * Constructor de la clase ShortestPath.
     *
     * @param graph El grafo de entrada.
     */

    public ShortestPath(Graph graph) {
        this.graph = graph;
        this.excentricity = 0;

    }


    public double getExcentricity() {
        return excentricity;
    }

    /**
     * Algoritmo de Floyd-Warshall para encontrar el camino más corto
     * entre todos los pares de vértices de un grafo.
     *
     * @return Un  grafo  con las distancias más cortas entre todos los pares de vértices.
     */
    public Graph FloydWarshall() {
        int size = graph.getSize();
        double[][] original = graph.getAdjacencyMatrix();
        double[][] dist = new double[size][size];

        // Copiar matriz original
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dist[i][j] = original[i][j];
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {  
                for (int j = 0; j < size; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Nuevo grafo con las distancias más cortas
        Graph distances = new Graph(size);
        distances.setAdjacencyMatrix(dist);

        return distances;
    }

    /**
     * Encuentra el centro del grafo, que es el vértice con la menor
     * excentricidad.
     *
     * @return El indice del vertice que representa el centro del grafo.
     */

    public int graphCenter() {
        Graph result = FloydWarshall();
        double[][] dist = result.getAdjacencyMatrix();
        int size = result.getSize();
        
        // Inicializar la excentricidad mínima y el índice del centro del grafo
        double minExcentricity = Double.POSITIVE_INFINITY;
        int centerIndex = -1;

        
        for (int i = 0; i < size; i++) {
            double centerExcentricity = 0;
    
            for (int j = 0; j < size; j++) {
                if (dist[i][j] > centerExcentricity) {
                    centerExcentricity = dist[i][j];
                }
            }
    
            if (centerExcentricity < minExcentricity) {
                minExcentricity = centerExcentricity;
                centerIndex = i;
            }
        }
    
        
        this.excentricity = minExcentricity;
    
        return centerIndex;
    }
    

    

    

}

