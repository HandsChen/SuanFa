package Top100;

import java.util.Arrays;
import java.util.Collections;

public class num_215 {
    public static void main(String[] args) {
        int nums[]={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));

    }
    public static int findKthLargest(int[] nums, int k) {

        Integer NUMS[]=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            NUMS[i]=nums[i];
        }
        Arrays.sort(NUMS,Collections.reverseOrder());

        for(int i=0;i<NUMS.length;i++){
            nums[i]=NUMS[i];
        }


        return nums[k-1];

    }
}
