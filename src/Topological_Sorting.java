import java.util.List;
import java.util.Stack;

public class Topological_Sorting {
    public int[] topoSort(int V, List<List<Integer>> adj){
        int[] vis=new int[V];
        Stack<Integer> st=new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i]==0)
                dfs(i, vis, st, adj);
        }

        int[] ans=new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
    }

    private void dfs(int node, int[] vis, Stack<Integer> st, List<List<Integer>> adj){
        vis[node]=1;
        for (int it: adj.get(node)){
            if (vis[it]==0)
                dfs(it, vis, st, adj);
        }
        st.push(node);
    }
}
