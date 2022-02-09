import java.util.ArrayList;

/**
 * 5985. 根据给定数字划分数组
 *
 * @author chen yu
 * @create 2022-02-05 23:07
 */
public class Solution5985 {


    public static void main(String[] args) {
       int[] nums = {9,12,5,10,14,3,10};
       int pivot = 10;
        Solution5985 solution5985 = new Solution5985();
        int[] ans = solution5985.pivotArray(nums, pivot);
        for (int an : ans) {
            System.out.print(an+ " ");
        }
    }

    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> listSmall = new ArrayList<>();
        ArrayList<Integer> listEqu = new ArrayList<>();
        ArrayList<Integer> listBig = new ArrayList<>();
        int len = nums.length;
        int[] ans = new int[len];


        for (int num : nums) {
            if(num<pivot){
                listSmall.add(num);
            }else if(num>pivot){
                listBig.add(num);
            }else {
                listEqu.add(num);
            }
        }

        int index=0;
        int size1 = listSmall.size();
        for (int i = 0; i < size1; i++) {
            ans[index++]=listSmall.get(i);
        }
        int size2 = listEqu.size();
        for (int i = 0; i < size2; i++) {
            ans[index++]=listEqu.get(i);
        }
        int size3 = listBig.size();
        for (int i = 0; i < size3; i++) {
            ans[index++]=listBig.get(i);
        }
        return  ans;
    }
}
