/**
 * 1034. 边界着色
 *
 * @author chen yu
 * @create 2021-12-23 11:55
 */
public class Solution1034 {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] flags = new boolean[rows][columns];
        boolean[][] colored = new boolean[rows][columns];
        dsf(grid, row, col, color, flags, grid[row][col], colored);
        return grid;
    }

    private void dsf(int[][] grid, int row, int col, int newColor, boolean[][] flags, int color, boolean[][] colored) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == color && !flags[row][col]) {
            //满足是边界的条件进行上色
            flags[row][col] = true;
            if (isOk(grid, row, col, color, colored)) {

                grid[row][col] = newColor;
                colored[row][col] = true;
            }
            for (int i = 0; i < 4; i++) {
                int tempRow = row + dx[i];
                int tempCol = col + dy[i];
                dsf(grid, tempRow, tempCol, newColor, flags, color, colored);
            }

            flags[row][col] = true;


        }


    }

    private boolean isOk(int[][] grid, int x, int y, int color, boolean[][] colored) {
        int rows = grid.length;
        int columns = grid[0].length;
        //要染色的情况
        if (x == 0 || y == 0 || x == rows - 1 || y == columns - 1) {
            return true;
        }

        if (
                grid[x - 1][y] != color && !colored[x - 1][y]
                        || grid[x + 1][y] != color && !colored[x + 1][y]
                        || grid[x][y - 1] != color && !colored[x][y - 1]
                        || grid[x][y + 1] != color && !colored[x][y + 1]
        ) {
            return true;
        }
        return false;

    }


}
