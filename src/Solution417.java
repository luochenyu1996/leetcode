import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 *
 * @author chen yu
 * @create 2021-12-22 10:09
 */
public class Solution417 {

    List<List<Integer>> ans = new ArrayList<>();


    //往 太平洋 方向走
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        Solution417 solution417 = new Solution417();
        List<List<Integer>> lists = solution417.pacificAtlantic(heights);
        lists.forEach(System.out::println);

    }


    //往大西洋方向走

    public List<List<Integer>> pacificAtlantic(int[][] heights) {


        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] flags = new  boolean[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                boolean flag_sub = dfs_sub(heights, i, j,flags);
                boolean flag_add = dfs_add(heights, i, j,flags);
                if (flag_sub && flag_add) {
                    ArrayList<Integer> level = new ArrayList<>();
                    level.add(i);
                    level.add(j);
                    ans.add(level);
                }
            }
        }
        return ans;
    }


    private boolean dfs_sub(int[][] heights, int x, int y,boolean[][] flags) {
        //往天平洋方向
        if (x == 0 || y == 0) {
            return true;
        }
        flags[x][y]=true;
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < heights.length && tempY < heights[0].length &&!flags[tempX][tempY]&& heights[tempX][tempY] <= heights[x][y]) {
                if (dfs_sub(heights, tempX, tempY,flags)) {
                    flags[x][y]=false;
                    return true;
                }
            }

        }
        flags[x][y]=false;
        return false;
    }


    private boolean dfs_add(int[][] heights, int x, int y,boolean[][] flags) {
        //往天平洋方向
        if (x == heights.length - 1 || y == heights[0].length - 1) {
            return true;
        }

        flags[x][y]=true;
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX >= 0 && tempY >= 0 && tempX < heights.length && tempY < heights[0].length && !flags[tempX][tempY]&&heights[tempX][tempY] <= heights[x][y]) {
                if (dfs_add(heights, tempX, tempY,flags)) {
                    flags[x][y]=false;
                    return true;
                }
            }
        }
        flags[x][y]=false;

        return false;
    }
}
