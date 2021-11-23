import java.util.HashMap;

/**
 * @author chen yu
 * @create 2021-11-09 15:03
 */
public class SolutionMD02 {

    public int maxPointsNum(Point[] points) {
        int len=points.length;
        if(points==null||len<3){
            return  points.length;
        }
        int ans=0;
        for (int i=1;i<len;++i){
            int count=0;
            long a = points[i].x;
            long b = points[i].y;
            long dx= a-points[i-1].x;
            long dy= b-points[i-1].y;
            if(dx==0&&dy==0){
                for (int j=0;j<len;++j){
                    if(points[j].x==a&&points[j].y==b){
                        count++;
                    }
                }
            }else {
                for (int j=0;j<len;++j){
                    if((points[j].x-a)*dy==(points[j].y-b)*dx){
                        count++;
                    }
                }

            }
            ans=Math.max(ans,count);

        }
        return ans;

    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
