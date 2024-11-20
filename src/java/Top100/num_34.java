package Top100;

import java.util.Arrays;

public class num_34 {

    static int leftRes=-1;
    static int rightRes=-1;
    public static void main(String[] args) {
        int nums[]={5,7,7,8,8,10};
        int target=6;
        int get[]=searchRange(nums,target);

        System.out.println(Arrays.toString(get));
    }
    public static int[] searchRange(int[] nums, int target) {

        search(nums,target,0,nums.length-1);

        int[] res=new int[2];
        res[0]=leftRes;
        res[1]=rightRes;

        return res;


    }
    public static void search(int[] nums, int target,int left,int right){
        if(left>right)
            return;
        int mid=left+(right-left)/2;

        if(nums[mid]==target){
            //sou suo
            int leftIndex=mid;
            int rightIndex=mid;

            while (leftIndex>=left&&nums[leftIndex]==target){

                leftIndex--;

            }
            while (rightIndex<=right&&nums[rightIndex]==target){

                rightIndex++;

            }

            leftRes=leftIndex+1;
            rightRes=rightIndex-1;
            return;

        }else if(nums[mid]>target){
            search(nums,target,left,mid-1);
        }else {
            search(nums,target,mid+1,right);
        }
    }

}
