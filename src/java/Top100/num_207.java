package Top100;

import java.util.*;

public class num_207 {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //统计每个课程节点的入度
        int[] indegrees=new int[numCourses];
        List<List<Integer>> adjacency=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();

        //生成邻接表
        for(int i=0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        //得到每门课的入度以及邻接表
        for(int[] cp:prerequisites){
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        //得到所有入度为0的课程节点
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0)
                queue.add(i);
        }

        //进行广度优先遍历
        while (!queue.isEmpty()){
            int pre=queue.poll(); //得到入度为0的节点值
            numCourses--; //安排了一门课

            //进行邻接表的消除
            for(int cur:adjacency.get(pre)){
                if(--indegrees[cur]==0)
                    queue.add(cur);
            }
        }
        return numCourses==0;
    }
}
