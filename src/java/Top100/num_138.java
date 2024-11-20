package Top100;

import java.util.Arrays;

public class num_138 {
    public static void main(String[] args) {
        int nums[]={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }
    public static int[] productExceptSelf(int[] nums) {
            int res[]=new int[nums.length];
            int k=1;
            for(int i=0;i<res.length;i++){
                res[i]=k;
                k=k*nums[i];
            }
            k=1;
            for(int j=res.length-1;j>=0;j--){
                res[j]*=k;
                k=k*nums[j];
            }
            return res;
    }
}
