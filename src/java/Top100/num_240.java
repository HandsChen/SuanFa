package Top100;

public class num_240 {

    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int row=matrix.length;
        if(row==0){
            return false;
        }
        int col=matrix[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++){
                if(search(matrix,i,j,target))
                    return true;
            }
        }

        return false;

    }
    public static boolean search(int[][] matrix,int i,int j,int target){
        if(matrix[i][j]==target)
            return true;
        return false;
    }


}
