package Top100;

public class num_494 {
    static int count = 0;
    public static void main(String[] args) {
        int nums[]={50,37,6,20,35,41,45,3,20,36,49,1,20,10,43,4,44,15,44,34};
        int S=25;
        System.out.println(findTargetSumWays(nums,S));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public static void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }


}
