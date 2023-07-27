package Graph;

import Map.Map;
import LinearDataStructures.Queue;
import java.util.Set;
import LinearDataStructures.LinkedList;

public class Graph<V, E> {

    private Map<V, LinkedList<E>> map;

    public Graph() {
        this.map = new Map<>();
    }

    public void addVertex(V key) {
        this.map.put(key, new LinkedList<>());
    }

    public void addEdge(V key, E value) {
        this.map.get(key).add(value);
    }

    public void removeVertex(V key) {
        this.map.remove(key);
    }

    public void listVertex() {
        // * El set de keys es un conjunto de strings
        Set<V> keys = this.map.keySet();
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (V key : keys) {
            sb.append(key);
            sb.append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");

        System.out.println(sb.toString());
    }

    public void listEdge(V vertex){
        // * El set de keys es un conjunto de strings
        LinkedList<E> edges = this.map.get(vertex);
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (E edge : edges) {
            sb.append(edge);
            sb.append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");

        System.out.println(sb.toString());
    }

    public void path(V start, V end) {
        LinkedList<LinkedList<V>> total_paths = new LinkedList<>();
        int total_paths_count = 0;
        // Create a queue to store the visited nodes and paths.
        Queue<LinkedList<V>> paths = new Queue<>();
        
        // Add the starting node to the visited nodes and paths.
        LinkedList<V> startPath = new LinkedList<>();
        startPath.add(start);
        paths.add(startPath);

        // Process the nodes in the queue.
        while (!paths.isEmpty()) {
            LinkedList<V> visited = paths.poll();

            System.out.println("Current path: " + visited);

            // Get the last node in the current path.
            V last = visited.get(visited.size() - 1);
            System.out.println("Current node: " + last);

            // If the goal is reached, print the complete path and terminate.
            if (last.equals(end)) {
                total_paths.add(visited);
                total_paths_count++;
                continue;
            }

            // Get the edges associated with the current node.
            LinkedList<E> edges = this.map.get(last);

            // Loop through the edges.
            for (E edge : edges) {
                // Create a new path containing the current path and the edge.
                LinkedList<V> newPath = new LinkedList<>(visited);
                newPath.add((V) edge);

                // Add the new path to the queue.
                paths.add(newPath);
            }
        }

        System.out.println("Total paths between " + start + " and " + end + ": " + total_paths_count);
        
        for (LinkedList<V> path : total_paths) {
            StringBuilder sb = new StringBuilder();
            for (V node : path) {
                sb.append(node);
                sb.append(" -> ");
            }
            sb.delete(sb.length() - 4, sb.length());
            System.out.println(sb.toString());
        }
    }


    public LinkedList<E> get(V key) {
        return this.map.get(key);
    }
}
