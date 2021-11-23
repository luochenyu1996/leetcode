/**
 * 165. 比较版本号
 *
 * @author chen yu
 * @create 2021-11-11 19:22
 */
public class Solution165 {
    public static void main(String[] args) {
        String v1 = "1.01";
        String v2 = "1.001";
        int i = compareVersion(v1, v2);
        System.out.println(i);

    }

    public static int compareVersion(String version1, String version2) {
        int point1 = 0;
        int point2 = 0;

        int len1 = version1.length();
        int len2 = version2.length();

        while (point1 < len1 || point2 < len2) {
            int num1 = 0;
            int num2 = 0;

            while (point1 < len1 && version1.charAt(point1) != '.') {
                num1 = num1 * 10 + version1.charAt(point1++) - '0';
            }
            while (point2 < len2 && version2.charAt(point2) != '.') {
                num2 = num2 * 10 + version2.charAt(point2++) - '0';
            }

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            point1++;
            point2++;
        }
        return 0;
    }

}
