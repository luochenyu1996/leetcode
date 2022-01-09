import java.util.LinkedList;

/**
 * 994. 腐烂的橘子
 *
 * @author chen yu
 * @create 2021-12-25 11:47
 */
public class Solution994 {
    int[] dx={1,0,0,-1};
    int[] dy={0,1,-1,0};
    int step=0;

    public static void main(String[] args) {
        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        Solution994 solution994 = new Solution994();
        int i = solution994.orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        //先遍历一遍 找出已经腐烂的橘子
        LinkedList<int[]> badeQueue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]==2){
                    badeQueue.offer(new int[]{i,j});
                }
            }
        }

        while (!badeQueue.isEmpty()){
            int size = badeQueue.size();
            for (int i = 0; i < size; i++) {
                int[] outIndex = badeQueue.poll();
                //腐烂的四个方向进队
                for (int j = 0; j < 4; j++) {
                    int tempX=dx[j]+outIndex[0];
                    int tempY=dy[j]+outIndex[1];
                    if(tempX>=0&&tempY>=0&&tempX<grid.length&&tempY<grid[0].length&&grid[tempX][tempY]==1){
                        grid[tempX][tempY]=2;
                        badeQueue.offer(new int[]{tempX,tempY});
                    }
                }
            }
            step++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return step==1?step:step-1;
    }
}
