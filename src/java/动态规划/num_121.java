package 动态规划;

import java.util.Arrays;

public class num_121 {
    public static void main(String[] args) {

        int prices[]={7,6,4,3,1};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {

        int len=prices.length;
        if(len==1)
            return 0;
        int dp[]=new int[len];
        dp[0]=0;
        int minNum=prices[0];
        int maxProf=0;
        for(int i=1;i<len;i++){
            if(prices[i]>minNum){
                int curProf=prices[i]-minNum;
                if(curProf>maxProf){
                    maxProf=curProf;
                    dp[i]=curProf;
                }else {
                    dp[i]=maxProf;
                }
            }else {
                minNum=prices[i];
                dp[i]=maxProf;
            }
        }
        Arrays.sort(dp);
        return dp[len-1];
    }
}
