package 动态规划;

import java.util.HashMap;

public class num_1140 {
    public static void main(String[] args) {
        int nums[]={2,7,9,4,4};
        System.out.println(stoneGameII(nums));
    }
    public static int stoneGameII(int[] piles) {
      //  int len=piles.length;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        //dfs(i,M)表示从i位置出发向后搜索，允许拿1<=X<=2M时，在剩余石子中可以取到的最大值,因此我们最后想要的是dfs(0,1)
        //那么需要遵循这么几个原则:
        //1.如果i>len-1时，说明石子已经拿完，直接返回0
        //2.如果i+2*M>=len-1,说明可以把剩余石子一起拿掉，那么就直接返回剩余石子的数目
        //3.如果不属于以上的两种情况，我们需要遍历1<=x<=2M，求取最小的dfs(i+x,max(M,x))，也就是自己拿多少的时候，对手拿的石子最少。


        return maxStoneNum(piles,0,1,map);

    }
    //定义为从i位置出发向后搜索，允许拿1<=X<=2M时，在剩余石子中可以取到的最大值,因此我们最后想要的是maxStoneNum(0,1)
    public static int maxStoneNum(int[] piles, int i, int m, HashMap<String,Integer> map){

        int len=piles.length;
        if(i>(len-1)){
            return 0;
        }
        if((i+2*m)>=(len-1)){
            int sum=0;
            for(int j=i;j<len;j++){
                sum=sum+piles[j];
            }
            return sum;
        }
        String key=Integer.toString(i*10+m); //得到记忆key

        //如果当前key被记忆过，那么就直接返回结果
        if(map.containsKey(key)){
            return map.get(key);
        }

        //如果没有被记忆过
        int minDfs=0;
        for(int k=1;k<=2*m;k++){
            minDfs=Math.min(minDfs,maxStoneNum(piles,i+k,Math.max(m,k),map));
        }


        //返回最后的结果
        //从i位置到最后的石子和
        int sum=0;
        for(int j=i;j<len;j++){
            sum=sum+piles[j];
        }

        //进行记忆
        map.put(key,sum-minDfs);

        return sum-minDfs;

    }

}
