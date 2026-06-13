import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class kahns_algorithm {
    public int[] toposort(int v, List<List<Integer>> adj){
       int[] indegree=new int[v];
        for (int i = 0; i < v; i++) {
            for (int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(indegree[i]==0)
                q.add(i);
        }

        int[] topo=new int[v];
        int i=0;
        while (!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[i++]=node;

            for (int it:adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0)
                    q.add(it);
            }
        }
        return topo;
    }

    //Detect a cycle in directed graph using kahn's algorithm
    public boolean hascycle(int v, List<List<Integer>> adj) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int[] topo = new int[v];
        int i = 0;
        int count=0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            count++;

            topo[i++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        return count != v;
    }
}
