import java.util.ArrayList;

public class Number_Of_Provinces {
    public static void main(String[] args) {
        int[][] isConnected={{1,1,0},{1,1,0}, {0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adjls=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            adjls.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }

        int visited[]=new int[n];
        int count=0;

        for(int i=0; i<n; i++){
            if(visited[i]==0){
                count++;
                dfs(i, adjls, visited);
            }
        }
        return count;
    }

    private static void dfs(int node,  ArrayList<ArrayList<Integer>> adjls, int[] visited){
        visited[node]=1;
        for(Integer it: adjls.get(node)){
            if(visited[it]==0){
                dfs(it, adjls, visited);
            }
        }
    }
}
