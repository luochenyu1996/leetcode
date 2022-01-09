import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1629. 按键持续时间最长的键
 *
 * @author chen yu
 * @create 2022-01-09 14:01
 */
public class Solution1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int len = keysPressed.length();
        int[] diff = new int[len];

        diff[0]=releaseTimes[0];
        int max=diff[0];

        for (int i = 1; i < len; i++) {
            diff[i]=releaseTimes[i]-releaseTimes[i-1];
            max=Math.max(max,diff[i]);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < len; i++) {
            if(diff[i]==max){
                queue.offer(keysPressed.charAt(i));
            }
        }
        return queue.poll();
    }
}
