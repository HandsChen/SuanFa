package 动态规划;

public class num_1025 {
    public static void main(String[] args) {

        System.out.println(divisorGame(9));
    }
    public static boolean divisorGame(int N) {

        if(N==1)
            return false;
        if(N==2)
            return true;
        if(N==3)
            return false;
        boolean dp[]=new boolean[N+1];
        dp[1]=false;
        dp[2]=true;
        dp[3]=false;
        for(int j=4;j<=N;j++) {
            boolean ans = false;
            //找出J的因子
            for (int i = 2; i <= (j / 2); i++) {
                if (j % i == 0) {
                    if(dp[j - i]==false||dp[j-1]==false)
                        ans=true;
                }
            }
            dp[j] = ans;
        }
        return dp[N];
    }
}
