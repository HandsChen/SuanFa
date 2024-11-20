package Top100;

public class num_221 {
    public static void main(String[] args) {
        char[][] nums={{'1','0','1','1','0','1'},{'1','1','1','1','1','1'},{'0','1','1','0','1','1'},{'1','1','1','0','1','0'},{'0','1','1','1','1','1'},{'1','1','0','1','1','1'}};
        System.out.println(maximalSquare(nums));
    }
    public static int maximalSquare(char[][] matrix) {

        int row=matrix.length;
        int col=matrix[0].length;

        //将char型的数组转化为int型的
        int[][] newMatrix=new int[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                newMatrix[i][j]=matrix[i][j]-'0';

        int res=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(newMatrix[i][j]==1)
                {
                    res=Math.max(res,findMaxLen(newMatrix,i,j));
                }

            }
        }

        return res*res;

    }
    public static int  findMaxLen(int [][] matrix,int i,int j){

        int row=matrix.length;
        if(row==0){
            return 0;
        }
        int col=matrix[0].length;

        int y=j;
        int x=i;

        int step_Y=0;
        int step_X=0;
        //先向右延申
        while (y<col&&(matrix[i][y]!=0)){
            y++;
            step_Y++;
        }

        //再向下延申
        while (x<row&&(matrix[x][j]!=0)){
            x++;
            step_X++;
        }

        int step=0;
        //判断哪个小
        if(step_X>step_Y){
            step=step_Y;
        }else {
            step=step_X;
        }
        int res=1;
        //调整指针
        for(int m=step-1;m>=1;m--){
            int k=0;
            for(k=1;k<=m;k++){
                if(matrix[i+k][j+m]==0){
                    break;
                }
                if(matrix[i+m][j+k]==0){
                    break;
                }
            }
            if(k==(m+1)){
                res=Math.max(res,k);
            }else {
                res=0;
            }

        }

       return res;

    }
}
