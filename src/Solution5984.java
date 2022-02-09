import java.util.Arrays;

/**
 * 5984. 拆分数位后四位数字的最小和
 *
 * @author chen yu
 * @create 2022-02-05 22:33
 */
public class Solution5984 {
    public static void main(String[] args) {

        Solution5984 solution5984 = new Solution5984();
        int i = solution5984.minimumSum(4009);
        System.out.println(i);

    }
    public int minimumSum(int num) {
        String str = String.valueOf(num);
        char[] array = str.toCharArray();
        Arrays.sort(array);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int length = array.length;

        int index=0;
        while (index<length){
            sb1.append(array[index++]);
            if(index>=length){
                break;
            }
            sb2.append(array[index++]);
        }

        Integer integer1 = Integer.valueOf(sb1.toString());
        Integer integer2 = Integer.valueOf(sb2.toString());
        return  integer1+integer2;


    }
}
