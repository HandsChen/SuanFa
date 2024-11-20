package 动态规划;

public class num_740 {
    public static void main(String[] args) {
        int nums[]={2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums));
    }
    public static int deleteAndEarn(int[] nums) {

        int len=nums.length;
        if(len==0)
            return 0;

        //找出数组中的最大数
        int maxNum=0;
        for(int item:nums)
        {
            maxNum=Math.max(item,maxNum);
        }

        //新建重构数组
        int newNums[]=new int[maxNum+1];
        //对新建的重构数组进行赋值
        for(int item:nums){
            newNums[item]++;
        }
        //新建状态转换矩阵
        int dp[]=new int[maxNum+1];

        dp[0]=0;
        dp[1]=newNums[1];
        for(int i=2;i<(maxNum+1);i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+i*newNums[i]);
        }
        return dp[maxNum];
    }

}
