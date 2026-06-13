import java.util.LinkedList;
import java.util.Queue;

class Triplee{
   int first;
   int second;
   int steps;

   public Triplee(int first, int second, int steps){
       this.first=first;
       this.second=second;
       this.steps=steps;
   }
}
public class Distanceofnearestcell {
    public int[][] nearest(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];

        Queue<Triplee> q=new LinkedList<>();
        //Inserting ll cells having 1 in to the queue
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1){
                    q.add(new Triplee(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }

        int[] drow={-1, 0, 1,0};
        int[] dcol={0,1,0,-1};

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().steps;
            q.remove();

            dist[row][col]=steps;

            for (int i = 0; i < 4; i++) {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if (nrow>=0 && nrow<n && ncol>=0 && ncol<m &&  vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Triplee(nrow,ncol, steps+1));
                }
            }
        }
        return dist;
    }
}
