/**
 * 剑指 Offer 04. 二维数组中的查找
 * @author chen yu
 * @create 2022-02-26 21:44
 */
public class SolutionJZ04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows==0) {
            return false;
        }
        int columns = matrix[0].length;
        int right=columns-1;
        int top=0;

        while (top<rows&&right>=0){
            int x=matrix[top][right];
            if(x<target){
                top++;
            }else if(x>target){
                right--;
            }else  {
                return  true;
            }
        }
        return  false;
    }

}
