package sort;

/**
 * 桶排序
 * 适用情况：
 * 1.数据均匀分布，不会出现很多数落在一个桶中的情况
 * 2.如果步长、桶数设置合理，每个桶适用插入排序，既能加快排序，又能保证数据的稳定性
 * @author chen yu
 * @create 2021-11-25 14:20
 */
public class BucketSortSolution {

    public void bucketSort(int[] nums){
        int len = nums.length;
        int max=nums[0];
        //第一步：找到数组中的最大值，以确定计数数组的长度
        for (int i = 0; i < len; i++) {
            if(nums[i]>max){
                max=nums[i];
            }
        }
        //第二步：计算出最大的数字有几位，这个数决定了桶的个数
        int maxNumLen=getLen(max);
        //步长 先设置一个初始值
        int step=1000;
        if(maxNumLen<5){
            // 如果最大数小于 10000
            // 3 位数就设置 100 个桶
            // 2 位数就设置 10 个桶
            step = (int) Math.pow(10, maxNumLen - 1);
        }
        // 桶的个数
        int bucketLen = max / step + 1;
        // 因为不能确定每个桶存放的数据量，因此每个桶的长度都设置为 len
        int[][] temp = new int[bucketLen][len];
        int[] next = new int[bucketLen];

        // 第 3 步：分桶
        for (int i = 0; i < len; i++) {
            // 找到所在的桶的索引
            int bucketIndex = nums[i] / step;
            // 在该桶中放入元素
            temp[bucketIndex][next[bucketIndex]] = nums[i];
            // 该桶存放的元素个数 + 1
            next[bucketIndex]++;
        }




    }

    private  int  getLen(int num){
        int count=0;
        while(num!=0){
            count++;
            num=num/10;
        }
        return count;

    }

}
