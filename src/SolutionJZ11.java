/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author chen yu
 * @create 2022-03-01 19:17
 */
public class SolutionJZ11 {
    public int minArray(int[] numbers) {
        int index1=0;
        int index2=numbers.length-1;

         while (index1<index2){
             //mid 向下取整了
             int mid=(index1+index2)/2;
             if(numbers[mid]>numbers[index2]){
                 index1=mid+1;
             }else if(numbers[mid]<numbers[index2]){
                 //最小值会在这个范围  因此不能-1
                 index2=mid;
             }else {
                  index2--;
             }
         }
        return numbers[index1];
    }
}
