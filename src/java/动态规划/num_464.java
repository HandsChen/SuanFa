package 动态规划;

import java.util.Arrays;
import java.util.HashMap;

public class num_464 {
    public static void main(String[] args) {
        System.out.println(canIWin(10,11));
    }
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            //如果最大的可选择数比想要的数还要大，那么A只要选择这个数就直接赢
        if(maxChoosableInteger>=desiredTotal)
            return true;

            //  如果整个数列加起来的和都小于想要的数，那么A无论如何都不能先赢,
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal)
            return false;

        //定义状态矩阵
        int[] state=new int[maxChoosableInteger+1];
        return backtrack(state,desiredTotal,new HashMap<String,Boolean>());

    }
    public static boolean backtrack(int state[], int desiredTotal, HashMap<String,Boolean> map){

        //首先判断当前的状态
        String key= Arrays.toString(state);
        //如果当前状态已经有值，那么直接返回该值
        if(map.containsKey(key))
            return map.get(key); //将key对应的结果进行返回

        //回溯法进行选择
        for(int i=1;i<=(state.length-1);i++){
            //如果当前的数没有被选择，那么就对其进行选择
            if(state[i]==0) {
                state[i] = 1;

                //如果选了当前的i就赢了或者选了还没赢但是后面对方选择输了
                if (i >= desiredTotal || !backtrack(state, desiredTotal - i, map)) {
                    map.put(key, true);
                    //回溯
                    state[i] = 0;
                    return true;
                }
                //即使输了也要回溯
                state[i] = 0;
            }
        }
        //走到这里就说明无法获胜
        map.put(key,false);
        return false;
    }
}
