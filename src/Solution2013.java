import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2013. 检测正方形
 *
 * @author chen yu
 * @create 2022/1/26
 */
public class Solution2013 {
    //hash 表的形式   map[y,map[x,count]]
    Map<Integer, Map<Integer, Integer>> bigMap;

    public Solution2013() {
        bigMap = new HashMap<Integer, Map<Integer, Integer>>();
    }

    public void add(int[] point) {
        int x=point[0];
        int y=point[1];
        //按列分分类点
        bigMap.putIfAbsent(y,new HashMap<>());
        Map<Integer, Integer> smallMap = bigMap.get(y);
        smallMap.put(x,smallMap.getOrDefault(x,0)+1);
    }

    public int count(int[] point) {
        int count=0;
        int x = point[0];
        int y = point[1];
        
        if(!bigMap.containsKey(y)){
            return 0;
        }

        //如果有 则进行枚举
        Map<Integer, Integer> smallMap = bigMap.get(y);
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entrySet = bigMap.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : entrySet) {
            Integer key = entry.getKey();
            Map<Integer, Integer> value = entry.getValue();
            if(key!=y){
                int d=y-key;
                count+=smallMap.getOrDefault(x+d,0)*value.getOrDefault(x,0)*value.getOrDefault(x+d,0);
                count+=smallMap.getOrDefault(x-d,0)*value.getOrDefault(x,0)*value.getOrDefault(x-d,0);

            }
        }



        return count;

    }
    

}
