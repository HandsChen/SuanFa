package Top100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class num_56 {
    public static void main(String[] args) {
        int[][] nums={{1,3},{2,6},{8,10},{15,18}};

        int res[][]=merge(nums);
        for(int i=0;i<res.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }


    }
    public static int[][] merge(int[][] intervals) {

        if(intervals.length==0){
            return new int[][]{};
        }
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        //结果list
        List<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] temp=res.get(res.size()-1);
            if(intervals[i][0]>temp[1]){
                res.add(intervals[i]);
            }else {
                //是否更新右端点
                if(intervals[i][1]>temp[1]){
                    temp[1]=intervals[i][1];
                }
            }
        }

        //转化为二维数组
        int finalRes[][]= new int[res.size()][];
        res.toArray(finalRes);

        return  finalRes;

    }
}
