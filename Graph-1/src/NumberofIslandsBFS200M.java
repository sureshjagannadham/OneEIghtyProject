import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslandsBFS200M
{
    public static void main(String[] args)
    {
        char[][] grids = {
                {'0', '1', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '0'},
                {'1', '1', '0', '1'}
        };

        int ans = numIslands(grids);
        System.out.println(ans);

    }
    public static int numIslands(char[][] grid)
    {
        // Check for edge case: empty grid
        if (grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count =0;
        for(int row=0; row<n; row++)
        {
            for(int col=0; col<m; col++)
            {
                if(vis[row][col] == 0 && grid[row][col] == '1')
                {
                    count++;
                    isBFS(row,col,vis,grid);
                }
            }
        }
        return count;
    }

    public static void isBFS(int row, int col, int[][] vis, char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        // Directions for 4 neighboring cells (up, down, left, right)
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1} // Up, Down, Left, Right
        };
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while(!q.isEmpty())
        {
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();

            for (int[] direction : directions)
            {
                int nrow = ro + direction[0];
                int ncol = co + direction[1];

                // Check bounds and whether the cell is land and unvisited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == '1' && vis[nrow][ncol]==0)
                {
                    vis[nrow][ncol] = 1; // Mark as visited
                    q.add(new Pair(nrow, ncol)); // Add to the queue for exploration
                }
            }
        }
    }
}

class Pair
{
    int first; // Node
    int second; // Parent node
    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
