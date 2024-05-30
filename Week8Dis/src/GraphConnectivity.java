

import java.util.ArrayList;
import java.util.Scanner;

public class GraphConnectivity {

    static class Graph {
        private int vertices;
        private ArrayList<ArrayList<Integer>> adjList;

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

        public void DFSUtil(int v, boolean[] visited) {
            visited[v] = true;
            for (int i : adjList.get(v)) {
                if (!visited[i]) {
                    DFSUtil(i, visited);
                }
            }
        }

        public boolean isConnected() {
            boolean[] visited = new boolean[vertices];
            DFSUtil(0, visited);
            for (boolean visit : visited) {
                if (!visit) {
                    return false;
                }
            }
            return true;
        }

        public int findConnectedComponents() {
            boolean[] visited = new boolean[vertices];
            int count = 0;
            for (int v = 0; v < vertices; v++) {
                if (!visited[v]) {
                    DFSUtil(v, visited);
                    count++;
                }
            }
            return count;
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

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int components = graph.findConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + components);
        }

        scanner.close();
    }
}
