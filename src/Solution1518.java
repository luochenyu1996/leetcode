/**
 * 1518. 换酒问题
 *
 * @author chen yu
 * @create 2021-12-17 09:51
 */
public class Solution1518 {

    public static void main(String[] args) {
        Solution1518 solution1518 = new Solution1518();
        int res = solution1518.numWaterBottles(9, 3);
        System.out.println(res);

    }

    public int numWaterBottles(int numBottles, int numExchange) {
        //喝到酒的数量
        int countIn = 0;
        //当前空瓶数
        int countOut = numBottles;
        while (countOut >= numExchange) {
            int tempFull= countOut/numExchange;
            countIn=countIn+tempFull;
            countOut=countOut%numExchange;
            countOut=countOut+tempFull;

        }
        return countIn+numBottles ;
    }
}
