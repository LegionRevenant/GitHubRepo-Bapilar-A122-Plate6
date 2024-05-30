

import java.util.Scanner;
import java.util.Arrays;

public class GraphIsomorphismCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices for Graph 1:");
        int vertices1 = scanner.nextInt();
        System.out.println("Enter the number of edges for Graph 1:");
        int edges1 = scanner.nextInt();
        
        int[][] adjMatrix1 = new int[vertices1][vertices1];
        
        System.out.println("Enter the edges (u v) for Graph 1:");
        for (int i = 0; i < edges1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMatrix1[u][v] = 1;
            adjMatrix1[v][u] = 1; 
        }

        System.out.println("Enter the number of vertices for Graph 2:");
        int vertices2 = scanner.nextInt();
        System.out.println("Enter the number of edges for Graph 2:");
        int edges2 = scanner.nextInt();

        // Initialize the adjacency matrix for Graph 2
        int[][] adjMatrix2 = new int[vertices2][vertices2];

        // Read the edges for Graph 2
        System.out.println("Enter the edges (u v) for Graph 2:");
        for (int i = 0; i < edges2; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMatrix2[u][v] = 1;
            adjMatrix2[v][u] = 1; 
        }
        if (areIsomorphic(adjMatrix1, adjMatrix2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner.close();
    }

    private static boolean areIsomorphic(int[][] adjMatrix1, int[][] adjMatrix2) {
        int n = adjMatrix1.length;
        if (adjMatrix1.length != adjMatrix2.length) {
            return false;
        }
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        return checkPermutations(adjMatrix1, adjMatrix2, permutation, 0);
    }

    private static boolean checkPermutations(int[][] adjMatrix1, int[][] adjMatrix2, int[] permutation, int index) {
        if (index == permutation.length) {
            return areMatricesEqual(adjMatrix1, adjMatrix2, permutation);
        }

        for (int i = index; i < permutation.length; i++) {
            swap(permutation, i, index);
            if (checkPermutations(adjMatrix1, adjMatrix2, permutation, index + 1)) {
                return true;
            }
            swap(permutation, i, index); 
        }

        return false;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static boolean areMatricesEqual(int[][] adjMatrix1, int[][] adjMatrix2, int[] permutation) {
        int n = adjMatrix1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix1[i][j] != adjMatrix2[permutation[i]][permutation[j]]) {
                    return false;
                }
            }
        }
        return true;
    }
}
