package 动态规划;

public class num_523 {
    public static void main(String[] args) {
        int nums[]={0,1,0};
        System.out.println(checkSubarraySum(nums, 0));

    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int len=nums.length;
        if(len<=1)
            return false;

        //建立状态数组
        boolean state[]=new boolean[len];
        state[0]=false;
        //状态转移
        for(int i=1;i<len;i++){
            int sum=nums[i];
            int j=i-1;
            while(j>=0){
                sum=sum+nums[j];

                //判断是否为k的倍数
                if(k==0?(sum-k)==0:sum%k==0)
                {
                    state[i]=true;
                    break;
                }
                j--;
            }
        }
        //如果状态数组种有true
        for(int i=1;i<len;i++){
            if(state[i]==true)
                return true;
        }
        return false;
    }
}
