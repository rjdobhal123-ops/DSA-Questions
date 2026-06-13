import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Number_of_Distinct_Islands {
    public int countdistinctislands(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        HashSet<List<String>> st=new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1 && !vis[i][j]){
                    List<String> shape=new ArrayList<>();
                    DFS(i, j, i, j, grid, vis, shape );
                    st.add(shape);
                }
            }
        }
        return st.size();
    }

    private void DFS(int row, int col, int baserow, int basecol, int[][] grid, boolean[][] vis, List<String> shape) {
        int n=grid.length;
        int m=grid[0].length;

        vis[row][col]=true;
        shape.add((row-baserow) + "-" + (col-basecol));

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];

            if (nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && !vis[nrow][ncol]){
                DFS(nrow, ncol, baserow, basecol, grid, vis, shape);
            }
        }
    }
}
