package Top100;

public class num_79 {
    static private boolean[][] marked;
    // 盘面上有多少行
    static private int m;
    // 盘面上有多少列
    static private int n;
    static private String word;
    static private char[][] board;

    public static void main(String[] args) {
        board= new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word="ABCB";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;




    }
    public static boolean dfs(int i, int j, int start) {
        //        x-1,y
        // x,y-1  x,y    x,y+1
        //        x+1,y
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        //end contition
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    public static boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
