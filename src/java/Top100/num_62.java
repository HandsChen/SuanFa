package Top100;

public class num_62 {
    public static void main(String[] args) {

        System.out.println(uniquePaths(7,3));

    }
    public static int uniquePaths(int m, int n) {

        if(m==1||n==1){
            return 1;
        }
        //简历状态矩阵
        int[][] dp=new int[m][n];

        //进行初始化
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }

        //进行状态转换
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }


        return dp[m-1][n-1];

    }
}
