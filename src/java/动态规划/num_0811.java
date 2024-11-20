package 动态规划;

import java.util.Scanner;

public class num_0811 {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        int dp[]=new int[n+1];
        dp[0]=1;
        int coins[]=new int[]{0,1,5,10,25};
        for(int i=1;i<=4;i++){
            for(int j=1;j<=n;j++){
                //如果货币的面值小于当前的背包容量
                if(coins[i]<=j){
                    //发生状态转移
                    dp[j]=(dp[j]+dp[j-coins[i]])%1000000007;
                }
            }
        }
        System.out.println(dp[n]);
    }


}
