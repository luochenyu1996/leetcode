/**
 * 400. 第 N 位数字
 *
 *  1-9：9*1个数字
 *  10-99：90*2个数字
 *  100-999：900*3个数字
 *  ...
 *  根据以上规律 L 位有 ：(L*9*10^[L-1])个数字
 *
 * @author chen yu
 * @create 2021-11-30 09:16
 */
public class Solution400 {
    public int findNthDigit(int n) {
        int count=0;//数字的总个数
        int L=0;//数字长度
        long exp=1;
        //求出n所处位置的数字长度
        while(true){
            ++L;
            long num=9*L*exp;
            if(count+num>=n){
                break;
            }
            count+=num;
            exp=exp*10;
        }
        //exp就是这个区间中的最小数
        int index=n-count;//减去前面的个数
        long x=exp+(index-1)/L;//第n位所属的整数
        long i=L-(index-(x-exp)*L)+1;//答案是x的倒数第i位
        long ans = 0;
        while (i > 0){
            ans = x%10;
            x /= 10;
            --i;
        }
        return (int) ans;
    }
}
