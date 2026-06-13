import java.util.LinkedList;
import java.util.Queue;

class Triple{
    int row;
    int col;
    int time;

    public Triple(int row, int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}


public class Rotten_Oranges {
    public int rottenoranges(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        Queue<Triple> q=new LinkedList<>();
        int[][] visited=new int[n][m];
        int cntfresh=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2){
                    q.add(new Triple(i,j,0));
                    visited[i][j]=2;
                }else{
                    visited[i][j]=0;
                }

                if (grid[i][j]==1)
                    cntfresh++;
            }
        }

        int tm=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int count=0;

        //Perform BFS
        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;

            tm = Math.max(tm, t);
            q.poll();

            //Since we have only 4 directions
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int nrow = r + drow[i];
                    int ncol = c + dcol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
                        visited[nrow][ncol] = 2;
                        count++;
                        q.add(new Triple(nrow, ncol, t + 1));
                    }
                }
            }
        }
            if (count!=cntfresh)
                return -1;
        return tm;
    }
}
