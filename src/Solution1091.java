import javax.imageio.stream.ImageInputStream;
import java.util.LinkedList;

/**
 * 1091. 二进制矩阵中的最短路径
 *
 * @author chen yu
 * @create 2021-12-28 10:17
 */
public class Solution1091 {
    int[] dx = {1, 0, 0, -1, 1, 1, -1, -1};
    int[] dy = {0, 1, -1, 0, -1, 1, -1, 1};


    public static void main(String[] args) {
        Solution1091 solution1091 = new Solution1091();
        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int i = solution1091.shortestPathBinaryMatrix(grid);
        System.out.println(i);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {


        int rows = grid.length;
        int columns = grid[0].length;
        if (rows == 1 && columns == 1) {
            if (grid[0][0] == 0) {
                return 1;
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] flags = new boolean[rows][columns];
        flags[0][0] = true;
        if (grid[0][0] == 1) {
            return -1;

        } else {
            queue.offer(new int[]{0, 0, 1});

        }


        int[] outIndex = null;

        while (!queue.isEmpty()) {
            outIndex = queue.poll();
            for (int i = 0; i < 8; i++) {
                int tempX = outIndex[0] + dx[i];
                int tempY = outIndex[1] + dy[i];
                if (tempX == rows - 1 && tempY == columns - 1 && !flags[tempX][tempY]) {
                    return grid[tempX][tempY] == 0 ? outIndex[2] + 1 : -1;
                }
                if (tempX >= 0 && tempY >= 0 && tempX < rows && tempY < columns && grid[tempX][tempY] == 0 && !flags[tempX][tempY]) {
                    queue.offer(new int[]{tempX, tempY, outIndex[2] + 1});
                    flags[tempX][tempY] = true;
                }
            }
        }
        return -1;
    }
}
