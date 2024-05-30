

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphBipartiteCheck {

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

        public boolean isBipartite() {
            int[] colors = new int[vertices]; 
            for (int i = 0; i < vertices; i++) {
                colors[i] = 0; 
            }

            for (int i = 0; i < vertices; i++) {
                if (colors[i] == 0) { 
                    if (!isBipartiteUtil(i, colors)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isBipartiteUtil(int src, int[] colors) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(src);
            colors[src] = 1; 

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : adjList.get(u)) {
                    if (colors[v] == 0) {
                        colors[v] = -colors[u]; 
                        queue.add(v);
                    } else if (colors[v] == colors[u]) {
                        return false;
                    }
                }
            }
            return true;
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

        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        scanner.close();
    }
}
