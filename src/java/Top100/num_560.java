package Top100;

public class num_560 {
    public static void main(String[] args) {
        int nums[]={1,1,1};
        int k=2;
        System.out.println(subarraySum(nums,k));
    }
    public static int subarraySum(int[] nums, int k) {

        //使用动态规划
        int len=nums.length;
        //定义状态转换矩阵
        int dp[]=new int[len];
        if(nums[0]==k)
            dp[0]=1;
        int sum=0;
        for(int i=1;i<len;i++){
            dp[i]=dp[i-1];
            for(int j=i;j>=0;j--){
                sum=sum+nums[j];
                if(sum==k){
                    dp[i]++;
                }

            }
            sum=0;

        }
        return dp[len-1];
    }
}
