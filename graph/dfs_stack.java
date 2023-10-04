import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class dfs_stack{
    public LinkedList<Integer> adjacency[];
 // Constructor to initialize the graph with 'v' vertices
    public dfs_stack(int v) {
        adjacency = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacency[i] = new LinkedList<Integer>();
        }
    }
 // Method to insert an edge between vertices 's' and 'd'
    public void insertEdge(int s, int d) {
        adjacency[s].add(d);
        adjacency[d].add(s);
    }
 // Depth-First Search traversal of the graph starting from 'source'
    public void dfs(int source){
        boolean visited_node[] = new boolean[adjacency.length];
        int parent_node[] = new int[adjacency.length];
        Stack<Integer> q = new Stack<>();
        q.add(source);
        visited_node[source] = true;
        parent_node[source] = -1;
        System.out.print("The DFS traversing is: ");
        while(!q.isEmpty()){
            int p = q.pop();
            System.out.print(" "+p);
            for(int i:adjacency[p]){
                if(visited_node[i] != true ){
                    visited_node[i] = true;
                    q.add(i);
                    parent_node[i] = p;

                }
            }
        }
        System.out.println();
        System.out.println();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();
        System.out.println();
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();
        System.out.println();
        dfs_stack g = new dfs_stack(v);
        
        for (int i = 0; i < e; i++) {
            System.out.print("Enter the edges: ");
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.insertEdge(s, d);
        }
        System.out.println();
        System.out.print("Enter the source for bfs traversal: ");
        int source = sc.nextInt();
        System.out.println();
        g.dfs(source);
    }
}
