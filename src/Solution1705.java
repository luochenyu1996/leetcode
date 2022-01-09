import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 *
 * @author chen yu
 * @create 2021-12-24 11:17
 */
public class Solution1705 {

    /**
     * 第一阶段：会长出新苹果
     *
     * 1. 将优先队列中腐烂日期小于等于当前日期的元素取出，这些苹果已经腐烂
     *
     * 2.计算出当天长出苹果的腐烂日期和数量，如果大于0，则将腐烂日期和数量加入优先队列
     *
     * 3.如果优先队列不为空，则当天可以吃一个苹果，则将优先队列队首元素数量间交易
     *
     *
     *
     * 第二阶段：不会长出新苹果

     */



        public int eatenApples(int[] apples, int[] days) {
            int ans = 0;
            //优先队列
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
            int n = apples.length;
            int i = 0;

            while (i < n) {
                //== i 天的时候苹果已经腐烂  进行出队
                while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= i) {
                    priorityQueue.poll();
                }
                //苹果到期到期时间（这一天已经开始腐烂）
                int rottenDay = i + days[i];
                //苹果的数量
                int count = apples[i];
                // i天的苹果信息加入到优先队列中
                if (count > 0) {
                    priorityQueue.offer(new int[]{rottenDay, count});
                }

                //如果优先队列中苹苹果不为空 那么进行吃苹果
                if (!priorityQueue.isEmpty()) {

                    int[] arr = priorityQueue.peek();
                    //数组取出来的是引用  直接更到队列中去了
                    arr[1]--;
                    if (arr[1] == 0) {
                        //如果数量为0了  这个苹果的信息要出队
                        priorityQueue.poll();
                    }
                    ans++;
                }
                i++;
            }


            while (!priorityQueue.isEmpty()) {
                //取出到期的苹果
                while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= i) {
                    priorityQueue.poll();
                }


                if (priorityQueue.isEmpty()) {
                    break;
                }
                int[] arr = priorityQueue.poll();
                int curr = Math.min(arr[0] - i, arr[1]);


                ans += curr;
                i += curr;
            }
            return ans;
        }
    }




