package 动态规划;

public class num_1139 {
    public static void main(String[] args) {
        //int grid[][]={{1,1,1},{1,0,1},{1,1,1}};
        int grid[][]={{1,1},{1,0}};
        System.out.println(largest1BorderedSquare(grid));

    }
    public static int largest1BorderedSquare(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;
        int maxNum=0;
        boolean flag=false;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    continue;
                }else {
                    flag=true;

                    maxNum=Math.max(spreadRightAndDown(i,j,row,col,grid),maxNum);
                }
            }
        }
        if (!flag)
            return 0;
        if(maxNum==0)
            return 1;
        else
            return (maxNum+1)*(maxNum+1);

    }
    public static int spreadRightAndDown(int i,int j,int row,int col, int[][] grid)
    {
        //首先对于一个点而言一直向下延申
        int forward=0;
        while( (i+forward<row)&&(j+forward<col)&&(grid[i+forward][j]==1)&&(grid[i][j+forward]==1)){
            forward++;
        }
        //到达了边界或者触达了0
        int back=forward-1;
        while(back>=0){
            //向后传播
            boolean flag1=true;
            boolean flag2=true;
            for(int m=0;m<=back;m++){
                if(grid[i+m][j+back]!=1){
                    flag1=false;
                }
            }
            for(int n=0;n<=back;n++){
                if(grid[i+back][j+n]!=1){
                    flag2=false;
                }
            }
            if(flag1&&flag2)
                return back;
            back--;
        }
        return back;
    }

}
