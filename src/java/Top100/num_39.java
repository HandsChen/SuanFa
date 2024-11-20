package Top100;

import java.util.*;

public class num_39 {
    public static void main(String[] args) {

        int[] candidates={2,3,6,7};
        int target=7;

        System.out.println(combinationSum(candidates,target));


    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList();

        //排序
        Arrays.sort(candidates);

        dfs(new ArrayDeque<Integer>(),candidates,res,target,0);

        return res;


    }
    public static void dfs(Deque<Integer> path,int[] candidates,List<List<Integer>> res,int target,int begin){

        //终止条件
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }

        //进行选择
        for(int i=begin;i<candidates.length;i++){

            if(target-candidates[i]<0)
                break;

            //将当前结果加入路径
            path.addLast(candidates[i]);
            //进行下一一次搜索
            dfs(path,candidates,res,target-candidates[i],i);

            //撤销
            path.removeLast();
        }
    }
}
