

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphIncidenceMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        int[][] incidenceMatrix = new int[vertices][edges];

        List<int[]> edgeList = new ArrayList<>();
        System.out.println("Enter the edges (u v) and the number of times each edge appears:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                edgeList.add(new int[]{u, v});
            }
        }

        for (int i = 0; i < edgeList.size(); i++) {
            int u = edgeList.get(i)[0];
            int v = edgeList.get(i)[1];
            incidenceMatrix[u][i]++;
            if (u != v) { 
                incidenceMatrix[v][i]++;
            }
        }

        System.out.println("The incidence matrix is:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edgeList.size(); j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
