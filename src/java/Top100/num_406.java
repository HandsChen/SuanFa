package Top100;

import java.util.*;

public class num_406 {
    public static void main(String[] args) {

    }
    public int[][] reconstructQueue(int[][] people) {

        //对数组进行排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });

        //定义一个输出队列
        List<int[]> output=new LinkedList<>();

        //将元素插入到对应索引处
        for(int[] p:people){
            output.add(p[1],p);
        }
        //输出结果
        int n=people.length;
        //将链表返回为对应格式的数组
        return output.toArray(new int[n][2]);

    }

}
