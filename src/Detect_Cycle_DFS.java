import java.util.List;

public class Detect_Cycle_DFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean visited[]=new boolean[V];

        //if the graph has multiple connected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                if (checkforcycle(i,-1, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkforcycle(int node, int parent, List<Integer>[] adj,
                                  boolean[] visited){
        visited[node]=true;

        for(int adjacentnode: adj[node]){
            if(!visited[adjacentnode]){
                if(checkforcycle(adjacentnode, node, adj, visited )){
                    return true;
                }
            }else if(parent!=adjacentnode)
                return true;
        }

        return false;
    }
}
