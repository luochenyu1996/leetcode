import java.util.*;

/**
 * 5973. 价格范围内最高排名的 K 样物品
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class Solution5973 {

    public static void main(String[] args) {
        int[][] grid={
                {1,1,1},
                {0,0,1},
                {2,3,4}
        };
        int[] pricing={2,3};
        int[] start={0,0};
        int k=3;

        Solution5973 solution5973 = new Solution5973();
        List<List<Integer>> lists = solution5973.highestRankedKItems(grid, pricing, start, k);
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.println();
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> {
                    //这里怎么进行排序
                    if (o1[2] - o2[2] > 0) {//距离
                        return 1;
                    } else if (o1[2] - o2[2] < 0) {
                        return -1;
                    } else if (grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]] > 0) {//价格
                        return 1;
                    } else if (grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]] < 0) {
                        return -1;
                    } else if (o1[0] - o2[0] > 0) {//行坐标
                        return 1;
                    } else if (o1[0] - o2[0] < 0) {
                        return -1;
                    } else if (o1[1] - o2[1] > 0) {//列坐标
                        return 1;
                    } else if (o1[1] - o2[1] < 0) {
                        return -1;
                    } else {
                        return 0;
                    }

                }
        );

        int rows = grid.length;
        int columns = grid[0].length;

        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] flags = new boolean[rows][columns];


        int[] dx= {1,0,0,-1};
        int[] dy= {0,-1,1,0};
        queue.offer(new int[]{start[0],start[1],0,grid[start[0]][start[1]]});
        flags[start[0]][start[1]]=true;
        if(grid[start[0]][start[1]]<=pricing[1]&& grid[start[0]][start[1]]>=pricing[0]){
            priorityQueue.offer(new int[]{start[0],start[1],0});
        }

        while (!queue.isEmpty()){
            int[] outGrid = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = outGrid[0] + dx[i];
                int tempY = outGrid[1] + dy[i];
                int step=outGrid[2]+1;

                if(tempX>=0&&tempX<rows&&tempY>=0&&tempY<columns&&grid[tempX][tempY]!=0&&!flags[tempX][tempY]){
                    queue.offer(new int[]{tempX,tempY,step});
                    flags[tempX][tempY]=true;
                    if(grid[tempX][tempY]<=pricing[1]&& grid[tempX][tempY]>=pricing[0]){
                        priorityQueue.offer(new int[]{tempX,tempY,step});
                    }
                }
            }
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()&&k>0){
            int[] out = priorityQueue.poll();
            ArrayList<Integer> l = new ArrayList<>();
            l.add(out[0]);
            l.add(out[1]);
            ans.add(l);
            k--;
        }
        return ans;
    }
}
