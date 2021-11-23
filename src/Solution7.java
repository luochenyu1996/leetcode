/**
 * 7. 整数反转
 *
 * @author chen yu
 * @create 2021-11-21 21:44
 */
public class Solution7 {

    public static void main(String[] args) {
        int a=-12;
        int b=a/10;
        int c=a%10;
        System.out.println(b);
        System.out.println(c);

    }
    public int reverse(int x){
        int a=0;
        int b=0;

        while (x!=0){
            b=x%10;
            //进行越界判断
            if(a>Integer.MAX_VALUE/10||(a==Integer.MAX_VALUE/10&&b>Integer.MAX_VALUE%10)){
                return 0;
            }
            if(a<Integer.MIN_VALUE/10||(a==Integer.MIN_VALUE/10&&b<Integer.MIN_VALUE%10)){
                return 0;
            }

            a=a*10+b;
            x=x/10;
        }

        return  a;

    }
}
