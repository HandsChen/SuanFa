package Top100;

import java.util.Arrays;

public class num_581 {
    public static void main(String[] args) {
        int nums[]={2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));

    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] snums=nums.clone();
        int len=nums.length;
        Arrays.sort(snums);
        int start=0;
        int end= len-1;
        while(start<len&&nums[start]==snums[start]){
            start++;
        }
        while(end>=0&&nums[end]==snums[end]){
            end--;
        }
        if(start>=end)
            return 0;
        else
            return end-start+1;

    }
}
