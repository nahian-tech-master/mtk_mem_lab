import java.util.Scanner;

public class dijkstra {
    public static void Dijkstra(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        boolean visited_node[] = new boolean[v];
        int distance[] = new int[v];
        distance[0] = 0;

        // Initialize distances to maximum values except for the source vertex (vertex 0)
        for (int i = 0; i < v; i++) {
            if (i != 0) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < v - 1; i++) {
            // Find the vertex with the minimum distance that has not been visited yet
            int minVertex = findMinVertex(distance, visited_node);
            visited_node[minVertex] = true;

            // Explore neighbors of the current vertex
            for (int j = 0; j < v; j++) {
                if (adjacencyMatrix[minVertex][j] != 0 && !visited_node[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                    }
                }
            }
        }

        // Print the shortest distances
        for (int i = 0; i < v; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    public static int findMinVertex(int[] distance, boolean visited_node[]) {
        int minVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited_node[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt(); // Number of vertices
        int e = s.nextInt(); // Number of edges
        int adjacencyMatrix[][] = new int[v][v];

        // Input edges and their weights
        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjacencyMatrix[v1][v2] = weight;
            adjacencyMatrix[v2][v1] = weight;
        }

        Dijkstra(adjacencyMatrix); // Call Dijkstra's algorithm
    }
}
