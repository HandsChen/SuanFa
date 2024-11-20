package 动态规划;

public class num_303 {

    int nums[];
    public static void main(String[] args) {
         int nums[]={-2, 0, 3, -5, 2, -1};
        num_303 a=new num_303(nums);
        System.out.println(a.sumRange(0,5));

    }
    public num_303 (int[] nums) {

        this.nums=nums;
    }
    public int sumRange(int i, int j) {

        int sum=0;
        for(int cur=i;cur<=j;cur++){
            sum=sum+nums[cur];
        }
        return sum;
    }

}
