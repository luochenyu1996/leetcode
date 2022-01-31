/**
 * 5991. 按符号重排数组
 *
 * @author chen yu
 * @create 2022/1/23
 */
public class Solution5991 {

    public static void main(String[] args) {
        int[] nums={3,1,-2,-5,2,-4};
        Solution5991 solution5991 = new Solution5991();
        int[] ans = solution5991.rearrangeArray(nums);
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }


    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int len1=length/2;

        int[] negatives= new int[len1];
        int[] positives= new int[len1];

        int j=0;
        int k=0;
        for (int i = 0; i < length; i++) {
            if(nums[i]<0){
                negatives[j++]=nums[i];
            }else {
                positives[k++]=nums[i];
            }
        }

        //进行归并
        int l=0;
        int m=0;
        for (int i = 0; i < length; i++) {
            if(i%2==0){
                nums[i]=positives[l++];
            }else {
                nums[i]=negatives[m++];

            }

        }
        return  nums;

    }
}
