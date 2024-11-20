package Top100;

public class num_200 {
    public static void main(String[] args) {

        char[][] grid={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {

        int row=grid.length;
        int col=grid[0].length;
        //定义一个flag矩阵
        int[][] flag=new int[row][col];
        int now=1;
        //对grid举证进行一个遍历
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&&flag[i][j]==0){

                    //进行一个渲染
                    search(grid,row,col,i,j,flag,now);

                    now=now+1;

                }
            }
        }
        //输出一下flag矩阵
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(flag[i][j]+" ");
            }
            System.out.println();
        }
        return now-1;
    }
    public static void search(char[][] grid,int row,int col,int i,int j,int[][] flag,int now){

        if(grid[i][j]=='1'){

            if(flag[i][j]==0) {
                flag[i][j]=now;
            }else
                return;
        }else {
            return;
        }


        //向上搜索
        if((i-1)>=0)
            search(grid,row,col,i-1,j,flag,now);

        //向下搜索
        if((i+1)<row)
            search(grid,row,col,i+1,j,flag,now);

        //向左搜索
        if((j-1)>=0)
            search(grid,row,col,i,j-1,flag,now);

        //向右搜索
        if((j+1)<col)
            search(grid,row,col,i,j+1,flag,now);
    }
}
