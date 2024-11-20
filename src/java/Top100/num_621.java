package Top100;

import java.util.Arrays;

public class num_621 {
    public static void main(String[] args) {
        char[] tasks={'A','A','A','B','B','B'};
        int n=2;

        System.out.println(leastInterval(tasks,n));

    }
    public static int leastInterval(char[] tasks, int n) {

        //创建一个数组用来保存每个字母得个数
        int[] dp=new int[26];

        for(int i=0;i<tasks.length;i++){
            dp[tasks[i]-'A']++;
        }
        Arrays.sort(dp);

        int times=0;
        while(dp[25]>0){

            int i=0;

            while (i<=n){
                if(dp[25]==0){
                    break;
                }
                if(i<26&&dp[25-i]>0){
                    dp[25-i]--;
                }
                times++;
                i++;
            }

            Arrays.sort(dp);
        }
        return times;
    }
}
