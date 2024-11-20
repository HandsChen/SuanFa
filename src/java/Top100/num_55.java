package Top100;

import java.util.Arrays;

public class num_55 {
    public static void main(String[] args) {
        int nums[]={3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {

        //dong tai gui hua
        int len=nums.length;
        if(len==0)
            return false;

        boolean[] dp=new boolean[len];

        dp[0]=true;

        for(int i=1;i<len;i++){
            //bianli
            for(int j=0;j<i;j++){
                if(dp[j]){
                    if((j+nums[j])>=i){
                        dp[i]=true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[len-1];
    }

}
