
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VertexDegree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();

        Map<Integer, Integer> degreeMap = new HashMap<>();
        
        for (int i = 0; i < vertices; i++) {
            degreeMap.put(i, 0);
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            degreeMap.put(u, degreeMap.get(u) + 1);
            degreeMap.put(v, degreeMap.get(v) + 1);
        }
        
        System.out.println("Degree of each vertex:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " : " + degreeMap.get(i));
        }

        scanner.close();
    }
}
