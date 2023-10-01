import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class dfs_stack{
    public LinkedList<Integer> adjacency[];

    public dfs_stack(int v) {
        adjacency = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacency[i] = new LinkedList<Integer>();
        }
    }

    public void insertEdge(int s, int d) {
        adjacency[s].add(d);
        adjacency[d].add(s);
    }
    public void dfs(int source){
        boolean visited_node[] = new boolean[adjacency.length];
        int parent_node[] = new int[adjacency.length];
        Stack<Integer> q = new Stack<>();
        q.add(source);
        visited_node[source] = true;
        parent_node[source] = -1;
        while(!q.isEmpty()){
            int p = q.pop();
            System.out.print(p);
            for(int i:adjacency[p]){
                if(visited_node[i] != true ){
                    visited_node[i] = true;
                    q.add(i);
                    parent_node[i] = p;

                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        dfs_stack g = new dfs_stack(v);
        System.out.println("Enter the edges: ");
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.insertEdge(s, d);
        }
        System.out.print("Enter the source for bfs traversal: ");
        int source = sc.nextInt();
        g.dfs(source);
    }
}
