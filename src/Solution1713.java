import java.util.*;

/**
 * 1713. 得到子序列的最少操作次数
 *
 */
public class Solution1713 {

    public static void main(String[] args) {
        int[] target = {6,4,8,1,3,2};
        int[] arr = {4,7,6,2,3,8,6,1};
        Solution1713 solution1713 = new Solution1713();
        int i = solution1713.minOperations(target, arr);
        System.out.println(i);
    }

    public int minOperations(int[] target, int[] arr) {

        //处理target
        HashMap<Integer, Integer> map = new HashMap<>();
        int lenTarget = target.length;
        for (int i = 0; i < lenTarget; i++) {
            map.put(target[i], i);
        }

        //arr 进行映射
        ArrayList<Integer> list = new ArrayList<>();
        for (int e : arr) {
            if (map.containsKey(e)) {
                list.add(map.get(e));
            }
        }

        //找 list最长的地递增子序列
        int size = list.size();
        if (size==0){
            return  lenTarget;
        }

        int[] dp = new int[size];
        dp[0]=list.get(0);
        int end = 0;
        for (int i = 0; i < size; i++) {
            if (list.get(i) > dp[end]) {
                end++;
                dp[end] = list.get(i);
            } else {
                // 进行二分查找覆盖
                binarSearch(dp, end, list.get(i));

            }

        }
        return  lenTarget-(end + 1);
    }


    private void  binarSearch( int[] dp ,int end,int insertNum){
        int left=0;
        int  right=end;
        while(left<right){
            int mid=(right+left)/2;
            if(dp[mid]<insertNum){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        dp[left]=insertNum;
    }
}
