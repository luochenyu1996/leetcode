import java.util.Arrays;

/**
 * 319. 灯泡开关
 *
 * @author chen yu
 * @create 2021-11-15 10:21
 */
public class Solution319 {

    public static void main(String[] args) {
        Solution319 solution319 = new Solution319();
        for(int i=1;i<30;i++) {
            solution319.bulbSwitch(i);
        }
    }

    public int bulbSwitch(int n) {
        boolean[] lights = new boolean[n + 1];
        Arrays.fill(lights,true);
        for(int i=2;i<=n;i++){
            for(int j=i;j<=n;j+=i){
                lights[j]=!lights[j];
            }
        }

        int count=0;
        System.out.println("this is ->"+n);
        for (int i = 1; i <= n; i++) {
            if(lights[i]){
                System.out.print(1);
                count++;
            }else {
                System.out.print(0);
            }
        }
        System.out.println();
        return count;

    }

}
