/**
 * 200. 岛屿数量
 *
 * @author chen yu
 * @create 2021-12-21 11:10
 */
public class Solution200 {

    private final int[] dx={1,0,0,-1};
    private final int[] dy={0,1,-1,0};


    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][]  grid ,int x,int y){
        if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length&& grid[x][y]=='1'){
            grid[x][y]='#';
            for (int i = 0; i < 4; i++) {
                int tempX=x+dx[i];
                int tempY=y+dy[i];
                dfs(grid ,tempX,tempY);
            }
        }



    }
}
