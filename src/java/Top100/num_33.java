package Top100;

public class num_33 {
    public static void main(String[] args) {
        int nums[]={3,1};
        int target=4;

        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {

        //find
        int len=nums.length;
        if(len==0)
            return -1;
        if(len==1){
            if(nums[0]==target){
                return 0;
            }else {
                return -1;
            }
        }
        int res=search(nums,target,0,len-1);

        return res;


    }
    public static int  search(int[] nums, int target,int left,int right) {

        if(left>right)
            return -1;

        int len=nums.length;

        int mid=left+(right-left)/2;

        int res=-1;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>nums[len-1]){
            // left is ordered
            if(target>=nums[left]&&(mid-1)>=left&&target<=nums[mid-1]){
                res=search(nums,target,left,mid-1);
            }else{
                res=search(nums,target,mid+1,right);
            }

        }else if(nums[mid]<nums[len-1]){

            // right is ordered
            if(target>=nums[mid+1]&&(mid+1)<=right&&target<=nums[right]){
                res= search(nums,target,mid+1,right);
            }else {
                res=search(nums,target,left,mid-1);
            }

        }

        return res;


    }
}
