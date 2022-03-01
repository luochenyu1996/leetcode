/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * @author chen yu
 * @create 2022-03-01 19:33
 */
public class SolutionJZ12 {
    int rows;
    int columns;
    boolean[][] used;


    public boolean exist(char[][] board, String word) {
        rows=board.length;
        columns=board[0].length;
        used=new boolean[rows][columns];
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= rows|| i < 0 || j >= columns || j < 0 || used[i][j] || board[i][j]!=word[k] ) {
            return false;
        }
        if(k == word.length - 1){
            return true;
        }

        used[i][j]=true;

        //关键是下面这几行代码
        boolean res =
                dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        used[i][j]=false;
        return res;
    }
}

