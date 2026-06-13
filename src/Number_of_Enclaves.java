public class Number_of_Enclaves {
    public int numEnclaves(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        int[][] vis=new int[n][m];

        //Find the boundary '0'
        //Traverse first and last row
        for (int j = 0; j < m; j++) {
            //first row
            if (vis[0][j]==0 && mat[0][j]==1)
                dfs(0,j,vis,mat,drow,dcol);

            //last row
            if (vis[n-1][j]==0 && mat[n-1][j]==1)
                dfs(n-1,j,vis,mat,drow,dcol);
        }

        //Traverse the first and last column
        for (int i = 0; i < n; i++) {
            //first col
            if (vis[i][0]==0 && mat[i][0]==1)
                dfs(i,0,vis,mat,drow,dcol);

            //last col
            if (vis[i][m-1]==0 && mat[i][m-1]==1)
                dfs(i,m-1,vis,mat,drow,dcol);
        }

        //convert the remaining isolated '0' to 'X'
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j]==1 && vis[i][j]==0)
                    count++;
            }
        }
        return count;
    }

    public void dfs(int row, int col, int[][] vis, int[][] mat, int[] drow, int[] dcol){
        int n=mat.length;
        int m=mat[0].length;
        vis[row][col]=1;

        for (int i = 0; i < 4; i++) {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];

            if (nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==1)
                dfs(nrow, ncol, vis, mat, drow, dcol);
        }
    }
}
