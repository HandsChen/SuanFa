package Top100;

public class num_152 {
    public static void main(String[] args) {
        int nums[]={-2};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {

        int len=nums.length;
        if(len==0)
            return 0;

        int dp[]=new int[len+1];

        dp[0]=1;
        int res=0;
        boolean flag=false;
        for(int i=1;i<=len;i++){

            int factor=1;
            for(int j=i-1;j>=0;j--){
                factor=factor*nums[j];
                if(!flag){
                    res=factor;
                    flag=true;
                }else {
                    res = Math.max(res,factor);
                }

            }
            dp[i]=res;
        }

        return dp[len];


    }
}
