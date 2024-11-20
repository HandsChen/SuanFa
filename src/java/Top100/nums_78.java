package Top100;

import java.util.ArrayList;
import java.util.List;

public class nums_78 {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(subsets(nums));


    }
    public static List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;

        List<List<Integer>> list=new ArrayList();
        //加入空的
        list.add(new ArrayList<Integer>());
        for(int num:nums){

            //找到list中存的每一个
            int len1= list.size();
            for(int i=0;i<len1;i++){
                //新建一个List<Integer>
                  List<Integer> item=list.get(i);
                  List<Integer> newList=new ArrayList<Integer>();
                  newList.addAll(item);
                  newList.add(num);
                  list.add(newList);

            }


        }
        return list;

    }

}
