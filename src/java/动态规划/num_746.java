package 动态规划;

public class num_746 {
    public static void main(String[] args) {

        int cost[]={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] cost) {

        int len=cost.length;
        if(len==1)
            return cost[0];
        if(len==2)
            return cost[1];
        int dp[]=new int[len];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=3;i<=len;i++){
            dp[i-1]=Math.min(dp[i-3]+cost[i-1],cost[i-1]+dp[i-2]);
        }
        return Math.min(dp[len-1],dp[len-2]);
    }
}