import java.util.HashMap;

/**
 * 166. 分数到小数
 *
 * @author chen yu
 * @create 2021-11-23 14:55
 */
public class Solution166 {

    public static void main(String[] args) {
        Solution166 solution166 = new Solution166();
        String s = solution166.fractionToDecimal(2, 3);
        System.out.println(s);

    }
    public String fractionToDecimal(int numerator, int denominator) {
        //转换成long  防止溢出
        long a=numerator;
        long b=denominator;

        //1.能够整除
        if(a%b==0){
            return String.valueOf(a/b);
        }

        //2.不能够整除
        StringBuilder sb = new StringBuilder();
        //如果其中有一个为负数 先追加负号
        if(a*b<0){
            sb.append('-');
        }
        a=Math.abs(a);
        b=Math.abs(b);
        //计算小数点前面的部分
        sb.append(String.valueOf(a/b)+".");

        //考虑小数点后面的部分 模拟除法
        a=a%b;
        HashMap<Long, Integer> map = new HashMap<>();
        while (a!=0){
            map.put(a, sb.length());
            //余数加0 继续除
            a=a*10;
            //商加上到小数的位置
            sb.append(a/b);
            a=a%b;
            //如果当前余数之前出现过，则将【出现位置到当前位置】的部分扣出来 作为循环部分
            if(map.containsKey(a)){
                Integer len = map.get(a);
                return String.format("%s(%s)",sb.substring(0,len),sb.substring(len));
            }


        }
        return sb.toString();


    }
}
