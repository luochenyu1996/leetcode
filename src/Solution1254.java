/**
 * 1254. 统计封闭岛屿的数目
 *
 * @author chen yu
 * @create 2021-12-23 10:50
 */
public class Solution1254 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        Solution1254 solution1254 = new Solution1254();
        int i = solution1254.closedIsland(grid);
        System.out.println(i);
    }


    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int count = 0;


        for (int i = 0; i < rows; i++) {

            dfs(grid, i, 0);
            dfs(grid, i, columns - 1);
        }

        for (int j = 0; j < columns; j++) {
            dfs(grid, 0, j);
            dfs(grid, rows-1 , j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }

        }


        return count;

    }

    private void dfs(int[][] grid, int x, int y) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
            grid[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int tempX = x + dx[i];
                int tempY = y + dy[i];
                dfs(grid, tempX, tempY);
            }
        }

    }


}
