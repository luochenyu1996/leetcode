

/**
 * 剑指 Offer II 105. 岛屿的最大面积
 *
 * @author chen yu
 * @create 2021-12-25 14:13
 */
public class SolutionJZ105 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0, 0, 0, 0}};
        SolutionJZ105 solutionJZ105 = new SolutionJZ105();
        int area = solutionJZ105.maxAreaOfIsland(grid);
        System.out.println(area);
    }

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] flags = new boolean[rows][columns];

        int area = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, dfs(grid, i, j, flags, 0));
                }
            }
        }
        return area;
    }


    private int dfs(int[][] grid, int x, int y, boolean[][] flags, int leaArea) {
        leaArea+=1;
        flags[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < grid.length && tempY < grid[0].length && !flags[tempX][tempY] && grid[tempX][tempY] == 1) {
                leaArea = dfs(grid, tempX, tempY, flags, leaArea);
            }
        }
        return leaArea;
    }
}
