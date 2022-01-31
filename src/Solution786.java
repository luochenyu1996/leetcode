import java.util.PriorityQueue;

/**
 * 786. 第 K 个最小的素数分数
 *
 * @author chen yu
 * @create 2022/1/14
 */
public class Solution786 {
    /**
     * [1,2,3,5]
     * 递减序列
     * 1/2  1/3  1/5
     * 0    2/3  2/5
     * 0    0    3/5
     *
     */

    public static void main(String[] args) {
        int k=3;
        int[] arr={1,2,3,5};
        Solution786 solution786 = new Solution786();
        int[] ans = solution786.kthSmallestPrimeFraction(arr, k);
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;

        //首先进行第一行的填充 填充的是index
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]);
        System.out.print("初始加入的内容：");
        for (int i = 0; i < Math.min(k,len); i++) {
            System.out.print("["+arr[i]+","+arr[len-1]+"]");
            queue.add(new int[]{i,len-1});
        }
        System.out.println();

        //进行多路归并
        while (k>0&&!queue.isEmpty()){
            int[] min = queue.poll();
            System.out.println("min:"+"["+arr[min[0]]+","+arr[min[1]]+"]");
            if(k==1){
                return  new int[]{arr[min[0]],arr[min[1]]};
            }
            k--;
            //出来了  放入下一个

            if(min[1]-1>min[0]){

                System.out.println("放入的新值："+"["+arr[min[0]]+","+arr[min[1]-1]+"]");
                queue.offer(new int[]{min[0],min[1]-1});
            }
        }
        return null;
    }
}
