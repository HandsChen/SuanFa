package Top100;

public class num_48
{
    public static void main(String[] args) {

    }
    public static void rotate(int[][] matrix) {

        int len=matrix.length;
        int temp=0;
        //首先转置矩阵
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //接下来反转矩阵的每一行
        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][len-j-1];
                matrix[i][len-j-1]=temp;
            }
        }

    }
}
