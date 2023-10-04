import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class bfs_tra{
    public LinkedList<Integer> adjacency[];
 // Constructor to initialize the graph with 'v' vertices
    public bfs_tra(int v) { 
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
 // Breadth-First Search traversal of the graph starting from 'source'
    public void bfs(int source){
        boolean visited_node[] = new boolean[adjacency.length];
        int parent_node[] = new int[adjacency.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited_node[source] = true;
        parent_node[source] = -1;
        System.out.print("The BFS traversing is: ");
        while(!q.isEmpty()){
            int p = q.poll();
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
        bfs_tra g = new bfs_tra(v);
        
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
        g.bfs(source); 
    }
}