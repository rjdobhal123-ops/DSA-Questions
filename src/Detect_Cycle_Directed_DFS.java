import java.util.List;

public class Detect_Cycle_Directed_DFS {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        int[] vis=new int[N];
        int[] pathVis=new int[N];

        for(int i=0; i<N ; i++){
            if(vis[i]==0){
                if(checkdfs(i, adj, vis, pathVis)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkdfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis){
        vis[node]=1;
        pathVis[node]=1;

        for(int adjacentnode: adj.get(node)){
            if(vis[adjacentnode]==0){
                if(checkdfs(adjacentnode, adj, vis, pathVis)){
                    return true;
                }
            }else if(pathVis[adjacentnode]==1){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }
}
