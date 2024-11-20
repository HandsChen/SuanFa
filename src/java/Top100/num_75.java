package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_75 {
    public static void main(String[] args) {
        int nums[]=new int[]{2,0,2,1,1,0};
        sortColors(nums);

        System.out.println(Arrays.toString(nums));

    }
    public static void sortColors(int[] nums) {

        List<Integer> l1=new ArrayList<Integer>();
        List<Integer> l2=new ArrayList<Integer>();
        List<Integer> l3=new ArrayList<Integer>();


        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                l1.add(nums[i]);

            if(nums[i]==1)
                l2.add(nums[i]);

            if(nums[i]==2)
                l3.add(nums[i]);
        }

        int i=0;

        for(Integer item:l1){

            nums[i]=item;
            i++;

        }
        for(Integer item:l2){

            nums[i]=item;
            i++;

        }
        for(Integer item:l3){

            nums[i]=item;
            i++;

        }



    }
}
