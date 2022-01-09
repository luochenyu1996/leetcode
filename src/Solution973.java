import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 *
 * @author chen yu
 * @create 2021-12-28 18:18
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        int length = points.length;
        // index distance
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for (int i = 0; i < k; i++) {
            int distance=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            queue.offer(new int[]{i,distance});
        }

        for (int i = k; i < length; i++) {
            int distance=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if(queue.peek()[1]>distance){
                queue.poll();
                queue.offer(new int[]{i,distance});
            }
        }

        int size = queue.size();
        int[][] ans = new int[size][2];

        for (int i = 0; i < size; i++) {
            int index = queue.poll()[0];
            ans[i][0]=points[index][0];
            ans[i][1]=points[index][1];
        }
        return ans;
    }
}
