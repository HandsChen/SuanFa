package 动态规划;

public class num_375 {
    public static void main(String[] args) {


        System.out.println(getMoneyAmount(2));
    }
    public static int getMoneyAmount(int n) {
        if(n==1)
            return 0;
        //定义状态数组
        int state[][]=new int[n+1][n+1];
        //按照列来
        for(int j=2;j<=n;j++){
            //行的选择
            for(int i=j-1;i>=1;i--){
                 //选取分割点
                for(int k=i+1;k<=j-1;k++){
                    //算除了端点的每个分割点
                    state[i][j]=Math.min(k+Math.max(state[i][k-1],state[k+1][j]),state[i][j]);
                }
                //算两端
                state[i][j]=Math.min(state[i][j],state[i+1][j]+i);
                state[i][j]=Math.min(state[i][j],state[i][j-1]+j);
            }
        }
        return state[1][n];
    }

}
