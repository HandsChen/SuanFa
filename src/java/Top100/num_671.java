package Top100;

public class num_671 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);

        TreeNode t1_3=new TreeNode(3);
        TreeNode t1_2=new TreeNode(2);
        TreeNode t1_5=new TreeNode(5);
        t1.left=t1_3;
        t1.right=t1_2;
        t1_3.left=t1_5;

        TreeNode t2_1=new TreeNode(1);
        TreeNode t2_3=new TreeNode(3);
        TreeNode t2_4=new TreeNode(4);
        TreeNode t2_7=new TreeNode(7);
        t2.left=t2_1;
        t2.right=t2_3;
        t2_1.right=t2_4;
        t2_3.right=t2_7;

        show(mergeTrees(t1,t2));

    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            // 如果t1和t2为空
        if(t1==null&&t2==null){
            return null;
        }
        //创建新的结点
        TreeNode newNode;
        if(t1==null){
            newNode=t2;
            return newNode;
        }
        if(t2==null){
            newNode=t1;
            return newNode;
        }
        //t1和t2都不为空,进行深度优先遍历
        TreeNode newLeft=null;
        TreeNode newRight=null;
        newNode=new TreeNode(t1.val+t2.val);
        //如果t1没有左子树而t2有左子树，就把t2的嫁接

        newLeft=mergeTrees(t1.left,t2.left);

        newRight=mergeTrees(t1.right,t2.right);

        newNode.left=newLeft;
        newNode.right=newRight;
        return newNode;
    }
    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }
    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}