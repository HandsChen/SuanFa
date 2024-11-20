package Top100;

import java.util.Arrays;

public class num_36 {
    public static void main(String[] args) {
        int nums[]={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int len=nums.length;
        if(len==1)
            return nums[0];
        Arrays.sort(nums);

        //判断开头是否为只出现一次的元素
        if(nums[0]!=nums[1])
            return nums[0];
        //判断结尾是否为只出现一次的元素
        if(nums[len-1]!=nums[len-2]){
            return nums[len-1];
        }
        //判断中间的是否为只出现一次的元素
        for(int i=1;i<len-1;i++){
            if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1])
                return nums[i];
        }

        return 0;
    }
}
