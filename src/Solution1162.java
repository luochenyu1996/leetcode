import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 *
 * @author chen yu
 * @create 2021-12-27 11:44
 */
public class Solution1162 {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
         int [][] grid= {{1,0,0},{0,0,0},{0,0,0}};
        Solution1162 solution1162 = new Solution1162();
        int nearestLand = solution1162.maxDistance(grid);
        System.out.println(nearestLand);


    }

    public int maxDistance(int[][] grid) {

        //BFS进行遍历

        LinkedList<int[]> queue = new LinkedList<>();
        int ans = -1;
        int N = grid.length;
        boolean[][] flags = new boolean[N][N];
        for (int i = 0; i <  N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    System.out.println( findNearestLand(grid,i, j));
                    ans = Math.max(ans, findNearestLand(grid,i, j));
                }
            }
        }
        return ans;
    }


    public int findNearestLand(int[][] grid, int x, int y) {
        //队列中的数组中的三位数字位   x y distance
        boolean[][] flags = new boolean[grid.length][grid.length];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y, 0});
        flags[x][y] = true;
        while (!queue.isEmpty()) {
            int[] outIndex = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int tempX = outIndex[0] + dx[i];
                int tempY = outIndex[1] + dy[i];
                if (!(tempX >= 0 && tempX < grid.length && tempY >= 0 && tempY < grid.length)) {
                    continue;
                }
                if (!flags[tempX][tempY]) {
                    queue.offer(new int[]{tempX, tempY, outIndex[2] + 1});
                    flags[tempX][tempY] = true;
                    if (grid[tempX][tempY] == 1) {
                        //碰见1 进行返回
                        return outIndex[2] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
