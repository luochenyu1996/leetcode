public class Solution704 {

    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int search = solution704.search(nums, target);
        System.out.println(search);
    }
    
    public int search(int[] nums, int target) {
        int len = nums.length;

        int left=0;
        int right=len-1;

        while (left<right){
            int mid=(right+left)/2;
            if(target>nums[mid]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return  target==nums[left]?left:-1;
    }
}
