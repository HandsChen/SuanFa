package Top100;

public class num_101 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public static boolean check(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }

        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);
    }
}
