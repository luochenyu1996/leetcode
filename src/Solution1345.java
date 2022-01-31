import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class Solution1345 {
    // 方法1 ： 单向BFS

    // 方法1 ： 单向BFS
    public int minJumps(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        if (n == 1) return 0;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        // 哈希表存 value 和 index
        for (int i = 0; i < n; i++) {
            List<Integer> list = indexMap.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            indexMap.put(arr[i], list);
        }
        boolean[] visited = new boolean[n];

        //BFS使用的队列  index:在数组中的位置  step：步数
        Deque<int[]> deque = new LinkedList<>(); // int[] {index, step}
        deque.add(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int index = cur[0];
            int step = cur[1];
            // 搜到了末尾 ，因为是广度有限  因此第一个到的就是最短的
            if (index == n - 1) {
                return  step;
            }
            // 前后跳
            if (index + 1 < n && !visited[index + 1]) {
                //入队
                deque.add(new int[]{index + 1, step + 1});

                visited[index + 1] = true;
            }
            if (index - 1 >= 0 && !visited[index - 1]) {
                //入队
                deque.add(new int[]{index - 1, step + 1});

                visited[index - 1] = true;
            }

            // 等值跳
            if (indexMap.containsKey(arr[index])) {
                List<Integer> indexList = indexMap.get(arr[index]);
                for (int idx : indexList) {
                    if(!visited[idx]) {
                        deque.add(new int[]{idx, step + 1});
                        visited[idx] = true;
                    }
                }
            }
            // 这里进行了优化
            // 注意从哈希表中删除访问过的元素
            indexMap.remove(arr[index]);
        }
        return -1;
    }

}







