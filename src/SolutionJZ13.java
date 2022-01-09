/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * @author chen yu
 * @create 2021-12-25 11:23
 */
public class SolutionJZ13 {
    int[] dx={1,0,0,-1};
    int[] dy={0,1,-1,0};
    int count=0;
    public int movingCount(int m, int n, int k) {
        int rows=m;
        int cloumns=n;
        boolean[][] flags= new boolean[rows][cloumns];
        dfs(0,0,k,rows,cloumns,flags);
        return count;
    }


    private void dfs( int x,int y,int k,int rows,int cloumns,boolean[][] flags){
        if(indexSum(x,y,k)){
            count++;
        }else{
            return;
        }
        flags[x][y]=true;
        for(int i=0;i<4;i++){
            int newX=x+dx[i];
            int newY=y+dy[i];
            if(newY>=0&&newX>=0&&newX<rows&&newY<cloumns&&!flags[newX][newY]){
                dfs(newX,newY,k,rows,cloumns,flags);
            }
        }
    }

    private boolean indexSum(int x, int y , int k){
        int sum=0;
        while(x!=0){
            sum=sum+x%10;
            x=x/10;
        }
        while(y!=0){
            sum=sum+y%10;
            y=y/10;
        }
        return sum<=k;
    }
}
