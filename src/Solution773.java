import java.util.*;

/**
 * 773. 滑动谜题
 *
 * @author chen yu
 * @create 2021-12-25 09:39
 */
public class Solution773 {


    int[][] neighbor = {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {

        int rows = 2;
        int columns = 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) { // 将 2 × 3 的数组转化成字符串

            for (int j = 0; j < columns; j++) {

                //把当前状态转换为字符串
                sb.append(board[i][j]);
            }
        }

        //当前状态
        String start = sb.toString();
        //目标状态
        String target = "123450";

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        //初始状态入队
        queue.offer(start);

        visited.add(start);

        int step = 0;

        //使用队列 进行深度有限搜索
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String cur = queue.poll();
                if (target.equals(cur)) {
                    return step; // 判断是否到达目标局面
                }

                int pos = cur.indexOf('0'); // 找到数字 0 的索引
                for (int adj : neighbor[pos]) { // 将数字 0 和相邻的数字交换位置
                    String new_board = swap(cur, adj, pos);
                    if (!visited.contains(new_board)) { // 防止走回头路
                        visited.add(new_board);
                        queue.offer(new_board);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String swap(String str, int src, int dst) {

        char[] arr = str.toCharArray();

        char temp = arr[src];
        arr[src] = arr[dst];
        arr[dst] = temp;
        return new String(arr);
    }


}



