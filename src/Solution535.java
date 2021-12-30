import java.util.HashMap;
import java.util.Map;

/**
 * 535. TinyURL 的加密与解密
 * 这种题解会有冲突的
 * @author chen yu
 * @create 2021-12-28 21:34
 */
public class Solution535 {
    Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Solution535 solution535 = new Solution535();

        String encodeUrl = solution535.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encodeUrl);
        String decodeUrl = solution535.decode(encodeUrl);
        System.out.println(decodeUrl);

    }



    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }


}
