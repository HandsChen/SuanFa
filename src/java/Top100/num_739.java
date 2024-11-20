package Top100;

import java.util.Arrays;

public class num_739 {
    public static void main(String[] args) {
        int nums[]={73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));


    }
    public static int[] dailyTemperatures(int[] T) {
        int len=T.length;
        if(len ==0)
            return null;

        for(int i=0;i<len;i++){
            int count=0;
            boolean flag=false;
            for(int j=i+1;j<len;j++){
                if(T[j]>T[i]) {
                    flag=true;
                    count++;
                    break;
                }
                else {
                    count++;
                }

            }
            if(flag)
                T[i]=count;
            else
                T[i]=0;
        }
        return T;
    }
}
