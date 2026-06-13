import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule extends Detect_Cycle_Directed_DFS   {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        int[] indegree=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0)
                q.add(i);
        }

        int[] topo=new int[numCourses];
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
        if(i==numCourses)
            return true;

        return false;
    }
}
