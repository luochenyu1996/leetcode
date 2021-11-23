import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 496. 下一个更大元素 I
 *
 * @author chen yu
 * @create 2021-10-29 11:19
 */
public class Solution469 {


    public static void main(String[] args) {

       int [] nums1 = {4,1,2};
       int []  nums2 = {1,3,4,2};

        int[] ints = nextGreaterElement(nums1, nums2);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }


    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for (int i = nums2.length-1; i>=0; i--) {
            int x=nums2[i];
            while (!stack.isEmpty()&&nums2[stack.peek()]<x){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            Integer integer = map.get(nums1[i]);
            if(integer.equals(-1)){
                ans[i]=integer;
            }else {
                ans[i]=nums2[integer];
            }
        }
        return ans;
    }

}
