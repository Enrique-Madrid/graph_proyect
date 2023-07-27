package Main;

import Graph.Graph;

public class main {
    public static void main(String[] args) {

        Graph<String, String> graph = new Graph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");   
        graph.addVertex("E");

        graph.listVertex(); // ! Esto se imprime en consola

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("D", "C");
        graph.addEdge("C", "E");
        graph.addEdge("B", "E");

        graph.listEdge("A"); // ! Esto se imprime en consola

        graph.path("A", "E"); // ! Esto se imprime en consola
    }
}
