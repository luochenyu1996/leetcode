/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 *
 * 求余运算规则： 设正整数 x, y, p,求余符号为% ，则有 (x + y) %p = (x % p + y % p)% p
 * 解析： 根据以上规则，可推出 f(n) % p = [f(n-1) % p + f(n-2)% p] % p ，从而可以在循环过程中每次计算 sum = (a + b)%1000000007,此操作与最终返回前取余等价。
 *
 *
 * @author chen yu
 * @create 2022-03-01 19:04
 */
public class SolutionJZ10_1 {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        int[]  dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
