import java.util.*;

public class check {
    private int V;
    private LinkedList<Integer>[] adj;

    check(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isConnected() {
        boolean[] visited = new boolean[V];

        // Find the first non-zero degree vertex
        int i;
        for (i = 0; i < V; i++) {
            if (adj[i].size() != 0) {
                break;
            }
        }

        // If there are no edges in the graph, it's considered connected
        if (i == V) {
            return true;
        }

        // Perform DFS starting from the first non-zero degree vertex
        DFSUtil(i, visited);

        // Check if all vertices were visited during DFS
        for (i = 0; i < V; i++) {
            if (!visited[i] && adj[i].size() > 0) {
                return false;
            }
        }

        return true;
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;

        for (Integer neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        check graph = new check(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        boolean connected = graph.isConnected();
        if (connected) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }
    }
}
