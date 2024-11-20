package Top100;

import java.util.LinkedList;
import java.util.List;

public class num_46
{
    static List<List<Integer>> res=new LinkedList<>();
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(permute(nums));

    }
    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> track=new LinkedList<>();
        backTrack(track,nums);
        return res;


    }
    public static void backTrack(List<Integer> track,int[] nums){

            //回溯法终止条件
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        //做选择
        for(int num:nums){
            //排除当前非法选择
            if(track.contains(num))
                continue;

            //加入选择
            track.add(Integer.valueOf(num));
            //继续回溯
            backTrack(track,nums);
            //撤销操作
            track.remove(Integer.valueOf(num));

        }

    }
}
