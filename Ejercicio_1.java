public class Ejercicio_1 {
    private int numVertices;
    private int[][] matrizAdyacencia;

    public Ejercicio_1(int numVertices) {
        if (numVertices <= 0) {
            throw new IllegalArgumentException("El número de vértices debe ser mayor a 0.");
        }
        this.numVertices = numVertices;
        this.matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Validación de límites de vértices (Base 1)
    private boolean esVerticeValido(int v) {
        return v >= 1 && v <= numVertices;
    }

    public void agregarArista(int v1, int v2) {
        if (!esVerticeValido(v1) || !esVerticeValido(v2)) {
            System.out.println("Error: Uno o ambos vértices están fuera de rango (1 - " + numVertices + ").");
            return;
        }
        // Grafo no dirigido
        matrizAdyacencia[v1 - 1][v2 - 1] = 1;
        matrizAdyacencia[v2 - 1][v1 - 1] = 1;
    }

    public boolean existeArista(int v1, int v2) {
        if (!esVerticeValido(v1) || !esVerticeValido(v2)) {
            System.out.println("Error: Vértices inválidos para la consulta.");
            return false;
        }
        return matrizAdyacencia[v1 - 1][v2 - 1] == 1;
    }

    public void mostrarMatriz() {
        System.out.println("\n--- Matriz de Adyacencia ---");
        System.out.print("   ");
        for (int i = 1; i <= numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Grafo 
        Ejercicio_1 grafo = new Ejercicio_1(4);

        // Agregar aristas
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(4, 1);
        grafo.agregarArista(1, 3);

        // Mostrar matriz
        grafo.mostrarMatriz();

        // Probar si 2 y 4 están conectados
        System.out.println("\nPrueba existeArista(2, 4): " + grafo.existeArista(2, 4));
      
    }
}