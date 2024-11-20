package Top100;

import java.util.Arrays;

public class num_169 {
    public static void main(String[] args) {

        int nums[]={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        return nums[len/2];

    }
}
