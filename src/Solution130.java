/**
 * 130. 被围绕的区域
 *
 * @author chen yu
 * @create 2021-12-21 10:34
 */
public  class Solution130 {
    private final int[] dx={1,0,0,-1};
    private final int[] dy={0,1,-1,0};

    public void solve(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }

        int rows=  board.length;
        int columns=  board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                //从边界开始搜索
                boolean isEdge= i==0||j==0||i==rows-1||j==columns-1;
                if(isEdge&&board[i][j]=='O'){
                    dfs(board,i,j);
                }

            }
        }

        //进行第二次遍历
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;++j){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }

            }
        }


    }

    private void dfs(char[][] board,int x,int y){

        if(x<0||y<0||x>=board.length|| y>=board[0].length|| board[x][y]=='X'||board[x][y]=='#'){
            return ;
        }
        board[x][y]='#';

        for(int i=0;i<4;i++){
            int tempX=x+dx[i];
            int tempY=y+dy[i];
            dfs(board,tempX,tempY);
        }


    }

}

