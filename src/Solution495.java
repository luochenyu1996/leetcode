/**
 * 495. 提莫攻击
 *
 * @author chen yu
 * @create 2021-11-10 10:53
 */
public class Solution495 {

    public static void main(String[] args) {
        int [] timeSeries ={1,2,3,4,5};
        int duration=5;
        int out= findPoisonedDuration(timeSeries, duration);
        System.out.println(out);
    }


    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int len=timeSeries.length;
        int sumTime=0;

        for(int i=0;i<len-1;i++){
            if(timeSeries[i+1]-timeSeries[i]>=duration){
                sumTime+=duration;
            }else{
                sumTime=sumTime+timeSeries[i+1]-timeSeries[i];
            }
        }

        return sumTime+duration;

    }
}
