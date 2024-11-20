package Top100;

public class num_437 {
    public static void main(String[] args) {

    }
    public int pathSum(TreeNode root, int sum) {

        if(root==null)
            return 0;
        int result =countPath(root, sum);
        int a = pathSum(root.left, sum);
        int b = pathSum(root.right, sum);

        return result+a+b;

    }
    public int countPath(TreeNode root,int sum){

        if(root==null)
            return 0;
        sum= sum- root.val;
        int result=0;
        if(sum==0)
            result=1;
        return result+countPath(root.left,sum)+countPath(root.right, sum);
    }

}
