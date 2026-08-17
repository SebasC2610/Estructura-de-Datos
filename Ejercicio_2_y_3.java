import java.util.*;

public class Ejercicio_2_y_3 {
    private Map<String, List<String>> listaAdyacencia;

    public Ejercicio_2_y_3() {
        this.listaAdyacencia = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        if (vertice == null || vertice.trim().isEmpty()) {
            System.out.println("Error: Nombre de vértice inválido.");
            return;
        }
        listaAdyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(String v1, String v2) {
        if (v1 == null || v2 == null) {
            System.out.println("Error: Los vértices no pueden ser nulos.");
            return;
        }
        
        // Asegurar que existan los vértices
        agregarVertice(v1);
        agregarVertice(v2);

        // Evitar duplicados en grafos no dirigidos
        if (!listaAdyacencia.get(v1).contains(v2)) {
            listaAdyacencia.get(v1).add(v2);
        }
        if (!listaAdyacencia.get(v2).contains(v1)) {
            listaAdyacencia.get(v2).add(v1);
        }
    }

    public void mostrarGrafo() {
        System.out.println("\n--- Lista de Adyacencia ---");
        for (Map.Entry<String, List<String>> entry : listaAdyacencia.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public int obtenerGrado(String vertice) {
        if (!listaAdyacencia.containsKey(vertice)) {
            System.out.println("Error: El vértice '" + vertice + "' no existe en el grafo.");
            return -1;
        }
        return listaAdyacencia.get(vertice).size();
    }

    // Ejercicio 3: Verificación de conexidad del grafo
    public boolean esConexo() {
        if (listaAdyacencia.isEmpty()) {
            return true;
        }

        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        // Tomar el primer vértice como punto de partida
        String inicio = listaAdyacencia.keySet().iterator().next();
        
        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            for (String vecino : listaAdyacencia.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        // Es conexo si visitó todos los vértices del grafo
        return visitados.size() == listaAdyacencia.size();
    }

    public static void main(String[] args) {
        Ejercicio_2_y_3 grafo = new Ejercicio_2_y_3();

        // Agregar aristas: X–Y, Y–Z, Z–W, W–X, Y–W
        grafo.agregarArista("X", "Y");
        grafo.agregarArista("Y", "Z");
        grafo.agregarArista("Z", "W");
        grafo.agregarArista("W", "X");
        grafo.agregarArista("Y", "W");

        // Mostrar estructura del grafo
        grafo.mostrarGrafo();

        // Grado del vértice "Y"
        String verticeConsulta = "Y";
        System.out.println("\nEl grado del vértice '" + verticeConsulta + "' es: " + grafo.obtenerGrado(verticeConsulta));

        // Ejercicio 3
        System.out.println("\n--- Ejercicio 3 ---");
        System.out.println("¿El grafo es conexo?: " + (grafo.esConexo() ? "Sí" : "No"));


    }
}