package Top100;

import java.util.Arrays;

public class num_283 {
    public static void main(String[] args) {

        int nums[]={0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {

        int len=nums.length;
        if(len==0)
            return;
        int orderIndex=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                swap(i,orderIndex,nums);
                orderIndex++;
            }
        }
    }
    public static void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
