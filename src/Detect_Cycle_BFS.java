import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_Cycle_BFS extends Pair {

    public Detect_Cycle_BFS(int first, int second) {
        super(first, second);
    }

    public boolean iscycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean visited[]=new boolean[V];

        //if the graph has multiple connected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
               if (checkforcycle(i,V, adj, visited)){
                   return true;
               }
            }
        }
        return false;
    }

    private boolean checkforcycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[src]=true;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));

        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();

            for (int adjacentnode: adj.get(node)){
                if (!visited[adjacentnode]){
                    visited[adjacentnode]=true;
                    q.add(new Pair(adjacentnode, node));
                }else if(parent!=adjacentnode){
                    return true;
                }
            }
        }
        return false;
    }
}
