package Top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class num_347 {
    public static void main(String[] args) {
        int nums[]={1,1,1,2,2,3};
        int k=2;
        System.out.println(topKFrequent(nums,k).toString());

    }
    public static int[] topKFrequent(int[] nums, int k) {

        int len=nums.length;
        if(len==0)
            return null;

        HashMap<Integer,Integer> hs=new HashMap<Integer, Integer>();

        for(int num:nums){
            if(!hs.containsKey(num)){
                hs.put(num,1);
            }else {
                hs.put(num,hs.get(num)+1);
            }
        }

        Integer temp[][]=new Integer[hs.size()][2];

        int i=0;
        for(Map.Entry item:hs.entrySet()){
            temp[i][0]=(Integer) item.getKey();
            temp[i][1]=(Integer)item.getValue();
            i++;
        }

        Arrays.sort(temp, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1]-o1[1];
            }
        });

        int res[]=new int[k];

        for(int j=0;j<k;j++){
            res[j]=temp[j][0];
        }

        return res;

    }
}
