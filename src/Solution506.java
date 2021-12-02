import java.util.Arrays;
import java.util.HashMap;

/**
 * 506. 相对名次
 *
 * @author chen yu
 * @create 2021-12-02 21:50
 */
public class Solution506 {

    public String[] findRelativeRanks(int[] score) {
        int len=  score.length;
        int[]  temp= new int[len];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++){
            map.put(score[i],i);
            temp[i]=score[i];
        }
        Arrays.sort(temp);

        String[]  ans= new String[len];

        for(int i=len-1;i>=0;i--){
            int index= map.get(temp[i]);
            if(i==len-1){
                ans[ map.get(temp[i])]="Gold Medal";
            }else if(i==len-2){
                ans[map.get(temp[i])]="Silver Medal";
            }else if(i==len-3){
                ans[map.get(temp[i])]="Bronze Medal";
            }else{
                ans[map.get(temp[i])]=String.valueOf(len-i);
            }
        }

        return ans;
    }
}
