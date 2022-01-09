/**
 * 79. 单词搜索
 *
 * @author chen yu
 * @create 2021-12-20 20:49
 */
public class Solution79 {
    private final int[] xArray = {1, 0, 0, -1};
    private final int[] yArray = {0, 1, -1, 0};

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Solution79 solution79 = new Solution79();
        boolean exist = solution79.exist(board, word);
        System.out.println(exist);
    }


    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] flags = new boolean[row][column];
        for(int i=0;i<row;++i){
            for(int j=0;j<column;++j){
                if(dfs(board, word, i, j, 0, flags)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index,  boolean[][] flags) {
        if (index == word.length()-1) {
            return board[x][y] == word.charAt(index);
        }
        if(board[x][y]==word.charAt(index)){
            flags[x][y]=true;
            for (int i = 0; i < 4; i++) {
                int tempX = x + xArray[i];
                int tempY = y + yArray[i];
                if ( tempX >= 0 && tempY >= 0 && tempX < board.length && tempY < board[0].length&&!flags[tempX][tempY]) {
                    if(dfs(board, word, tempX, tempY, index + 1, flags)){
                        return true;

                    }
                }
            }
            flags[x][y]=false;
        }
        return false;

    }
}



