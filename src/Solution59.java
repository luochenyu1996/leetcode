/**
 * 59. 螺旋矩阵 II
 *
 * @author chen yu
 * @create 2022-01-09 18:15
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int leftBegin = 0;
        int rightEnd = n - 1;
        int topBegin = 0;
        int bottomEnd = n - 1;

        int[][] mat = new int[n][n];
        int num = 1;
        int total = n * n;
        while (num <= total) {
            for (int i = leftBegin; i <= rightEnd; i++) {
                mat[topBegin][i] = num++; // left to right.
            }
            topBegin++;
            for (int i = topBegin; i <= bottomEnd; i++) {
                mat[i][rightEnd] = num++; // top to bottom.
            }
            rightEnd--;
            for (int i = rightEnd; i >= leftBegin; i--) {
                mat[bottomEnd][i] = num++;// right to left.

            }
            bottomEnd--;
            for (int i = bottomEnd; i >= topBegin; i--) {
                mat[i][leftBegin] = num++; // bottom to top.
            }
            leftBegin++;
        }
        return mat;
    }


}
