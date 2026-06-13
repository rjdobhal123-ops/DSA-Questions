import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill extends Pair {

    public Flood_Fill(int first, int second) {
        super(first, second);
    }

    //Using BFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int n=image.length;
        int m=image[0].length;

        int originalcolor=image[sr][sc];

        if (originalcolor == color) return image;

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));

        int[][] visited=new int[n][m];
        visited[sr][sc]=1;
        image[sr][sc]=color;

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();

            int[] drow={-1,0,1,0};
            int[] dcol={0,1,0,-1};

            for (int i = 0; i < 4; i++) {
                    int nrow=r+drow[i];
                    int ncol=c+dcol[i];

                    if (nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==originalcolor && visited[nrow][ncol]!=1){
                        image[nrow][ncol]=color;
                        visited[nrow][ncol]=1;
                        q.add(new Pair(nrow, ncol));
                    }
            }
        }
        return image;
    }
}
