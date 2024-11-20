package Top100;

public class num_543 {
    int result;
    public static void main(String[] args) {


    }
    public int diameterOfBinaryTree(TreeNode root) {
        result=1;
        depth(root);
        return result-1;


    }
    public int depth(TreeNode node){
        if(node==null)
            return 0;
        int L= depth(node.left);
        int R= depth(node.right);
        result =Math.max(result,L+R+1);
        return Math.max(L,R)+1;
    }

}
