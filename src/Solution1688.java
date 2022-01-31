/**
 * 1688. 比赛中的配对次数
 *
 * @author chen yu
 * @create 2022/1/25
 */
public class Solution1688 {
    public static void main(String[] args) {
        Solution1688 solution1688 = new Solution1688();
        int i = solution1688.numberOfMatches(7);
        System.out.println(i);
    }
    public int numberOfMatches(int n) {
        int count=0;
        while(n!=1){
            if(n%2==0){
                count+=n/2;
                n=n/2;
            }else{

                count+=(n-1)/2;
                n=(n-1)/2+1;
            }

        }
        return  count;
    }
}
