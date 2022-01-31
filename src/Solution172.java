/**
 * 172. 阶乘后的零
 *
 * @author chen yu
 * @create 2022/1/20
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        int count=0;
        for (int i = 1; i < n; i++) {
            int temp=i;
            while (temp%5==0){
                count++;
                temp=temp/5;
            }
        }
        return count;
    }
}
