package 动态规划;

public class num_322 {
    public static void main(String[] args) {

        int coins[]={1, 2, 5};
        int amount=11;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int len=coins.length;
        if(amount==0)
            return 0;
        if(len==0)
            return -1;

        //定义状态数组
        int dp[]=new int[amount+1]; //表示为前i种硬币所能凑成面额为j的所需最小的硬币数目

        dp[0]=0;
        for(int coin:coins){

            for(int j=1;j<=amount;j++){
                //如果coin的值小于amount，那么当前硬币就可以放进去
                if(coin<=j){
                    //虽然可以放进去，但是当前硬币可以放，也可以不放，
                    dp[j]=Math.min(dp[j],dp[j-coin]+coin);
                }
            }
        }
        return dp[amount];


    }
}
