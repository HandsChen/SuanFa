package Top100;

import java.util.ArrayList;
import java.util.List;

public class num_448 {
    public static void main(String[] args) {
        int nums[]={4,3,2,7,8,2,3,1};
        //System.out.println(Arrays.toString(findDisappearedNumbers(nums)));

    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len=nums.length;
        int ans[]=new int[len+1];
        for(int i=0;i<len;i++){
            ans[nums[i]]++;
        }
        List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=len;i++){
            if(ans[i]==0)
                list.add(i);
        }
        return list;
    }
}
