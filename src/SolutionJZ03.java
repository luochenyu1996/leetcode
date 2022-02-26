/**
 * 剑指 Offer 03. 数组中重复的数字
 * @author chen yu
 * @create 2022-02-26 21:36
 */
public class SolutionJZ03 {

    public static void main(String[] args) {
        int[] nums={3, 4, 2, 0, 0, 1};
        SolutionJZ03 solutionJZ03 = new SolutionJZ03();
        int repeatNumber = solutionJZ03.findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

    public int findRepeatNumber(int[] nums) {
        int len=nums.length;

        for(int i=0;i<len;i++){
            if(nums[i]!=i){
                if(nums[nums[i]]!=nums[i]){
                    swap(nums,nums[i],i);
                }else{
                    return nums[i];
                }
            }
        }
        return nums[len-1]==len-1?-1:nums[len-1];
    }

    private void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
