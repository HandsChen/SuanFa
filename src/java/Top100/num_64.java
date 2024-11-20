package Top100;

public class num_64 {
    public static void main(String[] args) {
        int[][] nums={{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(minPathSum(nums));

    }
    public static int minPathSum(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;

        if(row==0||col==0)
            return 0;

        //建立状态举证
        int[][] dp=new int[row][col];
        dp[0][0]=grid[0][0];
        //进行初始化
        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<col;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        //进行状态转换
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }


        return dp[row-1][col-1];
    }

}
