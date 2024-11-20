package Top100;

public class num_416 {
    public static void main(String[] args) {
        int[] nums={2,2,3,5};
        System.out.println(canPartition(nums));

    }
    public static boolean canPartition(int[] nums) {

        //首先遍历一次找出中间值
        int len=nums.length;
        int sum=0;
        for(int i=0;i<len;i++){
            sum=sum+nums[i];
        }
        //取中间值
        //判断是否为偶数
        if(sum%2!=0)
            return false;

        //以下为偶数
        int mid=sum/2;
        //再遍历一遍。看看是否有>mid或者==mid的数
        for(int j=0;j<len;j++){
            if(nums[j]==mid)
                return true;
            if(nums[j]>mid)
                return false;
        }
        //到这里都是小于mid的
        //进行0-1背包
        boolean[][] dp= new boolean[len][mid + 1];

        //填表的第一行
        if(nums[0]<=mid)
            dp[0][nums[0]]=true;

        for(int m=1;m<len;m++)
        {
            for(int n=0;n<=mid;n++){
                dp[m][n]=dp[m-1][n];
                if(nums[m]<n){
                    dp[m][n]=dp[m-1][n]||dp[m-1][n-nums[m]];
                }

            }
        }

        return dp[len-1][mid];

    }
}
