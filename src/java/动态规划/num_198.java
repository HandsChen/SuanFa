package 动态规划;

public class num_198 {
    public static void main(String[] args) {

        int nums[]={2,7,9,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {

        int len=nums.length;
        if(len==0)
            return 0;
        if(len==1)
            return nums[0];
        int dp[]=new int[len+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=len;i++){
            dp[i]=Math.max(nums[i-1]+dp[i-2],dp[i-1]);
        }
        return dp[len];
    }
}
