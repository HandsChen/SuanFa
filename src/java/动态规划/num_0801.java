package 动态规划;

public class num_0801 {
    public static void main(String[] args) {

        System.out.println(waysToStep(61));
    }
    public static int waysToStep(int n) {

        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        int dp[]=new int[n+1];

        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+(dp[i-2]+dp[i-3])%1000000007) % 1000000007;
        }
        return dp[n];
    }
}
