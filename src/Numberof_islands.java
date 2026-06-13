import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

public class Numberof_islands {
    public static void main(String[] args) {
        int[][] grid={{0,1,1,0},
                      {0,1,1,0},
                      {0,0,1,0},
                      {0,0,0,0},
                      {1,1,0,1}};
        System.out.println(numislands(grid));
    }
    public static int numislands(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        int[][] visited=new int[n][m];
        int count=0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (visited[row][col]==0 && grid[row][col]==1){
                    count++;
                    bfs(row, col, grid, visited);
                }
            }
        }
        return count;
    }

    private static void bfs(int row, int col, int[][] grid, int[][] visited) {
        int n=grid.length;
        int m=grid[0].length;

        visited[row][col]=1;

        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(row,col));

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();

            //Traverse in all directions and mark the lands visited as visited
            for (int delrow = -1; delrow <=1; delrow++) {
                for (int delcol = -1; delcol <=1; delcol++) {
                    int nrow=r+delrow;
                    int ncol=c+delcol;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                        visited[nrow][ncol]=1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
