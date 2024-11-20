package Top100;

public class num_104 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);

        TreeNode t1_3=new TreeNode(3);
        TreeNode t1_2=new TreeNode(2);
        TreeNode t1_5=new TreeNode(5);
        t1.left=t1_3;
        t1.right=t1_2;
        t1_3.left=t1_5;
        System.out.println(maxDepth(t1));
    }
    public static int maxDepth(TreeNode root) {

        if(root==null)
            return 0;
        int maxdep=1;
        int leftMax=0;
        int rightMax=0;
        if(root.left!=null){
            leftMax=maxDepth(root.left);
        }
        if(root.right!=null){
            rightMax=maxDepth(root.right);
        }

        return Math.max(leftMax,rightMax)+maxdep;
    }
}
