

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphCycleDetection {

    static class Graph {
        private int vertices;
        private List<List<Integer>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); 
        }

        public boolean isCyclic() {
            boolean[] visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) { 
                    if (isCyclicUtil(i, visited, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
            visited[v] = true;

            for (int adj : adjList.get(v)) {
                if (!visited[adj]) {
                    if (isCyclicUtil(adj, visited, v)) {
                        return true;
                    }
                } else if (adj != parent) {
                    return true; 
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isCyclic()) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }

        scanner.close();
    }
}
